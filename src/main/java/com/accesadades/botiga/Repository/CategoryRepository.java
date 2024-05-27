package com.accesadades.botiga.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.accesadades.botiga.Model.Category;
import java.util.Set;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    @NonNull
    Set<Category> findAll();
    Category findByName(String name);
    Set<Category> findById(long category_id);
}
