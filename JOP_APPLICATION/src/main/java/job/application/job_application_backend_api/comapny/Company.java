package job.application.job_application_backend_api.comapny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import job.application.job_application_backend_api.entity.Job;
import job.application.job_application_backend_api.review.Review;

import java.util.List;

@Entity
@Table(name = "company")

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private  String description;

    @JsonIgnore
    @OneToMany
    private List<Job>jobs;

    @OneToMany
    private List<Review> reviews;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
