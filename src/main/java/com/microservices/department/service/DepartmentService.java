package com.microservices.department.service;

import com.microservices.department.exceptions.DepartmentNotFoundException;
import com.microservices.department.model.Department;
import com.microservices.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) throws DepartmentNotFoundException {
        log.info("id recieved in service class : "+id);
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent())
            throw new DepartmentNotFoundException("department not found");
        else
            return department.get();
    }

    public List<Department> getAllDepartments() {
        log.info("insdie getAllDepartments() method of DepartmentService");
        return departmentRepository.findAll();
    }

    public void removeDepartment(Long departmentId) throws DepartmentNotFoundException {
        log.info("inside DepartmentService.removeDepartment() method...");
        try {
            departmentRepository.deleteById(departmentId);
        }
        catch (EmptyResultDataAccessException e){
            throw new DepartmentNotFoundException(e.getMessage());
        }
    }

    public Department updateDepartment(Long departmentId, Department updatedDepartment) throws DepartmentNotFoundException {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if(optionalDepartment!=null){
            Department department = optionalDepartment.get();
            if(updatedDepartment.getDepartmentCode()!=null){
                department.setDepartmentCode(updatedDepartment.getDepartmentCode());
            }
            if(updatedDepartment.getDepartmentAddress()!=null){
                department.setDepartmentAddress(updatedDepartment.getDepartmentAddress());
            }
            if(updatedDepartment.getDepartmentName()!=null){
                department.setDepartmentName(updatedDepartment.getDepartmentName());
            }
            return departmentRepository.save(department);
        }
        else{
            log.error("department not found with id : "+departmentId);
            throw new DepartmentNotFoundException("department not found!");
        }

    }

    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    public Department getDepartmentByCode(String departmentCode){
        return departmentRepository.findByDepartmentCode(departmentCode);
    }
}
