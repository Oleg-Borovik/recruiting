package com.task.recruiting.businessLogic;

import com.task.recruiting.entity.BadCompany;
import com.task.recruiting.entity.BlacklistFido;
import com.task.recruiting.entity.ResponseCategory;
import com.task.recruiting.entity.Resume;
import com.task.recruiting.reposotory.BadCompanyRepo;
import com.task.recruiting.reposotory.BlacklistFidoRepo;
import com.task.recruiting.reposotory.ResponseCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Сервис назначения категории в зависимости от резюме
 */
@Service
public class ResponseLogic {
    private final BlacklistFidoRepo blacklistFidoRepo;
    private final BadCompanyRepo badCompanyRepo;
    private final ResponseCategoryRepo responseCategoryRepo;

    /**
     * @param blacklistFidoRepo репозиторий плохих ФИО
     * @param badCompanyRepo репозиторий плохих компаний
     * @param responseCategoryRepo репозиторий категорий
     */
    @Autowired
    public ResponseLogic(BlacklistFidoRepo blacklistFidoRepo,
                         BadCompanyRepo badCompanyRepo,
                         ResponseCategoryRepo responseCategoryRepo) {
        this.blacklistFidoRepo = blacklistFidoRepo;
        this.badCompanyRepo = badCompanyRepo;
        this.responseCategoryRepo = responseCategoryRepo;
    }
//    private Resume resume;

    /**
     * @param resume резюме кондидата
     * @return резюме с назначеной категорией
     */
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
        return setCategory(5L, resume);
    }

    /**
     * @param category ид категории
     * @param resume резюме в которую назначим новую категорию
     * @return измененное резюме
     */
    private Resume setCategory(long category, Resume resume) {
        ResponseCategory responseCategory = responseCategoryRepo.findById(category).get();
        resume.setResponseCategory(responseCategory);
        return resume;
    }
}
