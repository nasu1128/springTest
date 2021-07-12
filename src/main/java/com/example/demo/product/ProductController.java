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

    @RequestMapping(path= "/withdelete")
    public Map<String, Object> getAll(){
        HashMap<String, Object> ret = new HashMap<>();
        ret.put("success", true);
        ret.put("records",productService.getAllProduct());
        return ret;
    }

    @GetMapping(path="/list")
    public Map<String, Object> test(){
        HashMap<String, Object> ret = new HashMap<>();
        ret.put("success", true);
        ret.put("records",productService.getProduct());
        return ret;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> save(HttpServletRequest request,
                                    @RequestParam String token,
                                    @RequestParam String name,
                                    @RequestParam Integer type,
                                    @RequestParam String description) {
        HashMap<String, Object> ret = new HashMap<>();

        if(!token.equals("abcd")){
            ret.put("auth", false);
            ret.put("success", false);

//            if(true){
//                throw new IllegalStateException("token invalid");
//            }

            return ret;
        }

        Product p = new Product(name, type, description);
        ret.put("auth", true);
        ret.put("records", p);
        ret.put("success", productService.saveProduct(p));

        return ret;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(HttpServletRequest request,
                                    @RequestParam String token,
                                    @RequestParam Integer id,
                                    String name,
                                    Integer type,
                                    String description) {
        HashMap<String, Object> ret = new HashMap<>();

        if(!token.equals("abcd")){
            ret.put("auth", false);
            ret.put("success", false);
            return ret;
        }

        Product p = new Product(id,name, type, description);
        ret.put("auth", true);
        ret.put("records", p);
        ret.put("success", productService.updateProduct(id,p));

        return ret;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String, Object> delete(HttpServletRequest request,
                                      @RequestParam String token,
                                      @RequestParam Integer id
                                        ) {
        HashMap<String, Object> ret = new HashMap<>();

        if(!token.equals("abcd")){
            ret.put("auth", false);
            ret.put("success", false);
            return ret;
        }

        ret.put("auth", true);
        ret.put("success", productService.deleteProduct(id));
        ret.put("records", productService.getProduct());
        return ret;
    }


}
