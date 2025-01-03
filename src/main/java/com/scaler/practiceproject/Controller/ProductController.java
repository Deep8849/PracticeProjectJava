package com.scaler.practiceproject.Controller;

import com.scaler.practiceproject.DTO.errorDTO;
import com.scaler.practiceproject.Exception.ProductNotFoundException;
import com.scaler.practiceproject.Models.Product;
import com.scaler.practiceproject.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//For Product
//1)To create a product
//2)To update a product
//3)To delete a product
//4)To get a product


@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //This will help in creating the product
    //@RequestMapping(value = "/products", method = RequestMethod.POST)
    @PostMapping("/product")
    public Product CreateProduct(@RequestBody Product product) {
       Product p = productService.createProduct(product.getId(), product.getTitle(), product.getPrice(), product.getDescription(), product.getCategory().getName(), product.getImageUrl());
      return p;
    }
    //This will help in getting the product

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> GetProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
       Product p =  productService.getSingleProduct(id);
       ResponseEntity<Product> response = new ResponseEntity<>(p, HttpStatus.OK);
        return response;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    //This will help in updating the product

    @PutMapping("/product/{id}")
    public Product UpdateProduct(@PathVariable("id") Long id,@RequestBody Product product) {

      return  productService.updateProduct(id, product);

    }

    //This will help in deleting  the product
    @DeleteMapping("/product/{id}")
    public void DeleteProduct(@PathVariable("id") Long id ) {
      productService.deleteProduct(id);
        System.out.println("Product with ID " + id + " deleted.");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<errorDTO> handleProductNotFoundException(Exception e){
        errorDTO errorDTO = new errorDTO();
        errorDTO.setMessage(e.getMessage());
        ResponseEntity<errorDTO> response = new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
        return response;
    }
}
