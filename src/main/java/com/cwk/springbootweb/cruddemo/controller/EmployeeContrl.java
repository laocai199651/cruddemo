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

    /**
     * 员工列表页面
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String emps(Model model) {
        model.addAttribute("emps", employeeDao.getAll());
        return "emp/list";
    }

    /**
     * 员工添加页面
     * @return
     */
    @GetMapping("/emp")
    public String emp(){
        return "emp/add";
    }

}
