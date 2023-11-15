package com.example.studimercadonafinal.catalog.promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    @Query(value = "SELECT p FROM Promotion p JOIN p.product pr WHERE pr.id = :productId")
    Optional<Promotion> findByProductId(Long productId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Promotion p WHERE p.product.id = :productId")
    void deleteByProductId(Long productId);
}
