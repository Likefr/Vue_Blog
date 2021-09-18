package com.rz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2021-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户手机
     */
    private String telephone;

    /**
     * 用户性别 0男1女2未知
     */
    private String sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 账户状态 0正常 1停用
     */
    private String enableFlag;

    /**
     * 销号状态 0正常 1销号
     */
    private String delFlag;

    /**
     * 随机盐
     */
    private String randomSalt;

    /**
     * 用户创建时间
     */
    private LocalDateTime createDate;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginDate;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastUpdateDate;

    /**
     * 用户备注
     */
    private String remark;


}
