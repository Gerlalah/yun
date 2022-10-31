package cn.wolfcode.dao;

import cn.wolfcode.entity.T_User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {


    //查询用户信息根据账号(用户的编号/用户的手机号码)
    T_User selectUserByCondition(String str) ;

    /**
     * 根据用户的ucode更新用户状态
     * String ucode,Short ustatus
     * @param paramMap
     */
    int updateUser(Map<String,Object> paramMap ) ;
    /**
     * 增加用户信息
     */
    public  void   userAdd(T_User t_user );


    List<T_User> selectAll();

    /**
     * 模糊查询
     * @param uname
     * @return
     */
    public List<T_User> select(String uname);

    /**
     * 查看用户详情
     */
//    void userDetails(String ucode);
    /**
     * 删除指定用户
     */
    void userDelete(String ucode);

    /**
     * 更新用户密码
     * @param user
     */
    void updateUserPwd(@Param("user")T_User user);
}


