package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuhui
 * @since 2022-03-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> QuertAll() {
        List<User> users=userMapper.QueryAll();
        return users;
    }

    @Override
    public boolean Add(User user) {
        int i=userMapper.insert(user);
        if(i>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean Del(String account) {
        int i=userMapper.del(account);
        if(i>0)
            return true;
        else
            return false;
    }

    @Override
    public User Select(String account) {
        User i=userMapper.select(account);
       return i;
    }

    @Override
    public boolean Update(User user) {
        int i=userMapper.update(user);
        if(i>0)
            return true;
        else
            return false;
    }
}
