package com.example.controller;


import com.example.common.lang.Result;
import com.example.entity.Allmusic;
import com.example.entity.Songmusic;
import com.example.entity.Songsheet;
import com.example.service.AllmusicService;
import com.example.service.SongmusicService;
import com.example.service.SongsheetService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@Data
@EqualsAndHashCode(callSuper = true)
public class SongmusicController extends BaseController {
    private Integer id;
    private String singlename;
    private Object singlelist;
    private Integer length;
    @Autowired
    SongmusicService songmusicService;

    @Autowired
    SongsheetService songsheetService;

    @Autowired
    AllmusicService allmusicService;

    @GetMapping("songmusic/select/idsongsheet")
    public Result selectid(HttpServletRequest request){
        String idsongsheet=request.getParameter("idsongsheet");
        Integer idsheet=Integer.parseInt(idsongsheet);
        List<Songmusic> songmusics=songmusicService.Select(idsheet);
        Object[] arr=new Object[songmusics.size()];
        for(int k=0;k<songmusics.size();k++){
            Allmusic allmusic=allmusicService.Select(songmusics.get(k).getIdallmusic());
            arr[k]=allmusic;
        }
        return Result.succ(arr);
    }

    @GetMapping("songmusic/select")
    public Result select(HttpServletRequest request){
        String iduser=request.getParameter("iduser");
        Integer id=Integer.parseInt(iduser);
        List<Songsheet> i=songsheetService.Select(id);
        Object[] arr=new Object[i.size()];

        for(int j=0;j<i.size();j++){
            SongmusicController songmusicController=new SongmusicController();
            List<Songmusic> songmusics=songmusicService.Select(i.get(j).getIdsongsheet());
            songmusicController.setId(i.get(j).getIdsongsheet());
            songmusicController.setSinglename(i.get(j).getSongsheetname());

            //songmusicController.setSinglelist(null);
            arr[j]=songmusicController;
            Object[] brr=new Object[songmusics.size()];
            for (int k=0;k<songmusics.size();k++){
                Allmusic allmusic=allmusicService.Select(songmusics.get(k).getIdallmusic());


                brr[k]=allmusic;
                songmusicController.setSinglelist(brr);
                arr[j]=songmusicController;
            }
            songmusicController.setLength(brr.length);
            if(brr==null){
                songmusicController.setLength(0);
            }

        }
        return Result.succ(arr);
    }

    @GetMapping("songmusic/insert")
    public String insert(HttpServletRequest request){
        String idsongsheet=request.getParameter("idsongsheet");
        String idallmusic=request.getParameter("idallmusic");

        Integer idsheet=Integer.parseInt(idsongsheet);
        Integer idmusic=Integer.parseInt(idallmusic);
        Songmusic songmusic=new Songmusic();
        songmusic.setIdsongsheet(idsheet);
        songmusic.setIdallmusic(idmusic);
        songmusic.setIdsongmusic(songmusicService.list().get(songmusicService.list().size()-1).getIdsongmusic()+1);
        boolean i=songmusicService.Add(songmusic);
        if(i)
            return "添加成功";
        else
            return "添加失败";

    }

    @GetMapping("songmusic/delete")
    public String delete(HttpServletRequest request){
        String idsongsheet=request.getParameter("idsongsheet");
        String idallmusic=request.getParameter("idallmusic");
        Integer idsheet=Integer.parseInt(idsongsheet);
        Integer idall=Integer.parseInt(idallmusic);
        Songmusic songmusic=new Songmusic();
        songmusic.setIdsongsheet(idsheet);
        songmusic.setIdallmusic(idall);
        boolean i=songmusicService.Del(songmusic);
        if(i)
            return "删除成功";
        else
            return "删除失败";
    }

}
