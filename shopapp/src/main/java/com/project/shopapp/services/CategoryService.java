package com.project.shopapp.services;

import com.project.shopapp.dtos.CategoryDTO;
import com.project.shopapp.models.Category;
import com.project.shopapp.repositories.CategryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor  //tự động tạo ra một constructor với các tham số tương ứng cho các trường có kiểu final
public class CategoryService implements ICategoryService{

    private final CategryRepository categryRepository;
    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category newCategory = Category
                .builder()
                .name(categoryDTO.getName())
                .build();
        return categryRepository.save(newCategory);
    }

    @Override
    public Category getCategoryById(long id) {
        return categryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categryRepository.findAll();
    }

    @Override
    public Category updateCategory(long categoryId, CategoryDTO categoryDTO) {
        Category existingCategory = getCategoryById(categoryId);
        existingCategory.setName(categoryDTO.getName());
        categryRepository.save(existingCategory);
        return existingCategory;
    }

    @Override
    public void deleleCategory(long id) {
        // xóa cứng
        categryRepository.deleteById(id);
    }
}
