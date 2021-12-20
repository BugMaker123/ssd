package cn.com.ice.ordercenter.common;

/**
 * @Author: Hamsun
 * @Date: 2020/8/5 11:05
 */
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILURE(400, "业务异常"),
    MSG_NOT_READABLE(400, "消息不能读取"),
    PARAM_MISS(400, "缺少必要的请求参数"),
    PARAM_TYPE_ERROR(400, "请求参数类型错误"),
    PARAM_BIND_ERROR(400, "请求参数绑定错误"),
    PARAM_VALID_ERROR(400, "参数校验失败"),
    UN_AUTHORIZED(401, "请求未授权"),
    CLIENT_UN_AUTHORIZED(401, "客户端请求未授权"),
    REQ_REJECT(403, "请求被拒绝"),
    NOT_FOUND(404, "404 没找到请求"),
    METHOD_NOT_SUPPORTED(405, "不支持当前请求方法"),
    MEDIA_TYPE_NOT_SUPPORTED(415, "不支持当前媒体类型"),
    INTERNAL_SERVER_ERROR(500, "服务器异常"),
    SERVER_BUSY(400, "服务器繁忙,请稍后重试"),
    TIMEOUT_ERROR(500, "请求超时,请稍后重试")

    ;

    final Integer code;
    final String message;

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
