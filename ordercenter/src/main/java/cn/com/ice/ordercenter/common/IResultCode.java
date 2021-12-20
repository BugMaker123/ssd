package cn.com.ice.ordercenter.common;

import java.io.Serializable;

/**
 * @Author: Hamsun
 * @Date: 2020/8/5 11:04
 */
public interface IResultCode extends Serializable {

    String getMessage();

    int getCode();
}
