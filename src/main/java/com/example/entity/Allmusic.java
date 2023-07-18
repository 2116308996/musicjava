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
public class Allmusic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String singer;

    private String time;

    private String type;

    private String lyric;


}
