package com.accesadades.botiga.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.accesadades.botiga.Model.Subcategory;
import java.util.Set;

@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory, Long> {

    @Override
    @NonNull
    Set<Subcategory> findAll();
    Subcategory findByName(String name);
    Set<Subcategory> findById(long subcategory_id);
}
