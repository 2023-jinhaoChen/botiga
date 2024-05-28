package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Repository.ProductRepository;

@Service
public interface SubcategoryService {
    Set<Subcategory> findAllSubcategories();
    Subcategory findSubcategoryByName(String name);
    Set<Subcategory> findAllSubcategories(String subcategory);
    Subcategory desar(Subcategory subcategory);
}
