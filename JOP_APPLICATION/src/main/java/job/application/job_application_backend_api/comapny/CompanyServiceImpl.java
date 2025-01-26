package job.application.job_application_backend_api.comapny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.event.ComponentAdapter;
import java.lang.module.ResolutionException;
import java.util.List;

@Service

public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompany() {
       return  this.companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {

        return this.companyRepository.save(company);

    }

    @Override
    public Company getComapanyById(Integer id) {
       return this.companyRepository.findById(id).orElseThrow(()->new RuntimeException("company is not found"));
    }

    @Override
    public Company updateCompanyByID(Company company, Integer id) {
        Company updatedComapny=this.companyRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        updatedComapny.setDescription(company.getDescription());
        updatedComapny.setName(company.getName());
//        updatedComapny.setJobs(company.getJobs());

        companyRepository.save(updatedComapny);
        return  updatedComapny;
    }

    @Override
    public void deleteCompanyById(Integer id) {
       Company company= this.companyRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));

        this.companyRepository.delete(company);
    }
}
