package com.accesadades.botiga.Service;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Repository.SubcategoryRepository;

public class SubcategoryServiceImpl implements SubcategoryService{

    @Autowired
    private SubcategoryRepository subcategoryRepository;
    
    public Set<Subcategory> findAllSubcategories(){
        return null;
    }
    public Subcategory findSubcategoryByName(String name){
        return subcategoryRepository.findByName(name);
    }
    public Set<Subcategory> findAllSubcategories(String subcategory){
        return null;
    }
    
    public Subcategory desar(Subcategory subcategory){
        return null;
    }
}
