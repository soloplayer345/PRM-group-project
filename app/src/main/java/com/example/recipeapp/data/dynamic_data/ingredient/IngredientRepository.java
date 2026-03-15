package com.example.recipeapp.data.dynamic_data.ingredient;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public interface IngredientRepository {
    ListenableFuture<Long> insertIngredient(Ingredient ingredient);
    LiveData<List<Ingredient>> getItemIngredient(int id);
    ListenableFuture<Integer> updateIngredients(List<Ingredient> ingredients);
}
