package com.travel.Travel_Booking_App_Api.controller;
import com.travel.Travel_Booking_App_Api.model.TravelPlan;
import com.travel.Travel_Booking_App_Api.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("travelplane/app")
public class TravelPlanController {
    @Autowired
    private TravelPlanService travelPlanService;
    @PostMapping("/register")
    public  ResponseEntity<String> addTravelPlane(@RequestBody TravelPlan travelPlan){
        String travelResponce=this.travelPlanService.registerTravelPlane(travelPlan);
        return new ResponseEntity<>(travelResponce,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-travelplane")
    public ResponseEntity<List<TravelPlan>> getAllTravelPlan(){
        List<TravelPlan> planList=this.travelPlanService.showAllTravelPlane();
        return new ResponseEntity<>(planList,HttpStatus.OK);
    }
    @GetMapping("/getTravelPlaneById/{planeId}")
    public ResponseEntity<?> getTravelPlaneById(@PathVariable Long planeId){
        try {

        return new ResponseEntity<>(this.travelPlanService.showTravelPlaneById(planeId),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update-plane")
    public ResponseEntity<TravelPlan>updatePlane(@RequestBody TravelPlan travelPlan,Long planId){
       return new ResponseEntity<>(this.travelPlanService.updateTravelPlane(travelPlan,planId), HttpStatus.OK);
    }
    @DeleteMapping("/delete-plane/{planeId}")
    public ResponseEntity<String>deletePlane(@PathVariable Long planId){

      return new ResponseEntity<>(this.travelPlanService.deleteTravelPlane(planId),HttpStatus.OK);

    }
    @GetMapping("/getTravelPlaneCategory")
    public ResponseEntity<?> getTravelPlaneCategory(){

        return new ResponseEntity<>(this.travelPlanService.getTravelPlaneCategories(),HttpStatus.OK);
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<TravelPlan> changeTravelPlaneStatus(@PathVariable Long planId, @PathVariable  String status){
        return new ResponseEntity<>(this.travelPlanService.changeTravelPlanStatus(planId,status),HttpStatus.CREATED);
    }
}
