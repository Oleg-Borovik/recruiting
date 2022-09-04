package com.task.recruiting.reposotory;

import com.task.recruiting.entity.BadCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий таблицы bad_company
 */
@Repository
public interface BadCompanyRepo extends JpaRepository<BadCompany, Long> {
    /**
     * @param nameCompany название компании
     * @return сущность таблицы bad_company
     */
    BadCompany findByNameCompany(String nameCompany);
}
