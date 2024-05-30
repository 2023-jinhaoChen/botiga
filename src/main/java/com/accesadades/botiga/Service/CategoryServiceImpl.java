package com.accesadades.botiga.Service;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.Model.Category;
import com.accesadades.botiga.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    
    public Set<Category> findAllCategories(){
        return categoryRepository.findAll();
    }
    public Category findCategoryByName(String name){
        return categoryRepository.findByName(name);
    }
    
    public Category desar(Category category){
        return categoryRepository.save(category);
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }
}