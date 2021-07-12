package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProduct(){
        List<Product> temp = productRepository.findAll();
        temp.removeIf(product -> product.getDeleted());
        return temp;
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Boolean saveProduct(Product product) {
        productRepository.save(product);
        return true;
    }

    public Boolean updateProduct(Integer id, Product newProductData){
        productRepository.findById(id)
        .map(product ->{
            if(newProductData.getName() != null)
                product.setName(newProductData.getName());
            if(newProductData.getType() != null)
                product.setType(newProductData.getType());
            if(newProductData.getDescription() != null)
                product.setDescription(newProductData.getDescription());
            return productRepository.save(product);
        });
        return true;
    }

    public Boolean deleteProduct(Integer id){
        productRepository.findById(id)
                .map(product ->{
                    product.setDeleted(true);
                    return productRepository.save(product);
                });
        //productRepository.deleteById(id);
        return true;
    }
}
