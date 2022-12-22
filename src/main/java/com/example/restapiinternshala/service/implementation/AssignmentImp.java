package com.example.restapiinternshala.service.implementation;

import com.example.restapiinternshala.exception.ResourceNotFoundException;
import com.example.restapiinternshala.model.Assignment;
import com.example.restapiinternshala.repository.AssignmentRepository;
import com.example.restapiinternshala.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AssignmentImp implements AssignmentService {

    private AssignmentRepository assignmentRepository;

    public AssignmentImp(AssignmentRepository assignmentRepository){
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public Assignment saveAssignment(Assignment assignment) {
        assignment.setTimeStamp(Instant.now());
        return assignmentRepository.save(assignment);
    }

    @Override
    public List<Assignment> getAllAssignment() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment getEmployeeById(Long id) {
        return assignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Assignment", "ID", id));
    }

    @Override
    public Assignment updateEmployee(Assignment assignment, Long id) {

        Assignment existingAssignment = assignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Assignment", "ID", id));

        existingAssignment.setName(assignment.getName());
        existingAssignment.setAddress(assignment.getAddress());
        existingAssignment.setState(assignment.getState());
        existingAssignment.setPinCode(assignment.getPinCode());

        assignmentRepository.save(existingAssignment);

        return existingAssignment;
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
