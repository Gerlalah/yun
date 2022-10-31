package cn.wolfcode.controller;

import cn.wolfcode.entity.T_Vedio;
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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class VedioController {
    @Autowired
    VedioServiceImpl vedioService;

    //增加视频方法
    @RequestMapping("/videoadd")
    public ModelAndView videoadd(HttpServletRequest request, MultipartFile myfile) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView();
        T_Vedio t_video = new T_Vedio();
        System.out.println("进入到video方法");

        //获取文件写文件到磁盘
        try {
            InputStream inputStream = myfile.getInputStream();
            String pathName = "D:\\西南石油\\SRMS\\out\\artifacts\\SRMS_war_exploded\\video\\" +myfile.getOriginalFilename();
            System.out.println("存放的路径在"+pathName);
            OutputStream outputStream = new FileOutputStream(new File(pathName));
            //边读边写
            byte[] bytes = new byte[1024];
            //定义一个长度
            int len = 0;
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //解析数据
        //获取文件的名称
        t_video.setVname(myfile.getOriginalFilename());
        //获取文件的大小
        //使用文件大小转换工具
        FormatFileSizeUtil ffsu = new FormatFileSizeUtil();
        t_video.setVsize(ffsu.formatFileSize(myfile.getSize()));
        //获取文件的类型
        t_video.setVtype(myfile.getContentType());
        //设置文件的上传时间
        Date d= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        t_video.setVtime(sdf.format(d));
        //设置文件分类
        t_video.setVclass(request.getParameter("vclass"));
        //设置文件存储路径，采用拼接的方法
        String path = "../SRMS_war_exploded/video/"+t_video.getVname();
        path = URLDecoder.decode(path,"utf-8");
        t_video.setVurl(path);
        System.out.println("新增的视频链接地址"+t_video.getVurl());
        vedioService.addVedio(t_video);
        mav.setViewName("videoaddresult.jsp");
        return  mav;

    }
    //查看所有的视频
    @RequestMapping("/videoList")//picList.jsp
    public ModelAndView videList(){
        System.out.println("进入视频查询方法");
        List<T_Vedio> t_vedios = vedioService.videoList();
        System.out.println(t_vedios);
        ModelAndView mav= new ModelAndView();
        mav.setViewName("videoList.jsp");
        mav.addObject("videoList",t_vedios);
        return mav;
    }
    //查看单个视频的详细信息
    @RequestMapping("/videoView")
    public ModelAndView videoView(Integer vcode){
        System.out.println("进入单个视频查看详情方法");
        T_Vedio t_vedio = vedioService.videoView(vcode);
        System.out.println(t_vedio);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("videoView.jsp");
        mav.addObject("video",t_vedio);
        return mav;
    }
    //更新单个视频的信息
    @RequestMapping("videoUpdate")
    public ModelAndView videoUpdate2(T_Vedio t_vedio){
        System.out.println("进入单个视频更新的方法");
        System.out.println(t_vedio);
        vedioService.videoUpdate(t_vedio);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/videoList");
        return mav;
    }
    //在修改页面中显示视频的信息
    @RequestMapping("videoUpdateView")
    public ModelAndView videoUpdate(Integer vcode){
        //首先进行查询
        T_Vedio t_vedio = vedioService.videoView(vcode);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("videoUpdate.jsp");
        mav.addObject("video",t_vedio);
        return mav;
    }
    //删除页面信息
    @RequestMapping("videoDelete")
    public ModelAndView videoDelete(Integer vcode){
        vedioService.videoDelete(vcode);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/videoList");
        return mav;

    }
    //多条件模糊查询视频
    @RequestMapping("videoSelelctByConditions")
    public ModelAndView videoSelectByConditions(String vname,String vclass,String vstatus){
        Map<String,Object> map = new HashMap<>();
        map.put("vname",vname);
        map.put("vclass",vclass);
        map.put("vstatus",vstatus);
        System.out.println(map);
        List<T_Vedio> t_vedios = vedioService.videoListByConditions(map);
        System.out.println("进入多条件查询"+t_vedios);
        ModelAndView mav = new ModelAndView();
        if(t_vedios.toString().equals("[]")){
            mav.setViewName("videoSelectByConditionsResult.jsp");
            System.out.println("进入了这个方法吗");
        }else {
            mav.setViewName("videoList.jsp");
            mav.addObject("videoList", t_vedios);
        }
        return mav;
    }


}