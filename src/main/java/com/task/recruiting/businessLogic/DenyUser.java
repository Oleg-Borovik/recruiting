package com.task.recruiting.businessLogic;

import com.task.recruiting.entity.BadCompany;
import com.task.recruiting.entity.BlacklistFido;
import com.task.recruiting.entity.ResponseCategory;
import com.task.recruiting.entity.Resume;
import com.task.recruiting.reposotory.BadCompanyRepo;
import com.task.recruiting.reposotory.BlacklistFidoRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class DenyUser implements FilterResume {
    @Autowired
    private BlacklistFidoRepo blacklistFidoRepo;

    @Override
    public long filterResume(Resume resume) {
        BlacklistFido badFido = blacklistFidoRepo.findByFido(resume.getFido());
        if(badFido != null) {
            return 4L;
        }
        return 0;
    }
}
