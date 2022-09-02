package com.task.recruiting.controller;

import com.task.recruiting.entity.Resume;
import com.task.recruiting.entity.Skills;
import com.task.recruiting.reposotory.ResumeRepo;
import com.task.recruiting.reposotory.SkillsRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SkillsController {
    private final SkillsRepo skillsRepo;
    private final ResumeRepo resumeRepo;
    public SkillsController(SkillsRepo skillsRepo, ResumeRepo resumeRepo) {
        this.skillsRepo = skillsRepo;
        this.resumeRepo = resumeRepo;
    }

    @GetMapping("/skills")
    public List getSkills() {
//        Resume resume = ;
        return skillsRepo.findAll();
    }

    @GetMapping("/testSet")
    public void setSkills() {
        List<Skills> skills = skillsRepo.findBySkillIn(Arrays.asList(
                "java",
                "js",
                "css",
                "html",
                "reactJs"
        ));
        Resume res = resumeRepo.findById(1L).get();
        res.setSkills(skills);
        resumeRepo.save(res);
    }
}
