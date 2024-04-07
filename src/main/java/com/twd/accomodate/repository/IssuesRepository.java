package com.twd.accomodate.repository;
import com.twd.accomodate.entity.Issues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuesRepository extends JpaRepository<Issues, Long> {
}
