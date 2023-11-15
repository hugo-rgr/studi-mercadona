package com.example.studimercadonafinal.catalog.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public Promotion createPromotion(Promotion id) {
        return promotionRepository.save(id);
    }

    public Optional<Promotion> getPromotionById(Long id) {
        return promotionRepository.findById(id);
    }

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Optional<Promotion> getPromotionByProductId(Long id) {
        return promotionRepository.findByProductId(id);
    }

    public Promotion updatePromotion(Long id, Promotion promotionDetails) {
        Optional<Promotion> promotion = promotionRepository.findById(id);
        if (promotion.isPresent()) {
            Promotion existingPromotion = promotion.get();
            existingPromotion.setStartDate(promotionDetails.getStartDate());
            existingPromotion.setEndDate(promotionDetails.getEndDate());
            existingPromotion.setDiscountPercentage(promotionDetails.getDiscountPercentage());
            existingPromotion.setProduct(promotionDetails.getProduct());
            return promotionRepository.save(existingPromotion);
        }
        return null;
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

    public void deleteAllPromotions() {
        promotionRepository.deleteAll();
    }

    public void deletePromotionByProductId(Long id) {
        promotionRepository.deleteByProductId(id);
    }


}
