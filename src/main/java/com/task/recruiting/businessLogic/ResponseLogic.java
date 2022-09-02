package com.task.recruiting.businessLogic;

import com.task.recruiting.entity.*;
import com.task.recruiting.reposotory.BadCompanyRepo;
import com.task.recruiting.reposotory.BlacklistFidoRepo;
import com.task.recruiting.reposotory.ResponseCategoryRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


@Controller
public class ResponseLogic {
    @Autowired
    private BlacklistFidoRepo blacklistFidoRepo;
    @Autowired
    private BadCompanyRepo badCompanyRepo;
    @Autowired
    private ResponseCategoryRepo responseCategoryRepo;
//    private Resume resume;

    public Resume getLogic(Resume resume) {
        int salary = resume.getSalary();
        String lvl = resume.getLevel();
        int skill = resume.getSkills().size();
        BlacklistFido badFido = blacklistFidoRepo.findByFido(resume.getFido());
        BadCompany badCompany = badCompanyRepo.findByNameCompany(resume.getPreviousPlace());
        /*
            ФИО есть в базе кондидатов с плохой репутацией
         */

        if (badFido != null) {
            return setCategory(4L, resume);
        }
        else if (badCompany == null &&
                (salary >= 1000 && salary <= 2000) &&
                lvl.equals("Middle") &&
                skill >= 7) {
        /*
            Компания и фио нету в базе И
            зарплата от 1000 до 2000 включительно И
            уровень Мидл И
            скилов больше 7
         */
            return setCategory(1L, resume);
        }
        /*
            Компания и фио нету в базе И
            зарплата от 0 до 999 или 2001 до 3000 включительно И
            уровень Джуниор или Сильнер И
            скилов меньше 6
         */
        else if (badCompany == null &&
                (salary < 1000 || (salary > 2000 && salary <= 3000)) &&
                (lvl.equals("Junior") || lvl.equals("Senior")) &&
                skill < 7) {
            return setCategory(2L, resume);
        }
        /*
            фио нету в базе И
            зарплата от 3001 И
            любое кол-во навыков и любой уровень
         */
        else if (salary > 3000) {
            return setCategory(3L, resume);
        }
        return resume;
    }

    private Resume setCategory(long category, Resume resume) {
        System.out.println(category);
        ResponseCategory responseCategory = responseCategoryRepo.findById(category).get();
        resume.setResponseCategory(responseCategory);
        return resume;
    }
}
