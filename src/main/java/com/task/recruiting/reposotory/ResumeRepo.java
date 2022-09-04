package com.task.recruiting.reposotory;

import com.task.recruiting.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Репозиторий таблицы resume
 */
@Repository
public interface ResumeRepo extends JpaRepository<Resume, Long> {
    /**
     * @param id категории
     * @return список резюме по искомой категории
     */
    List<Resume> findByResponseCategoryId(Long id);
}
