package com.eric.controller;

import com.eric.component.EmployeeNotFoundException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EmployeeNotFoundHanlder {

/*    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    public Map<String, Object> employeeNotFoundHanlder(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code","employee.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/


    @ExceptionHandler(EmployeeNotFoundException.class)
    public String employeeNotFoundHanlder(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("code","employee.notexist");
        map.put("message","用户出错了");
        request.setAttribute("javax.servlet.error.status_code", 500);
        request.setAttribute("ext", map);
        return "forward:/error";
    }
}
