package com.cwk.springbootweb.cruddemo.controller;

import com.cwk.springbootweb.cruddemo.dao.DepartmentDao;
import com.cwk.springbootweb.cruddemo.dao.EmployeeDao;
import com.cwk.springbootweb.cruddemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeContrl {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 员工列表页面
     *
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
     *
     * @return
     */
    @GetMapping("/emp")
    public String emp(Model model) {
        model.addAttribute("depts", departmentDao.getDepartments());
        return "emp/add";
    }

    /**
     * 添加员工
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 员工修改页面
     */
    @GetMapping("/emp/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("emp", employeeDao.get(id)).addAttribute("depts", departmentDao.getDepartments());
        return "emp/add";
    }

    /**
     * 修改员工
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    /**
     * 删除员工
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
