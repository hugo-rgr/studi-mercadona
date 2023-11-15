package com.example.studimercadonafinal.catalog.category;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Setter
@Getter
public class Category {
    @Id
    @SequenceGenerator(
            name = "category",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable = false)
    private String label;


    public Category(String label) {
        this.label = label;
    }

    public Category() {

    }
}
