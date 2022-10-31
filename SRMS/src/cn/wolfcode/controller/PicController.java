package cn.wolfcode.controller;

import cn.wolfcode.entity.T_Pic;
import cn.wolfcode.entity.T_Vedio;
import cn.wolfcode.service.PicService;
import cn.wolfcode.service.impl.PicServiceImpl;
import cn.wolfcode.service.impl.VedioServiceImpl;
import cn.wolfcode.util.FormatFileSizeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SRMS
 * @description:
 * @author: Mr.Like
 * @create: 2022-08-17 18:00
 **/
@RestController
public class PicController {
    @Autowired
    PicServiceImpl picService;

    //增加图片方法
    @RequestMapping("/picadd")
    public ModelAndView picadd(T_Pic t_pic) {
        ModelAndView mav =new ModelAndView();
        t_pic.setPtime(new Date(System.currentTimeMillis()));
        picService.addPic(t_pic);
        mav.setViewName("picList");
        return  mav;

    }
    //查看所有的视频
    @RequestMapping("/picList")//picList.jsp
    public ModelAndView videList(){
        System.out.println("进入到此方法");
        List<T_Pic> t_pics = picService.picList();
        for (T_Pic t_pic:t_pics)
            System.out.println(t_pic);
        ModelAndView mav= new ModelAndView();
        mav.setViewName("picture.jsp");
        System.out.println("设置返回视图");
        mav.addObject("picList",t_pics);
        System.out.println("设置图片列表");
        return mav;
    }


    //删除页面信息
    @RequestMapping("picDelete")
    public ModelAndView picDelete(Integer pcode){
        picService.picDelete(pcode);
        ModelAndView mav = new ModelAndView();
        System.out.println("到这个方法");
        mav.setViewName("/picList");
        return mav;

    }


}