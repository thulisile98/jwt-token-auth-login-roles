package com.twd.accomodate.repository;
import com.twd.accomodate.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAll();
}
