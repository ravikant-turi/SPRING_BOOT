package job.application.job_application_backend_api.repos;

import job.application.job_application_backend_api.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JobRepo extends JpaRepository<Job,Integer> {

}
