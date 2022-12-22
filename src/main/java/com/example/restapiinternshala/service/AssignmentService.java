package com.example.restapiinternshala.service;

import com.example.restapiinternshala.model.Assignment;

import java.util.List;

public interface AssignmentService {

    Assignment saveAssignment(Assignment assignment);
    List<Assignment> getAllAssignment();
    Assignment getEmployeeById(Long id);
    Assignment updateEmployee(Assignment assignment, Long id);
    void deleteAssignment(Long id);
}
