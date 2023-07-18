package com.example.service.impl;

import com.example.entity.Songsheet;
import com.example.entity.User;
import com.example.mapper.SongsheetMapper;
import com.example.service.SongsheetService;
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
 * @since 2022-04-10
 */
@Service
public class SongsheetServiceImpl extends ServiceImpl<SongsheetMapper, Songsheet> implements SongsheetService {

    @Autowired
    private SongsheetMapper songsheetMapper;

    @Override
    public List<Songsheet> Select(Integer iduser) {
        List<Songsheet> i=songsheetMapper.select(iduser);
        return i;
    }

    @Override
    public boolean Add(Songsheet songsheet) {
        int i=songsheetMapper.insert(songsheet);
        if(i>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean Del(Integer id) {
        int i=songsheetMapper.delete(id);
        if(i>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean Update(Songsheet songsheet) {
        int i=songsheetMapper.update(songsheet);
        if(i>0)
            return true;
        else
            return false;
    }
}
