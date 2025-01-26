package job.application.job_application_backend_api.impl;

import job.application.job_application_backend_api.entity.Job;
import job.application.job_application_backend_api.repos.JobRepo;
import job.application.job_application_backend_api.sevice.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Component
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepo;
    @Override
    public List<Job> getAll() {

        return jobRepo.findAll();
    }

    @Override
    public Job createJobs(Job job) {
      return this.jobRepo.save(job);
    }


    @Override
    public Job getJobById(Integer id) {
        return this.jobRepo.findById(id).orElseThrow(()->new RuntimeException("resource not found"));
    }

    @Override
    public Job updateJobById(Job job, Integer id) {
        Job job1=this.jobRepo.findById(id).orElseThrow(()->new RuntimeException("not foudn"));
        job1.setDescription(job.getDescription());
        job1.setLocation(job.getLocation());
        this.jobRepo.save(job1);
        return job1;
    }


}
