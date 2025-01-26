package com.travel.Travel_Booking_App_Api.service;

import com.travel.Travel_Booking_App_Api.dao.TravelPlanDAO;
import com.travel.Travel_Booking_App_Api.model.TravelPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface TravelPlanService {

//    save operation
    public  String registerTravelPlane(TravelPlan travelPlan);

//    update operation
    public TravelPlan updateTravelPlane(TravelPlan travelPlan,Long planId);

//    for single operation
    public TravelPlan showTravelPlaneById(Long planeId) ;

//    select operation

    public List<TravelPlan>showAllTravelPlane();

//    deleteOperation

    public String  deleteTravelPlane(Long planId);


    public Map<Long,String>getTravelPlaneCategories();

    public TravelPlan changeTravelPlanStatus(Long planId,String status);






}
