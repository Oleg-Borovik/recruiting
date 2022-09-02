package com.task.recruiting.reposotory;

import com.task.recruiting.entity.BadCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadCompanyRepo extends JpaRepository<BadCompany, Long> {
    BadCompany findByNameCompany(String nameCompany);
}
