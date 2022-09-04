package com.task.recruiting.reposotory;

import com.task.recruiting.entity.ResponseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Репозиторий таблицы response_category
 */
public interface ResponseCategoryRepo extends JpaRepository<ResponseCategory, Long> {
}
