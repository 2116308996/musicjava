package com.example.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuhui
 * @since 2022-03-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer iduser;

    private String account;

    private String password;

    private String name;

    private String sex;

    private String age;

    private String headimage;


}
