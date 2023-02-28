package com.example.TEST.service;

import com.example.TEST.domain.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    Employee save(Employee employee);
}
