package com.example.studimercadonafinal.catalog.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promotion")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @PostMapping("/create")
    public Promotion createPromotion(@RequestBody Promotion promotion) {
        return promotionService.createPromotion(promotion);
    }

    @GetMapping("/get/{id}")
    public Optional<Promotion> getPromotionById(@PathVariable Long id) {
        return promotionService.getPromotionById(id);
    }

    @GetMapping("/getAll")
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @GetMapping("/get/product/{productId}")
    public Optional<Promotion> getPromotionByProductLabel(@PathVariable Long productId) {
        return promotionService.getPromotionByProductId(productId);
    }

    @PutMapping("/update/{id}")
    public Promotion updatePromotion(@PathVariable Long id, @RequestBody Promotion promotionDetails) {
        return promotionService.updatePromotion(id, promotionDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePromotion(@PathVariable Long id) {
        promotionService.deletePromotion(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllPromotions() {
        promotionService.deleteAllPromotions();
        return "All promotions have been deleted successfully.";
    }

    @DeleteMapping("/deleteAll/product/{productId}")
    public void deletePromotionByProductId(@PathVariable Long productId) {
        promotionService.deletePromotionByProductId(productId);
    }

}

