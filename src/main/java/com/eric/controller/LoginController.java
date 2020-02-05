package com.eric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session,
                        Map<String,Object> map){
        if(!StringUtils.isEmpty(username) && "12345".equals(password)){
            session.setAttribute("loginUser", username);
            //注意为了防止表单重复提交，我们需要重定向到dashboard.html
            return "redirect:/dashboard.html";
        }else {
            map.put("msg", "用户名或密码错误");
            return "/login.html";
        }
    }
}
