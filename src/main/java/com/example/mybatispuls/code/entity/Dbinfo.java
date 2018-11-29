package com.example.mybatispuls.code.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据库链接信息
 * </p>
 *
 * @author zlx
 * @since 2018-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("code_dbinfo")
public class Dbinfo implements Serializable {

    private static final long serialVersionUID = 1425330277382299450L;

    /**
     * 别名
     */
    private String name;

    /**
     * 数据库驱动
     */
    private String dbDriver;

    /**
     * 数据库地址
     */
    private String dbUrl;

    /**
     * 数据库账户
     */
    private String dbUserName;

    /**
     * 连接密码
     */
    private String dbPassword;

    /**
     * 数据库类型
     */
    private String dbType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
