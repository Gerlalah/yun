package cn.wolfcode.dao;

import cn.wolfcode.entity.T_Role;

import java.util.List;

public interface RoleDao {

    List<T_Role> selectRoleByCondition(String str);
    List<T_Role> selectAllRole();

    void addRole(T_Role t_role);

    void deleteRole(Integer rid);

    T_Role selectIdRole(Integer rid);

    void updateRole(T_Role t_role);
}
