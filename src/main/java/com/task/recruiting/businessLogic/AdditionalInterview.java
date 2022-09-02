package com.task.recruiting.businessLogic;

import com.task.recruiting.entity.Resume;
import com.task.recruiting.reposotory.BadCompanyRepo;
import com.task.recruiting.reposotory.BlacklistFidoRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionalInterview implements FilterResume {
    @Autowired
    private BadCompanyRepo badCompanyRepo;
    @Autowired
    private BlacklistFidoRepo blacklistFidoRepo;
    @Override
    public long filterResume(Resume resume) {
        int salary = resume.getSalary();
        String lvl = resume.getLevel();
        int skill = resume.getSkills().size();


        return 0;
    }
}
