package com.travel.Travel_Booking_App_Api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
public class PlanCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long categoryId;

    @Column
    private String categoryName;

    @Column
    private String categoryHotel;

    @Column private String categoryTravel;

    @Column private char active_sw;

    @Column(updatable = false,nullable = false)
    private LocalDate createDate;

    @Column(nullable = false)
    private LocalDate updateDate;

    @Column(updatable = false,nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String updatedBy;



}
