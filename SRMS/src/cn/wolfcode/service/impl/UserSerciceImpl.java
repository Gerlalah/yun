package cn.wolfcode.service.impl;

import cn.wolfcode.dao.PriDao;
import cn.wolfcode.dao.UserDao;
import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_priviage;
import cn.wolfcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserSerciceImpl implements UserService {

    //引入dao层
    @Autowired
    UserDao userMapper ;
    @Autowired
    PriDao priMapper ;


    @Override
    public T_User getuser(String acount) {
        return userMapper.selectUserByCondition(acount);
    }


    @Override
    public int updateUser(String ucode, Short ustatus) {
        Map<String,Object> paramMap=new HashMap<>() ;
        paramMap.put("ucode",ucode);
        paramMap.put("ustatus",ustatus) ;
        return userMapper.updateUser(paramMap);
    }

    @Override
    public List<T_priviage> getUserPri(Integer rid) {
        //怎么一下把模块/按钮权限全部查询?
        //要求-模块包含按钮权限
        //首先查询该用户的模块权限
        List<T_priviage> t_priviages = priMapper.selectPriviage(rid);
        System.out.println(rid+"--查询到的父级权限--"+t_priviages);
        //根据模块级权限id查询按钮权限
        for (T_priviage priviage:t_priviages){
            Map<String,Object> paramMap=new HashMap<>() ;
            paramMap.put("pid",priviage.getPid());
            paramMap.put("rid",rid);
            List<T_priviage> sonPriList = priMapper.selectSonPriviage(paramMap);
            priviage.setPriList(sonPriList);
        }
        return t_priviages;
    }

    /**
     * 增加用户
     * @param t_user
     */
    @Override
    public void userAdd(T_User t_user) {
        userMapper.userAdd(t_user);
    }
    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<T_User> selectAll() {
        List<T_User> t_users = userMapper.selectAll();
        return t_users;
    }

    @Override
    public List<T_User> select(String uname) {
        List<T_User> users = userMapper.select(uname);
        return users;
    }

    /**
     * 删除指定用户
     * @param ucode
     */
    @Override
    public void userDelete(String ucode) {
        userMapper.userDelete(ucode);
    }

    @Override
    public void updateUserPwd(T_User user) {
        // TODO Auto-generated method stub
        userMapper.updateUserPwd(user);
    }
    /**
     * 查询用户详细信息
     */
//    @Override
//    public void details(String ucode) {
//        userMapper.userDetails(ucode);
//    }

}
