package com.microservices.department.controller;


import com.microservices.department.exceptions.DepartmentNotFoundException;
import com.microservices.department.model.Department;
import com.microservices.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public Department findDeparmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        log.info("id recieved in controller class  : "+id);
        return departmentService.findDepartmentById(id);
    }

    @PostMapping(path="/add")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inside saveDepartment() method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) throws DepartmentNotFoundException {
           log.info("inside updateDepartment() method of departmentController.");
           return departmentService.updateDepartment(departmentId,department);

    }

    @GetMapping("/department/name/{name}")
    public Department getByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }

    @GetMapping("/department/code/{code}")
    public Department getByCode(@PathVariable("code") String departmentCode){
        return departmentService.getDepartmentByCode(departmentCode);
    }

    @DeleteMapping("/remove/{id}")
    public void removeDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

            departmentService.removeDepartment(departmentId);

    }


}
