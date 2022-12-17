package cn.com.ice.ordercenter.aspect;

import cn.com.ice.ordercenter.common.ResultCode;
import cn.com.ice.ordercenter.common.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class ExclusiveLockAspect {


    @Autowired
    private IExclusiveLock iExclusiveLock;

    /**
     * 前置处理
     */
    @Pointcut("@annotation(cn.com.ice.ordercenter.aspect.ExclusiveLock)")
    public void pointCut(){

    }


    /**
     * 针对切面处理
     * @param pjp
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        log.info("around");
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 注解类可能被代理，需要获取真实类的注解
        Class<?> targetClass = pjp.getTarget().getClass();
        Method targetMethod = targetClass.getDeclaredMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        // 获取方法注解
        ExclusiveLock annotation = AnnotationUtils.findAnnotation(targetMethod, ExclusiveLock.class);
        assert annotation != null;
        // 获取分布式锁的key
        String key=getLockKey(targetMethod,pjp,annotation);
        boolean lockFlag =false;
        Object proceed =null;
        try {
            lockFlag=iExclusiveLock.tryLock(key,annotation.timeUnit(),annotation.waitTime(),annotation.leaseTime());
            if (lockFlag) {
                log.info("success to get distributed lock with key {}",key);
                proceed = pjp.proceed();
            }
        } catch (Exception exception) {
            log.error("exception occurred while getting distributed lock ",exception);
            return ResultModel.createResult(ResultCode.FAILURE.getCode(),exception.getMessage());
        }finally {
            if (lockFlag){
                iExclusiveLock.unlock(key);
                log.info("lock {} has been released",key);
            }
        }
        return proceed;

    }

    private String getLockKey(Method targetMethod, ProceedingJoinPoint pjp, ExclusiveLock annotation) {
        return null;
    }

    /**
     * 异常处理
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
    public void exceptionThrowable(JoinPoint joinPoint, Throwable e){

    }

}
