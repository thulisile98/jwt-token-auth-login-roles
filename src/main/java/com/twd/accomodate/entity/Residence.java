package com.twd.accomodate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "residence_id")
    private Long residenceId;

    private String name;
    private int regNo;
    private List<String> utility = new ArrayList<>();
    private String profileImage;
    private List<String> images = new ArrayList<>();
    private String nsfasDocument;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id", nullable = false)
    private Users users;

    @OneToMany(mappedBy = "residence")
    private List<Room> rooms;

    @OneToMany(mappedBy = "residence")
    private List<Issues> issues;



    @OneToMany(mappedBy = "residence")
    private List<Location> location;

    @OneToMany(mappedBy = "residence")
    private List<Application> applications;


}
