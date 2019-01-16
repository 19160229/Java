package edu.njnu.helloboot.controller;

import edu.njnu.helloboot.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController 处理特定的http请求
 */

//ctrl+alt+o 自动删除不需要的jar包

@RestController
//restController专门用于处理和返回特定格式的数据(默认数据格式是json)，不再执行渲染html的工作
public class HelloController {

    // 1.前台浏览器输入url: localhost:8080/user/{id} ,id代表的是用户信息在数据库中的主键值
    // 2.后台服务根据id值返回不同的user信息给浏览器

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id){
        if ("1".equals(id)){
            return new User("1","张三","1234","男",18);
        }
        return new User();
    }

}
