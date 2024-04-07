package com.twd.accomodate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;
    private String firstName;
    private String lastName;
    private String contactDetails;
    private String email;
    private String guardianFullName;
    private String guardianSurname;
    private String relationship;
    private String guardianEmail;
    private String guardianContacts;
    private String guardianIdocument;
    private String bursary;
    private String institution;
    private String campus;
    private String yearOfStudy;
    private String faculty;
    private Character gender;
    private Integer age;
    private String iDocument;
    private String proofOfReg;
    private String transcript;
    private  Long idNumber;
    private LocalDate dateOfBirth;
    private  String address;



    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;


    @Column(name = "applied_at", columnDefinition = "TIMESTAMP")
    private Instant appliedAt;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "residence_id", referencedColumnName = "residence_id")
    private Residence residence;

    public Application() {
        this.appliedAt = Instant.now();
    }

}