package com.scaler.practiceproject.Service;

import com.scaler.practiceproject.Exception.CategoryNotFoundException;
import com.scaler.practiceproject.Models.Category;

import java.util.List;

public interface CategoryService {
 Category CreateCategory(Long id, String name);
 Category UpdateCategory(Long id, Category category);
 void DeleteCategory(Long id);
 List<Category> getAllCategories() ;
 Category GetCategoryById(Long id)throws CategoryNotFoundException;
}
