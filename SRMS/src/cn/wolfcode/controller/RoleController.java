package cn.wolfcode.controller;

import cn.wolfcode.entity.T_Role;
import cn.wolfcode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleServiceImpl;

    @RequestMapping("/selectrole")
    public ModelAndView selectrole(@RequestParam(name = "rname", required = true)String str) {
        //查询操作
        try {
            str=new String(str.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("str="+str);
        List<T_Role> roles = roleServiceImpl.selectRoleByCondition(str);
        //数据库t_user表中的数据
        for(T_Role role:roles){
            System.out.println(role);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("roleList.jsp");
        mav.addObject("roles", roles);
        return mav;
    }

    @RequestMapping("/addrole")
    public ModelAndView addrole(@RequestParam(name = "rname", required = true)String name,
                                @RequestParam(name = "rdesc", required = true)String desc) {
        //查询操作
        try {
            name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
            desc=new String(desc.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(name);
        System.out.println(desc);
        T_Role t_role=new T_Role();
        t_role.setRname(name);
        t_role.setRdesc(desc);
        roleServiceImpl.addRole(t_role);
        //数据库t_user表中的数据
        ModelAndView mav = new ModelAndView();
        mav.setViewName("roleList.jsp");
        return mav;
    }

    @RequestMapping("/deleterole")
    public ModelAndView deleterole(@RequestParam(name = "rid", required = true)Integer rid) {
        //查询操作
        System.out.println("deleterole="+rid);
        roleServiceImpl.deleteRole(rid);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("roleList.jsp");
        return mav;
    }

    @RequestMapping("/detailsrole")
    public ModelAndView detailsrole(@RequestParam(name = "rid", required = true)Integer rid,String type) {
        //查询操作
        System.out.println("detailsrole="+rid);
        T_Role roleView = roleServiceImpl.selectIdRole(rid);
        ModelAndView mav = new ModelAndView();
        mav.addObject("roleView",roleView);
        if(type.equals("details"))
            mav.setViewName("roleView.jsp");
        else
            mav.setViewName("roleUpdate.jsp");
        return mav;
    }

    @RequestMapping("/updaterole")
    public ModelAndView updaterole(@RequestParam(name = "rid", required = true)Integer rid,
                                   @RequestParam(name = "rname", required = true)String rname,
                                   @RequestParam(name = "rdesc", required = true)String rdesc) {
        try {
            rname=new String(rname.getBytes("ISO-8859-1"),"UTF-8");
            rdesc=new String(rdesc.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(rid);
        System.out.println(rname);
        System.out.println(rdesc);
        T_Role role=new T_Role();
        role.setRdesc(rdesc);
        role.setRid(rid);
        role.setRname(rname);
        roleServiceImpl.updateRole(role);
        //数据库t_user表中的数据
        ModelAndView mav = new ModelAndView();
        mav.setViewName("roleList.jsp");
        return mav;
    }

}
