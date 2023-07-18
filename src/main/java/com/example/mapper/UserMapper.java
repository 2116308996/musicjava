package com.example.mapper;

import com.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuhui
 * @since 2022-03-29
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
    List<User> QueryAll();

    int del(String account);

    int insert(User user);

    User select(String account);

    int update(User user);
}
