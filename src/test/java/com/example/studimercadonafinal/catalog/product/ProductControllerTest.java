package com.example.studimercadonafinal.catalog.product;

import com.example.studimercadonafinal.catalog.category.Category;
import com.example.studimercadonafinal.catalog.category.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private ProductController productController;

    public ProductControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateProduct() {
        Long productId = 1L;
        Product updatedProduct = new Product();
        updatedProduct.setLabel("Updated Product");
        updatedProduct.setPrice(25.99);

        Category category = new Category("Test Category");
        categoryService.createCategory(category);

        // Create a Product and associate it with the Category
        Product product = new Product();
        product.setLabel("Test Product");
        product.setDescription("Product description");
        product.setPrice(20.0);
        product.setImageURL("test.jpg");
        product.setCategory(category);

        when(productService.updateProduct(eq(productId), any(Product.class))).thenReturn(updatedProduct);

        Product response = productController.updateProduct(productId, updatedProduct);

        verify(productService, times(1)).updateProduct(eq(productId), any(Product.class));
    }
}

