package com.example.recipeapp.data.dynamic_data.recipe_person;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public interface RecipePersonRepository {
    ListenableFuture<Long> insertRecipePerson(RecipePerson recipePerson);
    LiveData<List<RecipePerson>> getAll();
    ListenableFuture<Integer> deleteRecipePerson(RecipePerson recipePerson);
    LiveData<RecipePerson> getItemRecipeStream(int id);
    ListenableFuture<Integer> updateRecipePerson(RecipePerson recipePerson);
    ListenableFuture<Integer> getLastInsertId();
    ListenableFuture<Integer> getCount();
}
