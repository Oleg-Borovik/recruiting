package com.task.recruiting.controller;

import com.task.recruiting.businessLogic.ResponseLogic;
import com.task.recruiting.entity.ResponseCategory;
import com.task.recruiting.entity.Resume;
import com.task.recruiting.reposotory.ResponseCategoryRepo;
import com.task.recruiting.reposotory.ResumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Контроллер резюме
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResumeController {
    private final ResumeRepo resumeRepo;
    private final ResponseLogic responseLogic;


    /**
     * @param resumeRepo резпозиторий таблицы resume
     * @param responseLogic сервис для назначения категории кондидату
     */
    @Autowired
    public ResumeController(ResumeRepo resumeRepo,
                            ResponseLogic responseLogic) {
        this.resumeRepo = resumeRepo;
        this.responseLogic = responseLogic;
    }


    /**
     * @param resume заполненое резюме клиентом
     */
    @PostMapping("/user")
    public void setUser(@RequestBody Resume resume) {
        ResponseCategory category = responseLogic.getLogic(resume).getResponseCategory();
        resume.setResponseCategory(category);
        resumeRepo.save(resume);
    }

    /**
     * @param id категории в базе
     * @return список резюме с данной категорией
     */
    @GetMapping("/user/category/{id}")
    public List<Resume> getCategoryResume(@PathVariable Long id) {
        return resumeRepo.findByResponseCategoryId(id);
    }

    /**
     * @param id резюме удаляемого резюме
     */
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        resumeRepo.delete(resumeRepo.findById(id).get());
    }

}
