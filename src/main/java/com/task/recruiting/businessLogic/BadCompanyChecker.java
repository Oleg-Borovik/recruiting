package com.task.recruiting.businessLogic;

import com.task.recruiting.entity.BadCompany;
import com.task.recruiting.reposotory.BadCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class BadCompanyChecker {
    @Autowired
    private BadCompanyRepo badCompanyRepo;

    public boolean checkCompany(String company){
        BadCompany badCompany = badCompanyRepo.findByNameCompany(company);
        return badCompany == null;
    }
}
