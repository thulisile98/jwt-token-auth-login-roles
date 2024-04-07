package com.twd.accomodate.controller;

import com.twd.accomodate.entity.Users;
import com.twd.accomodate.service.OurUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.twd.accomodate.service.ApplicationService;
import com.twd.accomodate.entity.Application;
import java.util.List;
import java.util.Optional;

@RestController
public class ApplicationController {



    private final ApplicationService applicationService;
    private final OurUserDetailsService studentService;


    @Autowired
    public ApplicationController(ApplicationService applicationService, OurUserDetailsService studentService) {
        this.applicationService = applicationService;
        this.studentService = studentService;
    }

    @PostMapping("/application/{studentId}")
    public ResponseEntity<Application> createApplication(@PathVariable Integer studentId, @RequestBody Application application) {



        Optional<Users> studentOptional = studentService.findById(studentId);

        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }


        application.setUsers(studentOptional.get());


        Application createdApplication = applicationService.createApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }


    // Get applications of a certain student using their ID
    @GetMapping("adminuser/{studentId}")
    public ResponseEntity<List<Application>> getStudentApplications(@PathVariable Integer studentId) {
        List<Application> applications = studentService.getApplicationsForStudent(studentId);
        return ResponseEntity.ok(applications);
    }

    // Get a list of all applications
    @GetMapping("/admin/all")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @DeleteMapping("/application/{id}")
    public void deleteApplicationById(@PathVariable Integer id) {
        applicationService.deleteApplicationById(id);
    }


//get student with id
//    @GetMapping("/admin/student/{id}")
//    public Optional<Users> getStudentbyId(@PathVariable Integer id){
//        return studentService.findById(id);
//    }


    // Get all applications for a certain student using their ID
//    @GetMapping("/admin/applications/{studentId}")
//    public ResponseEntity<List<Application>> getApplicationsByStudentId(@PathVariable Integer studentId) {
//        List<Application> applications = applicationService.getApplicationsByStudentId(studentId);
//        return ResponseEntity.ok(applications);
//    }




}
