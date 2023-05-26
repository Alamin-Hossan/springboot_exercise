package com.example.webAppCheckThymeleaf.controller;

import com.example.webAppCheckThymeleaf.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @GetMapping("/index")
    public String welcomePage(){
        return "index.html";
    }

    @PostMapping("/receive")
    public ModelAndView receivePage(@RequestParam String id, @RequestParam String fname, @RequestParam String lname, ModelAndView model){
        model.setViewName("view.html");
        model.addObject("id" , id);
        model.addObject("fname" , fname);
        model.addObject("lname" , lname);

        return model;
    }

    @GetMapping("/employes")
    public ModelAndView getAllEmployee(ModelAndView model){
        Employee employee1 = new Employee("1","Alamin","Hossain");
        Employee employee2 = new Employee("2","Hasan","Emo");
        Employee employee3 = new Employee("3","Jawad","Hossain");

        List<Employee> employee = new ArrayList<>();
        employee.add(employee1);
        employee.add(employee2);
        employee.add(employee3);
        model.setViewName("employees.html");
        model.addObject("employee", employee);

        return model;

    }
}
