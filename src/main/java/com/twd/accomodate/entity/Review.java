package com.twd.accomodate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;


    private String description;

    @Column(name = "posted_at", columnDefinition = "TIMESTAMP")
    private Instant postedAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Users users;



    public Review() {
        this.postedAt = Instant.now();
    }

}