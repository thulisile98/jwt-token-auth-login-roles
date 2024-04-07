package com.twd.accomodate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.twd.accomodate.entity.Issues;
import com.twd.accomodate.service.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class IssuesController {


    private final IssuesService issuesService;

    @Autowired
    public IssuesController(IssuesService issuesService) {
        this.issuesService = issuesService;
    }

    @PostMapping("/issues")
    public ResponseEntity<Issues> reportIssue(@RequestBody Issues issue) {
        Issues reportedIssue = issuesService.reportIssue(issue);
        return new ResponseEntity<>(reportedIssue, HttpStatus.CREATED);
    }

    @PatchMapping("/admin/issues/{id}")
    public ResponseEntity<Object> updateIssue(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        // Update the issue with the provided ID
        Optional<Issues> updatedIssue = issuesService.updateIssue(id, updates);

        // Check if the issue was successfully updated
        if (updatedIssue.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/issues/{id}")
    public ResponseEntity<Issues> getIssueById(@PathVariable Long id) {
        return issuesService.getIssueById(id)
                .map(issue -> new ResponseEntity<>(issue, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/admin/issues")
    public ResponseEntity<List<Issues>> getAllIssues() {
        List<Issues> allIssues = issuesService.getAllIssues();
        return new ResponseEntity<>(allIssues, HttpStatus.OK);
    }
}
