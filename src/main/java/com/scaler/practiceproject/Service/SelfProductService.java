package com.scaler.practiceproject.Service;

import com.scaler.practiceproject.Exception.ProductNotFoundException;
import com.scaler.practiceproject.Models.Category;
import com.scaler.practiceproject.Models.Product;
import com.scaler.practiceproject.Repository.CategoryRepository;
import com.scaler.practiceproject.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()){
            return product.get();
        }
        throw new ProductNotFoundException("Product is not found in our database");
    }

    @Override
    public List<Product> getAllProduct() {
//     List<Product> products = productRepository.findAll();
//        return products;
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Long id, String title, Double price, String description, String category, String image) {
        Product product = new Product();
        Category currencategory = categoryRepository.findByName(category);
        if (currencategory == null){
            Category newCat = new Category();
            newCat.setName(category);
            Category newRow = categoryRepository.save(newCat);
            product.setCategory(newRow);
        }
        else {
            product.setCategory(currencategory);
        }
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product)  {
     Optional<Product> existingProduct = productRepository.findById(id);
     if (existingProduct.isPresent()){
         existingProduct.get().setTitle(product.getTitle());
         existingProduct.get().setPrice(product.getPrice());
         existingProduct.get().setDescription(product.getDescription());
         existingProduct.get().setCategory(product.getCategory());
         existingProduct.get().setImageUrl(product.getImageUrl());

         return productRepository.save(existingProduct.get());
     }
     return null;


    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }
}
