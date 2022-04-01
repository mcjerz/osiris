package mcjerz.udemy.spring.osiris.controller;

import mcjerz.udemy.spring.osiris.domain.Product;

import mcjerz.udemy.spring.osiris.repositories.ProductRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ProductController {
    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    @ResponseStatus(HttpStatus.CREATED)
    Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/api/products")
    @ResponseStatus(HttpStatus.ACCEPTED)

    public Product updateProduct(@RequestBody Product updateProduct)
    {

        return productRepository.findById(updateProduct.getId())
                .map(product -> {
                    product.setName(updateProduct.getName());
                    product.setDescription(updateProduct.getDescription());
                    product.setPrice(updateProduct.getPrice());
                    return productRepository.save(product);
                } )
                .orElseGet(() -> productRepository.save(updateProduct));
    }


    @DeleteMapping("/api/products")

    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@RequestBody Product product) {
        productRepository.delete(product);
    }

}
