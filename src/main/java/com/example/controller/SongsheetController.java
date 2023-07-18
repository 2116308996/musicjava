package com.example.controller;


import com.example.common.lang.Result;
import com.example.entity.BaseEntity;
import com.example.entity.Songmusic;
import com.example.entity.Songsheet;
import com.example.service.SongmusicService;
import com.example.service.SongsheetService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuhui
 * @since 2022-04-10
 */
@RestController

public class SongsheetController extends BaseController {
    @Autowired
    SongsheetService songsheetService;

    @Autowired
    SongmusicService songmusicService;
    @Data
    public class Music extends BaseEntity {
        private int idsongsheet;
        private int iduser;
        private String songsheetname;
        private int length;
    }

    @GetMapping("/songsheet/selectall")
    public Result selectall(HttpServletRequest request){
        Object[] musics=new Object[songsheetService.list().size()];

        for(int i=0;i<songsheetService.list().size();i++){
            List<Songmusic> songmusics=songmusicService.Select(songsheetService.list().get(i).getIdsongsheet());
            int lenght=songmusics.size();
            Music music=new Music();
            music.setLength(lenght);
            music.setIdsongsheet(songsheetService.list().get(i).getIdsongsheet());
            music.setIduser(songsheetService.list().get(i).getIduser());
            music.setSongsheetname(songsheetService.list().get(i).getSongsheetname());
            musics[i]=music;
        }
        return Result.succ(musics);
    }

    @GetMapping("/songsheet/select")
    public Result select(HttpServletRequest request)
    {
        String iduser=request.getParameter("iduser");
        Integer id=Integer.parseInt(iduser);
        List<Songsheet> i=songsheetService.Select(id);
        return Result.succ(i);
    }

    @GetMapping("/songsheet/insert")
    public String insert(HttpServletRequest request){
        String stringiduser=request.getParameter("iduser");
        String songsheetname=request.getParameter("songsheetname");
        Integer iduser=Integer.parseInt(stringiduser);
        Songsheet songsheet=new Songsheet();
        songsheet.setIdsongsheet(songsheetService.list().get(songsheetService.list().size()-1).getIdsongsheet()+1);
        songsheet.setIduser(iduser);
        songsheet.setSongsheetname(songsheetname);

        boolean i=songsheetService.Add(songsheet);
        if(i)
            return "添加成功";
        else
            return "添加失败";
    }

    @GetMapping("/songsheet/update")
    public String update(HttpServletRequest request){
        String stringidsongsheet=request.getParameter("idsongsheet");
        String songsheetname=request.getParameter("songsheetname");
        Integer idsongsheet=Integer.parseInt(stringidsongsheet);
        Songsheet songsheet=new Songsheet();
        songsheet.setIdsongsheet(idsongsheet);
        songsheet.setSongsheetname(songsheetname);
        boolean i=songsheetService.Update(songsheet);
        if(i)
            return "修改成功";
        else
            return "修改失败";
    }

    @GetMapping("/songsheet/del")
    public String del(HttpServletRequest request){
        String stringidsongsheet=request.getParameter("idsongsheet");
        Integer idsongsheet=Integer.parseInt(stringidsongsheet);
        boolean i=songsheetService.Del(idsongsheet);
        if(i)
            return "删除成功";
        else
            return "删除失败";
    }
}
