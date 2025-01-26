package com.travel.Travel_Booking_App_Api.serviceIMPL;
import com.travel.Travel_Booking_App_Api.dao.CategoryPlaneDAO;
import com.travel.Travel_Booking_App_Api.dao.TravelPlanDAO;
import com.travel.Travel_Booking_App_Api.model.PlanCategory;
import com.travel.Travel_Booking_App_Api.model.TravelPlan;
import com.travel.Travel_Booking_App_Api.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class TravelPlaneServiceImpl implements TravelPlanService {

    @Autowired
    private TravelPlanDAO travelPlanDAO;

    @Autowired private CategoryPlaneDAO categoryPlaneDAO;
    @Override
    public String registerTravelPlane(TravelPlan travelPlan) {

        TravelPlan register=this.travelPlanDAO.save(travelPlan);
        if (register==null){
            return "not found";
        }
        return "register successfully with id :" ;
    }

    @Override
    public List<TravelPlan> showAllTravelPlane() {
        return this.travelPlanDAO.findAll();
    }

    @Override
    public TravelPlan updateTravelPlane(TravelPlan travelPlan,Long planId) {
        TravelPlan getPlane=this.travelPlanDAO.findById(planId).orElseThrow(
                ()->new RuntimeException("does not exist")
        );
        getPlane.setPlaneId(travelPlan.getPlaneId());
        getPlane.setPlaneName(travelPlan.getPlaneName());
        getPlane.setPlaneCategoryId(travelPlan.getPlaneCategoryId());
        getPlane.setCreateDate(travelPlan.getCreateDate());
        getPlane.setUpdateDate(travelPlan.getUpdateDate());
        getPlane.setPlaneMinimumBudget(travelPlan.getPlaneMinimumBudget());
        getPlane.setStatus_sw(travelPlan.getStatus_sw());
        getPlane.setPlaneDescription(travelPlan.getPlaneDescription());
        getPlane.setCreatedBy(travelPlan.getCreatedBy());
        getPlane.setUpdatedBy(travelPlan.getUpdatedBy());
        getPlane.setCreatedBy(travelPlan.getCreatedBy());
        return this.travelPlanDAO.save(getPlane);
    }

    @Override
    public TravelPlan showTravelPlaneById(Long planeId) {

//       return this.travelPlanDAO.findById(planeId).orElseThrow(
//               ()->new RuntimeException("not found on this id"));

        Optional<TravelPlan> travelPlan=this.travelPlanDAO.findById(planeId);
        if (travelPlan.isPresent()){
            return travelPlan.get();
        }
        else {
            try {
                throw new IllegalAccessException("plan not found");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String deleteTravelPlane(Long planeId) {
      TravelPlan getPlane= this.travelPlanDAO.findById(planeId).orElseThrow(()->new RuntimeException("not found"));
      if(getPlane==null){
        return "not found" ;
      }
       return "deleted";
    }

    @Override
    public Map<Long, String> getTravelPlaneCategories() {
        Map<Long,String> categoriesMap=new HashMap<>();

        List< PlanCategory> categoryList=this.categoryPlaneDAO.findAll();

        for (PlanCategory planCategory : categoryList) {
              categoriesMap.put(planCategory.getCategoryId(),planCategory.getCategoryName());
        }


        return categoriesMap;
    }

    @Override
    public TravelPlan changeTravelPlanStatus(Long planId, String status) {
        TravelPlan travelPlan=this.travelPlanDAO.findById(planId).orElseThrow(()->new RuntimeException("not found"));
        travelPlan.setStatus_sw(status);
       return this.travelPlanDAO.save(travelPlan);

    }
}
