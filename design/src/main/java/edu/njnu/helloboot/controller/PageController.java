package edu.njnu.helloboot.controller;

import edu.njnu.helloboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 能够进行服务端页面渲染的controller
 */
@Controller
public class PageController {

    @RequestMapping("/hello/{userId}")
    public ModelAndView hello(@PathVariable String userId){
        //ctrl+p 显示函数的入参
        User user=new User(userId,"张三","1234","男",12);
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();

        //将user传入ModelAndView
        //request.setAttribute("user",user);
        modelAndView.addObject("user",user);

        //指定返回到哪个页面
        //springboot默认情况下：viewName省略后缀名(html)以及前缀
        modelAndView.setViewName("Hello");

        //返回modelAndView
        return modelAndView;
    }

}
