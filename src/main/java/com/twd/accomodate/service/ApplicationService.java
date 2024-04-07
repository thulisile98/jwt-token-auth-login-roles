package com.twd.accomodate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twd.accomodate.entity.Application;
import com.twd.accomodate.repository.ApplicationRepository;
import java.util.List;
import java.util.Optional;

@Service

public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(Integer id) {
        return applicationRepository.findById(id);
    }

    public Application createApplication(Application application) {



        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsByStudentId(Integer studentId) {
        return applicationRepository.findByUsersId(studentId);
    }

    public void deleteApplicationById(Integer id) {
        applicationRepository.deleteById(id);
    }
}
