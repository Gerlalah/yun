package cn.wolfcode.service.impl;

import cn.wolfcode.dao.RoleDao;
import cn.wolfcode.entity.T_Role;
import cn.wolfcode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao RoleMapper;

    @Override
    public List<T_Role> selectRoleByCondition(String str) {
        if(str.equals("")){
            System.out.println("确实");
            return RoleMapper.selectAllRole();
        }
        return RoleMapper.selectRoleByCondition(str);
    }

    @Override
    public void addRole(T_Role t_role) {
        RoleMapper.addRole(t_role);
    }

    @Override
    public void deleteRole(Integer rid) {
        System.out.println("Impl rid="+rid);
        RoleMapper.deleteRole(rid);
    }

    @Override
    public T_Role selectIdRole(Integer rid) {
        T_Role role=RoleMapper.selectIdRole(rid);
        System.out.println(role);
        return role;
    }

    @Override
    public void updateRole(T_Role t_role) {
        RoleMapper.updateRole(t_role);
    }
}
