package com.task.recruiting.controller;

import com.task.recruiting.businessLogic.ResponseLogic;
import com.task.recruiting.entity.Resume;
import com.task.recruiting.reposotory.ResumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResumeController {
    private final ResumeRepo resumeRepo;
    private final ResponseLogic responseLogic;

    @Autowired
    public ResumeController(ResumeRepo resumeRepo, ResponseLogic responseLogic) {
        this.resumeRepo = resumeRepo;
        this.responseLogic = responseLogic;
    }

    @GetMapping("/resume")
    public String getResume(){
        return resumeRepo.findById(1L).get().toString();
    }

    @PostMapping("/setUser")
    public void setUser(@RequestBody Resume resume){
        System.out.println(resume.toString());
//        ResponseLogic responseLogic = new ResponseLogic();

        System.out.println(responseLogic.getLogic(resume).getResponseCategory());
//        resumeRepo.save(resume);
    }

}
