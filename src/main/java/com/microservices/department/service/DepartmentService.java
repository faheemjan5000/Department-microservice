package com.microservices.department.service;

import com.microservices.department.model.Department;
import com.microservices.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        return departmentRepository.findByDepartmentId(id);
    }

    public List<Department> getAllDepartments() {
        log.info("insdie getAllDepartments() method of DepartmentService");
        return departmentRepository.findAll();
    }
}
