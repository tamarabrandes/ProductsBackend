package com.products.manager.service;


import com.products.manager.exception.productFrontendExceptions;
import com.products.manager.model.Product;
import com.products.manager.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        String gtin = product.getGtin().toString();
        StringBuilder frontMessage = new StringBuilder();
        product.setProductCode(UUID.randomUUID().toString());

        if (product.getTitel().length() > 20) {
            frontMessage.append("Title of your product is too long");
        }

        Product savedProduct = null;
        if (frontMessage.length() == 0) {
            savedProduct = productRepo.save(product);
        }

        return productRepo.findProductById(Long.valueOf(savedProduct.getId()))
                .orElseThrow(() -> new productFrontendExceptions(frontMessage.toString()));
    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
       productRepo.deleteProductById(id);
    }

    public Product findProductById(Long id) throws Throwable {
        return productRepo.findProductById(id)
                .orElseThrow(()-> new productFrontendExceptions("Product with id" + id + "was not found"));
    }

    public Product findProductByGtin(Long gtin) {
        return productRepo.findProductByGtin(gtin).orElse(null);
    }
}
