package cn.wolfcode.controller;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @Autowired
//    UserService userServiceImpl;
    /**
     * 增加用户信息
     */
    @RequestMapping("/userAdd")
    public ModelAndView userAdd(T_User t_user,HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        System.out.println(t_user);
        userService.userAdd(t_user);
        List<T_User> users = userService.selectAll();
        req.getSession().setAttribute("users",users);
        mav.setViewName("userList.jsp");
        return mav;
    }

    /**
     * 查询单个用户
     * @param uname
     * @param request
     * @return
     */
    @RequestMapping("/select")
    public ModelAndView select(@RequestParam("uname") String uname,HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView();
        String name = "%"+uname+"%";
        List<T_User> users = userService.select(name);
//            更新users的信息  返回特定查询名字
        request.getSession().setAttribute("users",users);
        modelAndView.setViewName("userList.jsp");
//            使得前端显示查找文字
        modelAndView.addObject("msg",uname);
        return modelAndView;
    }

    /**
     * 查询用户详细信息
     */
//        @RequestMapping("/details")
//    public ModelAndView details((@RequestParam(name = "ucode", required = true) String ucode)) {
//            userServiceImpl.details(ucode);
//            ModelAndView mav = new ModelAndView();
//            mav.setViewName("userView.jsp");
//            return mav;
//        }
    @RequestMapping("/delete")
    public ModelAndView delete(String ucode, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        userService.userDelete(ucode);
        List<T_User> users = userService.selectAll();
        request.setAttribute("users",users);
        modelAndView.setViewName("userList.jsp");
        return modelAndView;
    }
}
