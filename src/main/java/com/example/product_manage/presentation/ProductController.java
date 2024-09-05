package com.example.product_manage.presentation;

import com.example.product_manage.application.SimpleProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final SimpleProductService simpleProductService;

    @PostMapping("/products")
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto){
        return simpleProductService.add(productDto);
    }

    @GetMapping("/products/{id}")
    public ProductDto findProductById(@PathVariable Long id){
        return simpleProductService.findById(id);
    }

    @GetMapping("/products")
    public List<ProductDto> findByName(@RequestParam(value = "name", required = false) String name){
        if(name == null){
            return simpleProductService.findAll();
        }
        return simpleProductService.findByNameContaining(name);
    }

    @PutMapping("/products/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        productDto.setId(id);

        return simpleProductService.updateProduct(productDto);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        simpleProductService.delete(id);
    }
}
