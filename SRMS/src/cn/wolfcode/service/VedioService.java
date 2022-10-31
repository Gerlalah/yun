package cn.wolfcode.service;

import cn.wolfcode.entity.T_Vedio;

import java.util.List;
import java.util.Map;

/**
 * @program: SRMS
 * @description:
 * @author: Mr.Like
 * @create: 2022-08-17 17:57
 **/

public interface VedioService {
   //增加视频
    void addVedio(T_Vedio t_vedio);
    public List<T_Vedio> videoList();
    public T_Vedio videoView(Integer t_vedio);
    //更新视频信息
    public void videoUpdate(T_Vedio t_vedio);
    //删除视频
    public void videoDelete(Integer vcode);
    //多条件查询视频信息
    public List<T_Vedio> videoListByConditions(Map<String,Object> paramMap);
}
