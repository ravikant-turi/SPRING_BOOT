package job.application.job_application_backend_api.comapny;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();

    Company createCompany(Company company);

    Company getComapanyById(Integer id);

    Company updateCompanyByID(Company company, Integer id);

    void deleteCompanyById(Integer id);
}
