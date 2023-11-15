package com.example.studimercadonafinal;

import com.example.studimercadonafinal.catalog.category.Category;
import com.example.studimercadonafinal.catalog.category.CategoryService;
import com.example.studimercadonafinal.catalog.product.Product;
import com.example.studimercadonafinal.catalog.product.ProductService;
import com.example.studimercadonafinal.catalog.promotion.Promotion;
import com.example.studimercadonafinal.catalog.promotion.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInserts implements CommandLineRunner {

    private CategoryService categoryService;
    private PromotionService promotionService;
    private ProductService productService;

    @Autowired
    public DataInserts(CategoryService categoryService, PromotionService promotionService, ProductService productService) {
        this.categoryService = categoryService;
        this.promotionService = promotionService;
        this.productService = productService;
    }

    public void dataInsertsForCategory() {
        Category catFruits = new Category("Fruits and vegetables");
        Category catBakery = new Category("Bakery");

        categoryService.createCategory(catFruits);
        categoryService.createCategory(catBakery);
    }

    public void dataInsertsForProduct() {
        Category catFruits = categoryService.getCategoryById(1L).orElseThrow();
        Category catBakery = categoryService.getCategoryById(2L).orElseThrow();

        Product prodApple = new Product();
        prodApple.setLabel("Lot de 6 pommes Golden Delicious Bio");
        prodApple.setDescription("Prix au kg: 3.85€");
        prodApple.setPrice(3.20);
        prodApple.setImageURL("https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Golden_delicious_apple.jpg/500px-Golden_delicious_apple.jpg");
        prodApple.setCategory(catFruits);
        productService.createProduct(prodApple);

        Product prodTomato = new Product();
        prodTomato.setLabel("Tomates cerises mélangées 500g");
        prodTomato.setDescription("Cultivées en France. Prix au kg: 5.99kg");
        prodTomato.setPrice(3.25);
        prodTomato.setImageURL("");
        prodTomato.setCategory(catFruits);
        productService.createProduct(prodTomato);

        Product prodPainChocolat = new Product();
        prodPainChocolat.setLabel("4 pains au chocolat");
        prodPainChocolat.setDescription("Le classique!");
        prodPainChocolat.setPrice(3.60);
        prodPainChocolat.setImageURL("https://upload.wikimedia.org/wikipedia/commons/a/ac/Corbeille_de_pains_au_chocolat.jpg?20200131201819");
        prodPainChocolat.setCategory(catBakery);
        productService.createProduct(prodPainChocolat);


    }

    public void dataInsertsForPromotion() {
        Product prodTomato = productService.getProductById(2L).orElseThrow();

        Promotion prodTomatoPromotion = new Promotion();
        prodTomatoPromotion.setProduct(prodTomato);
        prodTomatoPromotion.setStartDate(LocalDate.parse("2023-11-14"));
        prodTomatoPromotion.setEndDate(LocalDate.parse("2023-12-31"));
        prodTomatoPromotion.setDiscountPercentage(10);
        promotionService.createPromotion(prodTomatoPromotion);
    }

    @Override
    public void run(String... args) throws Exception {
        dataInsertsForCategory();
        dataInsertsForProduct();
        dataInsertsForPromotion();
    }
}
