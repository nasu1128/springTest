package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/product/detail")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
        //this.productService = new ProductService();
    }

    @GetMapping
    public List<Product> test(){
        return productService.getProduct();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> save(HttpServletRequest request,
                                    @RequestParam String name, @RequestParam Integer type, @RequestParam String description) {
        HashMap<String, Object> ret = new HashMap<>();

        Product p = new Product(name, type, description);

        ret.put("records", p);
        ret.put("success", productService.saveProduct(p));

        return ret;
    }


}
