package com.scaler.practiceproject;

import com.scaler.practiceproject.Models.Category;
import com.scaler.practiceproject.Repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PracticeProjectApplicationTests {

    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchTypeTest(){
        Category cat = categoryRepository.findById(1L).get();
        System.out.println(cat.getId());
    }
}
