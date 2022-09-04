package com.task.recruiting.reposotory;

import com.task.recruiting.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Репозиторий таблицы skills
 */
@Repository
public interface SkillsRepo extends JpaRepository<Skills, Long> {
}
