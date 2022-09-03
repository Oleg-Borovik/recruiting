package com.task.recruiting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.task.recruiting.businessLogic.ResponseLogic;
import com.task.recruiting.entity.ResponseCategory;
import com.task.recruiting.entity.Resume;
import com.task.recruiting.reposotory.ResponseCategoryRepo;
import com.task.recruiting.reposotory.ResumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResumeController {
    private final ResumeRepo resumeRepo;
    private final ResponseLogic responseLogic;
    private final ResponseCategoryRepo responseCategoryRepo;

    @Autowired
    public ResumeController(ResumeRepo resumeRepo,
                            ResponseLogic responseLogic,
                            ResponseCategoryRepo responseCategoryRepo) {
        this.resumeRepo = resumeRepo;
        this.responseLogic = responseLogic;
        this.responseCategoryRepo = responseCategoryRepo;
    }

    @GetMapping("/getCategoryResume/{id}")
    public List<Resume> getResume(@PathVariable Long id) {
        ResponseCategory category = responseCategoryRepo.findById(id).get();
        return resumeRepo.findByResponseCategory(category);
    }

    @PostMapping("/setUser")
    public void setUser(@RequestBody Resume resume) {
//        ParserResume parserResume = new ParserResume();
//        parserResume.parseResume(json);

        ResponseCategory category = responseLogic.getLogic(resume).getResponseCategory();
        resume.setResponseCategory(category);
        resumeRepo.save(resume);

    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        resumeRepo.delete(resumeRepo.findById(id).get());
    }

}
