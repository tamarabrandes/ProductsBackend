package com.products.manager;

import com.products.manager.model.Product;
import com.products.manager.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }
    @CrossOrigin
    @GetMapping("/product/all")
    public ResponseEntity <List<Product>> getAllProducts(){
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/product/find/{id}")
    public ResponseEntity <Product> getAllProductById(@PathVariable ("id") Long id) throws Throwable {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/product/findgtin/{gtin}")
    public ResponseEntity <Product> getAllProductByGtin(@PathVariable ("gtin") Long gtin) {
        Product product  = productService.findProductByGtin(gtin);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)  throws Throwable {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/product/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable ("id") Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
