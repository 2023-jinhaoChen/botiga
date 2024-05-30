package com.accesadades.botiga.Service;

import java.util.Set;
import com.accesadades.botiga.Model.Product;

public interface ProductService {
 
    Set<Product> findAllProducts();
    Product findProductsByName(String name);
    Product desar(Product product);
    void delete(Product product);
}
