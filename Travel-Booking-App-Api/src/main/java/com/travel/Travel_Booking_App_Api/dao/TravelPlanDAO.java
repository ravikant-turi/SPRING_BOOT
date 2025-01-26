package com.travel.Travel_Booking_App_Api.dao;

import com.travel.Travel_Booking_App_Api.model.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TravelPlanDAO extends   JpaRepository<TravelPlan,Long> {
}
