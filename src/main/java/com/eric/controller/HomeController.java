package com.eric.controller;

import com.eric.component.EmployeeNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
/*    @RequestMapping(value = {"/","/login.html"})
    public String index(){
        return "login";
    }*/
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user")String user){
        if(user.equals("aaa")){
            throw new EmployeeNotFoundException();
        }
        return "hello";
    }
}
