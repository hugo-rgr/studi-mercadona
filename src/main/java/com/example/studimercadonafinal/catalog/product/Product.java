package com.example.studimercadonafinal.catalog.product;

import com.example.studimercadonafinal.catalog.category.Category;
import com.example.studimercadonafinal.catalog.promotion.Promotion;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

    @Column(nullable=false)
    private String label;
    private String description;
    @Column(nullable=false)
    private Double price;
    private String imageURL;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name="category_id")
    private Category category;

    @OneToOne(targetEntity = Promotion.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name="promotion_id")
    @NotFound(action= NotFoundAction.IGNORE)
    private Promotion promotion;

    //public Product(String label, String description, Double price, String imageURL, Category category) {
    //    this.label = label;
    //    this.description = description;
    //    this.price = price;
    //    this.imageURL = imageURL;
    //    this.category = category;
    //}

}
