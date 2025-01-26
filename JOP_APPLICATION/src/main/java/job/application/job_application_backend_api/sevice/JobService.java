package job.application.job_application_backend_api.sevice;

import job.application.job_application_backend_api.entity.Job;

import java.util.List;

public interface JobService {
    List<Job>getAll();

    Job createJobs(Job job);


    Job getJobById(Integer id);

    Job updateJobById(Job job, Integer id);
}
