package com.example.recipeapp.ui.recipe_person;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;
import com.example.recipeapp.util.FutureHelper;

import java.util.List;

public class ShowRecipeViewModel extends BaseRecipeAndroidViewModel {

    private final LiveData<List<RecipePerson>> showDataState;
    private final MutableLiveData<Integer> countRecipeState = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> countFavourState = new MutableLiveData<>(0);

    public ShowRecipeViewModel(@NonNull Application application) {
        super(application);
        showDataState = container.getRecipePersonRepository().getAll();
        refreshCounts();
    }

    public LiveData<List<RecipePerson>> getShowDataState() {
        return showDataState;
    }

    public LiveData<Integer> getCountRecipeState() {
        return countRecipeState;
    }

    public LiveData<Integer> getCountFavourState() {
        return countFavourState;
    }

    public void refreshCounts() {
        FutureHelper.observe(container.getRecipePersonRepository().getCount(), result ->
                countRecipeState.setValue(result == null ? 0 : result));
        FutureHelper.observe(container.getFavouriteRepository().getCountFavourite(), result ->
                countFavourState.setValue(result == null ? 0 : result));
    }

    public void deleteRecipe(RecipePerson recipePerson) {
        container.getRecipePersonRepository().deleteRecipePerson(recipePerson);
        refreshCounts();
    }
}
