package job.application.job_application_backend_api.comapny;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company")
    public ResponseEntity<List<Company>> getAllCompany(){
        return new ResponseEntity<>(this.companyService.getAllCompany(), HttpStatus.OK);
    }

    @PostMapping("/company")
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return new ResponseEntity<>(this.companyService.createCompany(company) ,HttpStatus.OK);
    }
    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Integer id){
        return new ResponseEntity<>(this.companyService.getComapanyById(id),HttpStatus.OK);
    }
    @PutMapping("/company/{id}")
    public ResponseEntity<Company> updateCompanyById(@RequestBody Company company,@PathVariable Integer id){

        return new ResponseEntity<>(this.companyService.updateCompanyByID(company,id),HttpStatus.OK);
    }
    @DeleteMapping("/company/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Integer id){
        this.companyService.deleteCompanyById(id);
        return  new ResponseEntity<>("deleted",HttpStatus.OK);
    }

}
