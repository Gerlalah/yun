package cn.wolfcode.service.impl;

import cn.wolfcode.dao.PictureDao;
import cn.wolfcode.entity.T_Pic;
import cn.wolfcode.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @program: SRMS
*
* @description:
*
* @author: Mr.Like
*
* @create: 2022-08-24 20:10
**/
@Service
public class PicServiceImpl implements PicService {
    @Autowired
    private PictureDao picMapper;
    @Override
    public void addPic(T_Pic t_pic) {
        picMapper.addpic(t_pic);
    }

    @Override
    public List<T_Pic> picList() {

        List<T_Pic> selectpic = picMapper.selectpic();
        return selectpic;
    }

    @Override
    public void picUpdate(T_Pic t_pic) {

    }

    @Override
    public void picDelete(Integer pcode) {
        picMapper.deletepic(pcode);
    }


}
