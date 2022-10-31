package cn.wolfcode.service;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_priviage;

import java.util.List;

public interface UserService {


    /**
     * 根据账号查询用户
     * @param acount
     * @return
     */
    T_User getuser(String acount) ;

    /**
     * 更新用户状态
     * @param ucode
     * @param ustatus
     * @return
     */
    int updateUser(String ucode, Short ustatus) ;
    /**
     *获取用户的权限信息
     */
    List<T_priviage> getUserPri(Integer  rid) ;


    /**
     * 增加用户
     */
    void userAdd(T_User t_user);

    /**
     * 查询所有
     * @return
     */
    List<T_User> selectAll();

    /**
     * 查询用户详情
     */
//    void details(String ucode);

    /**
     * 模糊查询
     * @param uname
     * @return
     */
    List<T_User> select(String uname);

    /**
     * 删除用户
     * @param ucode
     */
    void userDelete(String ucode);

    /**
     * 更新用户密码
     * @param user
     */
    void updateUserPwd(T_User user);
}
