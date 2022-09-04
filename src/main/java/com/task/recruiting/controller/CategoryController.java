package com.task.recruiting.controller;

import com.task.recruiting.entity.ResponseCategory;
import com.task.recruiting.reposotory.ResponseCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контролеер категорий
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    private final ResponseCategoryRepo responseCategoryRepo;

    /**
     * @param responseCategoryRepo репозиторий таблицы response_category
     */
    @Autowired
    public CategoryController(ResponseCategoryRepo responseCategoryRepo) {
        this.responseCategoryRepo = responseCategoryRepo;
    }

    /**
     * @return список всех категорий в таблице
     */
    @GetMapping("/category/all")
    public List<ResponseCategory> getCategory() {
        return responseCategoryRepo.findAll();
    }

}
