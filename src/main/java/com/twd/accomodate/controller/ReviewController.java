package com.twd.accomodate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.twd.accomodate.service.ReviewServices;
import com.twd.accomodate.entity.Review;
import com.twd.accomodate.entity.Users;
import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {
    @Autowired
    private ReviewServices reviewsService;

    @PostMapping("/review/{studentId}")
    public ResponseEntity<Review> createReview(@PathVariable Integer studentId, @RequestBody Review review) {

        Optional<Users> studentOptional = reviewsService.findById(studentId);

        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }


        review.setUsers(studentOptional.get());


        Review createdReview =  reviewsService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }



    @GetMapping("/public/all")
    public List<Review> getAllReviews() {
        return reviewsService.getAllReviews();
    }

}
