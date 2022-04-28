package com.tacoCloud.haotian.repository;

import com.tacoCloud.haotian.models.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);

}
