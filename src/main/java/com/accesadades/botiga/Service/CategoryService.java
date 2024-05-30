package com.accesadades.botiga.Service;

import java.util.Set;
import com.accesadades.botiga.Model.Category;

public interface CategoryService {
    Set<Category> findAllCategories();
    Category findCategoryByName(String name);
    Category desar(Category category);
    void delete(Category category);
    
}
