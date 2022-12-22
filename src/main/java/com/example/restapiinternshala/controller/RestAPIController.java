package com.example.restapiinternshala.controller;

import com.example.restapiinternshala.model.Assignment;
import com.example.restapiinternshala.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestAPIController {

    private AssignmentService assignmentService;

    public RestAPIController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @GetMapping
    public String index(){
        return "Welcome to the Employee Service Rest Service";
    }

    @GetMapping("/assignment/{id}")
    public ResponseEntity<Assignment> getEmployeeById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(assignmentService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/assignment")
    public List<Assignment> getAllEmployee(){
        return assignmentService.getAllAssignment();
    }

    @PostMapping("/assignment")
    public ResponseEntity<Assignment> saveAssignment(Assignment assignment){
        return new ResponseEntity<>(assignmentService.saveAssignment(assignment), HttpStatus.CREATED);
    }

    @PutMapping("assignment/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable("id") Long id, @RequestBody Assignment assignment){
        return new ResponseEntity<>(assignmentService.updateEmployee(assignment, id), HttpStatus.OK);
    }

    @DeleteMapping("/assignment/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable("id") Long id){
        Assignment assignment = assignmentService.getEmployeeById(id);
        assignmentService.deleteAssignment(id);
        return new ResponseEntity<>("Assignment delete successfully\n" + assignment.toString(), HttpStatus.OK);
    }
}
