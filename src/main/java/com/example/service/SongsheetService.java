package com.example.service;

import com.example.entity.Songsheet;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuhui
 * @since 2022-04-10
 */
@Service
public interface SongsheetService extends IService<Songsheet> {

    List<Songsheet> Select(Integer iduser);

    boolean Add(Songsheet songsheet);

    boolean Del(Integer id);

    boolean Update(Songsheet songsheet);
}
