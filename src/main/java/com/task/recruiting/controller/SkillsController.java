package com.task.recruiting.controller;

import com.task.recruiting.entity.Skills;
import com.task.recruiting.reposotory.SkillsRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  Контроллер скилов
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SkillsController {
    private final SkillsRepo skillsRepo;

    /**
     * @param skillsRepo репозиторий таблицы skills
     */
    public SkillsController(SkillsRepo skillsRepo) {
        this.skillsRepo = skillsRepo;
    }

    /**
     * @return список всех скилов
     */
    @GetMapping("/skills")
    public List<Skills> getSkills() {
        return skillsRepo.findAll();
    }

}
