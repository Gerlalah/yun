package cn.wolfcode.dao;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_Vedio;
import cn.wolfcode.entity.T_priviage;
import java.util.*;
/**
 * @program: SRMS
 * @description:
 * @author: Mr.Like
 * @create: 2022-08-17 17:38
 **/

public interface VedioDao {
    //新增视频
    void insertVedio(T_Vedio vedio);
    //查询所有视频
    List<T_Vedio> selectVedios();
    //查看单独的视频
    T_Vedio selectVedio(Integer vcode);
    //更新单独的视频
    void updateVedio(T_Vedio t_vedio);

    /**
     * 根据视频的编号更新审核状态 Integer id String vstatus
     * @param paramMap
     */
    //审核视频
    void updateVedioStatus(Map<String,Object> paramMap);
    //删除视频
    void deleteVedio(Integer vcode);


    /**
     *  //根据文件名称、审核状态、类型进行多条件模糊查询 参数有Integer vcode 以及 String vstatus String vclass
     * @param paramMap
     * @return
     */
    List<T_Vedio> selectVedioByConditions(Map<String,Object> paramMap);
}
