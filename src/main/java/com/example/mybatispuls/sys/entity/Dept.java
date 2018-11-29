package com.example.mybatispuls.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author zlx
 * @since 2018-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 排序
     */
    private Integer num;

    /**
     * 父部门id
     */
    private Integer pid;

    /**
     * 父级ids
     */
    private String pids;

    /**
     * 简称
     */
    private String simplename;

    /**
     * 全称
     */
    private String fullname;

    /**
     * 提示
     */
    private String tips;

    /**
     * 版本（乐观锁保留字段）
     */
    private Integer version;


}
