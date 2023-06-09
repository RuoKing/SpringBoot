package spring.SpringBoot.entry;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * subscribe_info
 * @author 
 */
@Data
public class SubscribeInfo implements Serializable {
    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 订阅者钱包
     */
    private String subscriberWallet;

    /**
     * 被订阅者钱包
     */
    private String subscribeeWallet;

    private Byte status;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}