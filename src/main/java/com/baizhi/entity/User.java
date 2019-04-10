package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: buxy
 * @Date: 2019/3/21  10:56
 * @Id 用在属性上 声明是主键
 * @Table  用在类上   声明数据库的表名
 * @Colum  用在属性上  用来指定数据库表中的字段名称
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    private String id;
    @Column(name = "name")
    private String username;
    private Integer age;
    private Date bir;
}
