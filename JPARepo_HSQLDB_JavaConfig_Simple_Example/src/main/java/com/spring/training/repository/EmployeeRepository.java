package com.spring.training.repository;

import com.spring.training.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Transactional(readOnly = true)
    Set<Employee> findEmployeesByProjectsId(Long id);


}
