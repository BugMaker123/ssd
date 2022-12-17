package cn.com.ice.ordercenter.enity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class UserInfo {
    private Long userId;
    private String userName;
    private String password;
    private Integer sex;
    private String remark;

}
