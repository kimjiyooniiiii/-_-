package com.example.product_manage.application;

import com.example.product_manage.domain.Product;
import com.example.product_manage.domain.ProductRepository;
import com.example.product_manage.presentation.ProductDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationService validationService;

    public ProductDto add(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        validationService.checkValid(product);

        Product savedProduct = productRepository.add(product);

        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        return savedProductDto;
    }

    public ProductDto findById(Long id){
        Product findProduct = productRepository.findById(id);

        return modelMapper.map(findProduct, ProductDto.class);
    }

    public List<ProductDto> findAll(){
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    public List<ProductDto> findByNameContaining(String name){
        List<Product> findProducts = productRepository.findByNameContaining(name);
        return findProducts.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    public ProductDto updateProduct(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);

        Product updateProduct = productRepository.update(product);

        return modelMapper.map(updateProduct, ProductDto.class);
    }

    public void delete(Long id){
        productRepository.delete(id);
    }
}
