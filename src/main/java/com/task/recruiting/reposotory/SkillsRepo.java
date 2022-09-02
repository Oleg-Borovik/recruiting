package com.task.recruiting.reposotory;

import com.task.recruiting.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

@Repository
public interface SkillsRepo extends JpaRepository<Skills, Long> {
    List<Skills> findBySkillIn(Collection<String> skill);
}
