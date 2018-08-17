package com.spring.training.repository;

import com.spring.training.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Transactional(readOnly = true)
    List<Project> findProjectByEmployeesId(Long id);

}
