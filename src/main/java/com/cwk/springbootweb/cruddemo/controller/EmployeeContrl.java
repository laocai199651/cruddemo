package com.cwk.springbootweb.cruddemo.controller;

import com.cwk.springbootweb.cruddemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmployeeContrl {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String emps(Model model) {
        model.addAttribute(employeeDao.getAll());
        return "emp/list";
    }

}
