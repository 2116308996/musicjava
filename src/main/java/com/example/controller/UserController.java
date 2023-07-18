package com.example.controller;


import com.example.common.lang.Result;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuhui
 * @since 2022-03-29
 */
@RestController
//@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @GetMapping("/user/all")
    public Result user(){
        System.out.println("getuserall");
        return Result.succ(userService.list());
    }
    @ResponseBody
    @GetMapping(value="/user/select")
    public Result select(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User i=userService.Select(username);
        if(i.getPassword().equals(password)){
            return  Result.succ(i);
        }
        else {
            return Result.fail(400,"passworderror","null");
        }
    }
    @GetMapping(value="/user/insert")
    public String insert(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User();
        user.setIduser(userService.list().get(userService.list().size()-1).getIduser()+1);
        user.setAccount(username);
        user.setPassword(password);
        boolean i=userService.Add(user);
        if(i)
        return "添加成功";
        else
            return "添加失败";
    }
    @GetMapping(value="/user/update")
    public String update(HttpServletRequest request){
        String username=request.getParameter("username");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        User user=new User();
        user.setAccount(username);
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        boolean i=userService.Update(user);
        if(i)
            return "修改成功";
        else
            return "修改失败";
    }

}
