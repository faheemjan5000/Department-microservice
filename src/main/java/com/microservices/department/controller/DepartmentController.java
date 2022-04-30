package com.microservices.department.controller;


import com.microservices.department.model.Department;
import com.microservices.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path="/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping(path="/{id}")
    public Department findDeparmentById(@PathVariable("id") Long id){
        return departmentService.findDepartmentById(id);
    }

    @PostMapping(path="/add")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inside saveDepartment() method of DepartmentController");
        return departmentService.saveDepartment(department);
    }


}
