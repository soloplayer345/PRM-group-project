package com.example.recipeapp.data.dynamic_data.recipe_person;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public class OfflineRecipePRepository implements RecipePersonRepository {

    private final RecipePersonDao recipePersonDao;

    public OfflineRecipePRepository(RecipePersonDao recipePersonDao) {
        this.recipePersonDao = recipePersonDao;
    }

    @Override
    public ListenableFuture<Long> insertRecipePerson(RecipePerson recipePerson) {
        return recipePersonDao.insertRecipePerson(recipePerson);
    }

    @Override
    public LiveData<List<RecipePerson>> getAll() {
        return recipePersonDao.getAll();
    }

    @Override
    public ListenableFuture<Integer> deleteRecipePerson(RecipePerson recipePerson) {
        return recipePersonDao.deleteRecipePerson(recipePerson);
    }

    @Override
    public LiveData<RecipePerson> getItemRecipeStream(int id) {
        return recipePersonDao.getItemRecipeStream(id);
    }

    @Override
    public ListenableFuture<Integer> updateRecipePerson(RecipePerson recipePerson) {
        return recipePersonDao.updateRecipePerson(recipePerson);
    }

    @Override
    public ListenableFuture<Integer> getLastInsertId() {
        return recipePersonDao.getLastInsertId();
    }

    @Override
    public ListenableFuture<Integer> getCount() {
        return recipePersonDao.getCount();
    }
}
