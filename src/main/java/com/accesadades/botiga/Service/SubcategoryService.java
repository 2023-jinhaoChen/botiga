package com.accesadades.botiga.Service;

import java.util.Set;
import com.accesadades.botiga.Model.Subcategory;


public interface SubcategoryService {
    Set<Subcategory> findAllSubcategories();
    Subcategory findSubcategoryByName(String name);
    Set<Subcategory> findAllSubcategories(String subcategory);
    Subcategory desar(Subcategory subcategory);
}
