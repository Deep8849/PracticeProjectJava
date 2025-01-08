package com.scaler.practiceproject.DTO;

import com.scaler.practiceproject.Models.Category;
import com.scaler.practiceproject.Models.Product;
import lombok.Getter;
import lombok.Setter;



public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;

    //This will get the product detail from my implementation using the values
    //from fakeStore

    public Product getProduct() {
//        Product product = new Product();
//        product.setId(id);
//        product.setTitle(title);
//        product.setPrice(price);
//        product.setDescription(description);
//        product.setImageUrl(image);
//
//        Category category = new Category();
//        category.setId(id);
//        category.setName(title);
//        product.setCategory(category);
//
//        return product;
  return null;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FakeStoreProductDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
