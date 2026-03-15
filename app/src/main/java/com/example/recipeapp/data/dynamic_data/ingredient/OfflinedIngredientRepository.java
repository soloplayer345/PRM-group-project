package com.example.recipeapp.data.dynamic_data.ingredient;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public class OfflinedIngredientRepository implements IngredientRepository {

    private final IngredientDao ingredientDao;

    public OfflinedIngredientRepository(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @Override
    public ListenableFuture<Long> insertIngredient(Ingredient ingredient) {
        return ingredientDao.insertIngredient(ingredient);
    }

    @Override
    public LiveData<List<Ingredient>> getItemIngredient(int id) {
        return ingredientDao.getItemIngredient(id);
    }

    @Override
    public ListenableFuture<Integer> updateIngredients(List<Ingredient> ingredients) {
        return ingredientDao.updateIngredients(ingredients);
    }
}
