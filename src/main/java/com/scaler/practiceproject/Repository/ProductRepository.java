package com.scaler.practiceproject.Repository;

import com.scaler.practiceproject.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //This will insert in my product table
    Product save(Product product);

    //select * from Product where title = title
    Product findByTitle(String title);

   //select * from Product where Description = description
    Product findByDescription(String description);

    Product deleteProductById(Long id);


}
