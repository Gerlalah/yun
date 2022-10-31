package cn.wolfcode.dao;

import cn.wolfcode.entity.T_Pic;
import java.util.*;
public interface PictureDao {
    public int addpic(T_Pic pic);

    public int deletepic(Integer picId);

    public int updatepic(T_Pic pic);

    public  List<T_Pic> selectpic();
}
