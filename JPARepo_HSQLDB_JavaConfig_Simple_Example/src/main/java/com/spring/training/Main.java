package com.spring.training;

import com.spring.training.config.AppConfig;
import com.spring.training.entity.Address;
import com.spring.training.entity.Employee;
import com.spring.training.entity.Project;
import com.spring.training.repository.AddressRepository;
import com.spring.training.repository.EmployeeRepository;
import com.spring.training.repository.ProjectRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        AddressRepository addressRepository = appCtx.getBean(AddressRepository.class);
        List<Address> addressList = addressRepository.findAll();
        addressList.forEach(System.out::println);

        EmployeeRepository employeeRepository = appCtx.getBean(EmployeeRepository.class);

        Set<Employee> employeeSet = employeeRepository.findEmployeesByProjectsId(2L);
        employeeSet.stream().forEach(x->System.out.println(x));

        ProjectRepository projectRepository = appCtx.getBean(ProjectRepository.class);
        List<Project> projectList = projectRepository.findProjectByEmployeesId(1L);
        projectList.forEach(System.out::println);



    }
}
