package com.eric.component;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("未找到员工信息");
    }
}
