package cn.wolfcode.service;

import cn.wolfcode.entity.T_Pic;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PicService {
    //增加图片
    void addPic(T_Pic t_pic);
    public List<T_Pic> picList();
    //更新图片信息
    public void picUpdate(T_Pic t_pic);
    //删除图片
    public void picDelete(Integer pcode);

}
