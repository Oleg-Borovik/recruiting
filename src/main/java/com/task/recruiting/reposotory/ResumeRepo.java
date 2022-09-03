package com.task.recruiting.reposotory;

import com.task.recruiting.entity.ResponseCategory;
import com.task.recruiting.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepo extends JpaRepository<Resume, Long> {
    List<Resume> findByResponseCategory(ResponseCategory responseCategory);
}
