package com.scaler.practiceproject.Service;

import com.scaler.practiceproject.DTO.FakeStoreProductDTO;
import com.scaler.practiceproject.Exception.ProductNotFoundException;
import com.scaler.practiceproject.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private  RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Inside this FakeStore is going to be a third party service

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        System.out.println("we are in single product");
       FakeStoreProductDTO fakeStoreProductDTO=
               restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);

        if (fakeStoreProductDTO==null){
            throw new ProductNotFoundException("Product not found with id "+id);
        }

        System.out.println(fakeStoreProductDTO.toString());

               return fakeStoreProductDTO.getProduct();
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductDTO[] fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class );
        List<Product> products = Arrays.stream(fakeStoreProductDTO).map(FakeStoreProductDTO::getProduct) // Map DTO to Product
                .collect(Collectors.toList());
        System.out.println("Number of products fetched: " + products.size());

        return products;
    }

    @Override
    public Product createProduct(Long id, String title, Double price, String description, String category, String imageUrl) {
        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(id);
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setImage(imageUrl);

        FakeStoreProductDTO responce = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDTO, FakeStoreProductDTO.class);
        return responce.getProduct();
    }

    @Override
    public Product updateProduct(Long id, Product updateproduct) {
//        System.out.println("update product with id: " + id);
//
//        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
//        fakeStoreProductDTO.setId(id);
//        fakeStoreProductDTO.setTitle(updateproduct.getTitle());
//        fakeStoreProductDTO.setPrice(updateproduct.getPrice());
//        fakeStoreProductDTO.setDescription(updateproduct.getDescription());
//        fakeStoreProductDTO.setCategory(updateproduct.getCategory().getName());
//        fakeStoreProductDTO.setImage(updateproduct.getImageUrl());
//
//        restTemplate.put("https://fakestoreapi.com/products/" + id, fakeStoreProductDTO, FakeStoreProductDTO.class);
//
//        return fakeStoreProductDTO.getProduct();
         return null;
    }

    @Override
    public void deleteProduct(Long id) {

        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        System.out.println("Product with ID " + id + " deleted successfully.");

    }

}



