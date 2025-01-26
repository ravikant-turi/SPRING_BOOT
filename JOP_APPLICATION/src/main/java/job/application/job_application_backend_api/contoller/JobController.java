package job.application.job_application_backend_api.contoller;

import job.application.job_application_backend_api.entity.Job;
import job.application.job_application_backend_api.sevice.JobService;
import job.application.job_application_backend_api.repos.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class JobController {


   @Autowired
   private JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){

        return new ResponseEntity<>(jobService.getAll(),HttpStatus.OK);
    }


    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id){

        Job job= this.jobService.getJobById(id);
        return  new  ResponseEntity<>(job, HttpStatus.OK);
    }
    @PostMapping("/jobs")
    public ResponseEntity<String>createJob(@RequestBody Job job){
        System.out.println(job.getDescription()+", "+job.getId()+" , "+job.getMaxSalary());
       Job job1= this.jobService.createJobs(job);
        return new ResponseEntity<>("created",HttpStatus.CREATED);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job>updateJob(@RequestBody Job job,@PathVariable ("id") Integer id){
        return  new ResponseEntity<>(this.jobService.updateJobById(job,id),HttpStatus.OK);
    }

}
