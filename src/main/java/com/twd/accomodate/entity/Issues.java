package com.twd.accomodate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issues_id")
    private Long issuesId;

    private String title;

    private String description;
    private String status;

    @Column(name = "reported_at", columnDefinition = "TIMESTAMP")
    private Date reportedAt;

    @Column(name = "solved_at", columnDefinition = "TIMESTAMP")
    private Date solvedAt;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "residence_id", nullable = false)
    private Residence residence;



}