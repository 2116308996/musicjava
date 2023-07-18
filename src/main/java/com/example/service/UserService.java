package com.example.service;

import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuhui
 * @since 2022-03-29
 */
@Service
public interface UserService extends IService<User> {
    List<User> QuertAll();

    boolean Add(User user);

    boolean Del(String account);

    User Select(String account);

    boolean Update(User user);
}
