package com.tacoCloud.haotian.repository;

import com.tacoCloud.haotian.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
