package com.tirth.categoryservice.service;

import com.tirth.categoryservice.dto.SalonDTO;
import com.tirth.categoryservice.modal.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, SalonDTO salonDTO);
    Set<Category> getAllCategoriesBySalon(Long id);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryById(Long id, Long salonId) throws Exception;
}
