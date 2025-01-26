package com.travel.Travel_Booking_App_Api.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
public class TravelPlan  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  planeId;

    @Column(name = "PLANE_NAME")
    private String planeName;

    @Column(name = "PLANE_DESCRIPTION")
    private String planeDescription;

    @Column(name = "PLANE_MINIMUM_BUDGET")
    private Number planeMinimumBudget;

    @Column private Long planeCategoryId;

    @Column(name = "STATUS_SW")
    private String status_sw;


    @Column(updatable = false,nullable = false)
    private LocalDate createDate;

    @Column(nullable = false)
    private LocalDate updateDate;

    @Column(updatable = false,nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String updatedBy;



    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public String getPlaneDescription() {
        return planeDescription;
    }

    public void setPlaneDescription(String planeDescription) {
        this.planeDescription = planeDescription;
    }

    public Number getPlaneMinimumBudget() {
        return planeMinimumBudget;
    }

    public void setPlaneMinimumBudget(Number planeMinimumBudget) {
        this.planeMinimumBudget = planeMinimumBudget;
    }

    public String getStatus_sw() {
        return status_sw;
    }

    public void setStatus_sw(String status_sw) {
        this.status_sw = status_sw;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public Long getPlaneCategoryId() {
        return planeCategoryId;
    }

    public void setPlaneCategoryId(Long planeCategoryId) {
        this.planeCategoryId = planeCategoryId;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
