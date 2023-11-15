package com.example.studimercadonafinal.catalog.promotion;

import com.example.studimercadonafinal.catalog.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Entity
@Table
@Setter
@Getter
@Check(constraints = "start_date <= end_date")
public class Promotion {
    @Id
    @SequenceGenerator(
            name = "promotion",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(nullable = false)
    private int discountPercentage;

}