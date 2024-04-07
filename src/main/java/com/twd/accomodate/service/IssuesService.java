package com.twd.accomodate.service;
import com.twd.accomodate.entity.Issues;
import com.twd.accomodate.repository.IssuesRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class IssuesService {
    private final IssuesRepository issuesRepository;

    @Autowired
    public IssuesService(IssuesRepository issuesRepository) {
        this.issuesRepository = issuesRepository;
    }

    public Issues reportIssue(Issues issue) {
        // Set reportedAt timestamp
        issue.setReportedAt(new Date());
        return issuesRepository.save(issue);
    }

    public Optional<Issues> findById(Long id) {
        return issuesRepository.findById(id);
    }

    public Issues updateIssue(Issues issue) {

        issue.setSolvedAt(new Date());
        return issuesRepository.save(issue);
    }


    public Optional<Issues> updateIssue(Long id, Map<String, Object> updates) {
        Optional<Issues> optionalIssue = issuesRepository.findById(id);
        if (optionalIssue.isPresent()) {
            Issues issue = optionalIssue.get();
            updates.forEach((key, value) -> {
                switch (key) {
                    case "status":
                        issue.setStatus((String) value);
                        break;
                    case "solvedAt":
                        // Parse the string date to a Date object
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
                        try {
                            Date solvedAt = dateFormat.parse((String) value);
                            issue.setSolvedAt(solvedAt);
                        } catch (ParseException e) {
                            // Handle parsing error
                            e.printStackTrace();
                        }
                        break;

                    default:
                        // Handle other fields if needed
                }
            });
            return Optional.of(issuesRepository.save(issue));
        }
        return Optional.empty();
    }

    public Optional<Issues> getIssueById(Long id) {
        return issuesRepository.findById(id);
    }

    public List<Issues> getAllIssues() {
        return issuesRepository.findAll();
    }

}
