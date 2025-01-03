package com.scaler.practiceproject.Service;

import com.scaler.practiceproject.Exception.ProductNotFoundException;
import com.scaler.practiceproject.Models.Product;

import java.util.List;

public interface ProductService {
Product getSingleProduct(Long id) throws ProductNotFoundException;

List<Product> getAllProduct();

Product createProduct(Long id, String title, Double price, String description,  String category, String image);

Product updateProduct(Long id, Product product);

void deleteProduct(Long id);
}
