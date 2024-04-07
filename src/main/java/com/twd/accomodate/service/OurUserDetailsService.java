package com.twd.accomodate.service;
import com.twd.accomodate.entity.Application;
import com.twd.accomodate.entity.Users;
import com.twd.accomodate.repository.OurUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.twd.accomodate.exception.StudentNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OurUserDetailsService implements UserDetailsService {

    @Autowired
    private OurUserRepo ourUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ourUserRepo.findByEmail(username).orElseThrow();
    }


    public Optional<Users> findById(Integer id) {
        return ourUserRepo.findById(id);
    }

    public List<Users> findAll() {

        return ourUserRepo.findAll();
    }

    public List<Application> getApplicationsForStudent(Integer studentId) {
        // Retrieve the student entity from the repository
        Users users = ourUserRepo.findById(studentId).orElse(null);

        if (users != null) {
            // Return the list of applications associated with the student
            return users.getApplications();
        } else {
            // Handle the case where the student with the given ID is not found
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }
    }

}
