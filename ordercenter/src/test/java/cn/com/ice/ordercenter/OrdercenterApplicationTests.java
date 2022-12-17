package cn.com.ice.ordercenter;

import cn.com.ice.ordercenter.enity.UserInfo;
import cn.com.ice.ordercenter.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class OrdercenterApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserInfoMapper userMapper;
    
    @Test
    public void saveData(){
        log.info("test");
        for (int i = 0; i < 100; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("userName"+i);
            userInfo.setPassword("password"+i);
            userInfo.setSex(i%2);
            userInfo.setRemark("remark"+i);
            userMapper.insert(userInfo);
        }
        log.info("test end");

    }

    @Test
    public void queryData(){
        log.info("test");
        List<UserInfo> list = userMapper.selectList(null);
        for (int i = 0; i < list.size(); i++) {
            log.info("userInfo:{}",list.get(i).toString());
        }
        log.info("test end");
    }


}
