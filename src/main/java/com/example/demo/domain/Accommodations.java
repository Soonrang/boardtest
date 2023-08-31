package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Accommodations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ano;

    @Column(length=500, nullable = false)
    private String accommodations_Name;


    @Column(length = 500, nullable = false)
    private String accommodations_Feature;

    @Column(length = 500, nullable = false)
    private String location;

    private LocalDate booking_sdate;
    private LocalDate booking_edate;

    private String type;

}
