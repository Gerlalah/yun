package cn.wolfcode.service.impl;

import cn.wolfcode.dao.VedioDao;
import cn.wolfcode.entity.T_Vedio;
import cn.wolfcode.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
/**
 * @program: SRMS
 * @description:
 * @author: Mr.Like
 * @create: 2022-08-17 17:59
 **/
@Service
public class VedioServiceImpl implements VedioService {
    @Autowired
    private VedioDao vedioMapper;
    //增加视频信息
    @Override
    public void addVedio(T_Vedio t_vedio) {
        vedioMapper.insertVedio(t_vedio);
    }

    //展示所有的文件信息
    public List<T_Vedio> videoList(){
        List<T_Vedio> t_vedios= vedioMapper.selectVedios();
        return t_vedios;
    }

    //展示单独的文件的信息
    public T_Vedio videoView(Integer t_vedio){
        T_Vedio selectVedio = vedioMapper.selectVedio(t_vedio);
        return selectVedio;
    }
    //更新视屏里面的文件信息
    @Override
    public void videoUpdate(T_Vedio t_vedio) {
        vedioMapper.updateVedio(t_vedio);
    }

    @Override
    public void videoDelete(Integer vcode) {
        vedioMapper.deleteVedio(vcode);
    }

    @Override
    public List<T_Vedio> videoListByConditions(Map<String, Object> paramMap) {
        List<T_Vedio> t_vedios = vedioMapper.selectVedioByConditions(paramMap);
        return t_vedios;
    }
}
