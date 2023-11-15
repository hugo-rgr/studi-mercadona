package com.example.studimercadonafinal.catalog.product;

import com.example.studimercadonafinal.catalog.category.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Product {
    @Id
    @SequenceGenerator(
            name = "product",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    private String description;
    private Double price;
    private String imageURL;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name="category_id")
    private Category category;

    //public Product(String label, String description, Double price, String imageURL, Category category) {
    //    this.label = label;
    //    this.description = description;
    //    this.price = price;
    //    this.imageURL = imageURL;
    //    this.category = category;
    //}

}
