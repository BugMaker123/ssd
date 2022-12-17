package cn.com.ice.ordercenter.enity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderInfo implements Serializable {

    private Long id;

    private String primaryBusinessId;

    private String orderNo;

    private Integer payStatus;

    private String goodInfo;

    private String createUserId;

    private String createUserName;

    private Date createTime;

}
