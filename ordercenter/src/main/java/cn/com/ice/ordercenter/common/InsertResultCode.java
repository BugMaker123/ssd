package cn.com.ice.ordercenter.common;

/**
 * @Author: Hamsun
 * @Date: 2020/8/5 11:05
 */
public enum InsertResultCode {
    SUCCESS(200, "操作成功");



    final Integer code;
    final String message;

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    InsertResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
