package com.example.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuhui
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Songmusic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer idsongmusic;

    private Integer idsongsheet;

    private Integer idallmusic;


}
