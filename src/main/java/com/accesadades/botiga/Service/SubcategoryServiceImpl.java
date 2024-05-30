package com.accesadades.botiga.Service;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Repository.SubcategoryRepository;

@Service
public class SubcategoryServiceImpl implements SubcategoryService{

    @Autowired
    private SubcategoryRepository subcategoryRepository;
    
    public Set<Subcategory> findAllSubcategories(){
        return subcategoryRepository.findAll();
    }
    public Subcategory findSubcategoryByName(String name){
        return subcategoryRepository.findByName(name);
    }
    
    public Subcategory desar(Subcategory subcategory){
        return subcategoryRepository.save(subcategory);
    }

    public void delete(Subcategory subcategory){
        subcategoryRepository.delete(subcategory);
    }
}
