package com.scaler.practiceproject.Service;

import com.scaler.practiceproject.Models.Category;
import com.scaler.practiceproject.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfCategoryService implements CategoryService{

    private final CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category CreateCategory(Long id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        return categoryRepository.save(category);
    }

    @Override
    public Category UpdateCategory(Long id, Category category) {
        return null;
    }

    @Override
    public void DeleteCategory(Long id) {

    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public Category GetCategoryById(Long id) {
        Category category = categoryRepository.findById(id).get();
        if (category == null) {
            return null;
        }
        return category;
    }
}
