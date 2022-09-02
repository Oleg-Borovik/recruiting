package com.task.recruiting.businessLogic;

import com.task.recruiting.entity.BadCompany;
import com.task.recruiting.entity.BlacklistFido;
import com.task.recruiting.entity.ResponseCategory;
import com.task.recruiting.entity.Resume;
import com.task.recruiting.reposotory.BadCompanyRepo;
import com.task.recruiting.reposotory.BlacklistFidoRepo;
import com.task.recruiting.reposotory.ResponseCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class Offer implements FilterResume{
    @Autowired
    private BlacklistFidoRepo blacklistFidoRepo;
    @Autowired
    private BadCompanyRepo badCompanyRepo;
    @Autowired
    private ResponseCategoryRepo responseCategoryRepo;

    @Override
    public long filterResume(Resume resume) {

        int salary = resume.getSalary();
        String lvl = resume.getLevel();
        int skill = resume.getSkills().size();
//        if(badCompany != null || badFido != null) return responseCategoryRepo.findById(1)
        if((salary >= 1000 && salary <= 2000) && lvl.equals("Middle") && skill >= 7) {
            return 1L;
        }
        return 0;
    }
}
