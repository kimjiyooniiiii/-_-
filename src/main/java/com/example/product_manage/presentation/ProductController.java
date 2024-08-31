package com.example.product_manage.presentation;

import com.example.product_manage.application.SimpleProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final SimpleProductService simpleProductService;

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return simpleProductService.add(productDto);
    }

    @GetMapping("/product/{id}")
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

    @PutMapping("/product/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        productDto.setId(id);

        return simpleProductService.updateProduct(productDto);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id){
        simpleProductService.delete(id);
    }
}
