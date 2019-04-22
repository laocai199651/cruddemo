package com.cwk.springbootweb.cruddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
//@RestController
@Controller
public class UserContrl {

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username, @RequestParam("passwd") String passwd, Map map, HttpSession session) {

        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(passwd) && "admin".equals(username) && "123456".equals(passwd)) {
          /*  Object loginUsersObj = session.getAttribute("loginUsers");
            if (loginUsersObj == null)
                loginUsersObj = new ArrayList<>();
            ((List) loginUsersObj).add(username.hashCode() + passwd.hashCode());*/
            session.setAttribute("loginUsers", username);
            //重定向处理
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }

}
