package com.twd.accomodate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.twd.accomodate.repository.ReviewRepository;
import com.twd.accomodate.repository.OurUserRepo;
import com.twd.accomodate.entity.Review;
import com.twd.accomodate.entity.Users;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServices {

    private  final ReviewRepository reviewRepository;
    private  final OurUserRepo studentRepository;


    public Review createReview(Review review) {

        return reviewRepository.save(review);
    }



    public void deleteReview(Long id){
        reviewRepository.deleteById(id);
    }



    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Users> findById(Integer id) {
        return studentRepository.findById(id);
    }





}