package cn.com.ice.ordercenter.enity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderInfo implements Serializable {

    private Long id;

    private Integer transportStatus;

    private String goodInfo;

    private String  evaluate;

    private String store;

    private String createUserId;

    private String createUserName;

    private Date createTime;

}
