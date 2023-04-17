package com.microservices.department.repository;

import com.microservices.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentName(String departmentName);

    Department findByDepartmentCode(String departmentCode);
}
