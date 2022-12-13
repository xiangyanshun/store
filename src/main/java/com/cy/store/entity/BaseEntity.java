package com.cy.store.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//作为实体类的基类
@Data
public class BaseEntity implements Serializable {
    @TableField(value = "created_user")
    private String createdUser;
    @TableField(value = "created_time")
    private Date createdTime;
    @TableField(value = "modified_user")
    private String modifiedUser;
    @TableField(value = "modified_time")
    private Date modifiedTime;
}
