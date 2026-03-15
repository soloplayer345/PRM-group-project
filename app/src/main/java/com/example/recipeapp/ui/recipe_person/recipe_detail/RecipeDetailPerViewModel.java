package com.example.recipeapp.ui.recipe_person.recipe_detail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.recipeapp.data.dynamic_data.ingredient.Ingredient;
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;
import com.example.recipeapp.ui.navigation.NavigationKeys;

import java.util.List;

public class RecipeDetailPerViewModel extends BaseRecipeAndroidViewModel {

    private final int idRecipe;
    private final LiveData<RecipePerson> recipePerson;
    private final LiveData<List<Ingredient>> ingredient;

    public RecipeDetailPerViewModel(@NonNull Application application, SavedStateHandle savedStateHandle) {
        super(application);
        Integer value = savedStateHandle.get(NavigationKeys.PRODUCT_ID);
        idRecipe = value == null ? -1 : value;
        recipePerson = container.getRecipePersonRepository().getItemRecipeStream(idRecipe);
        ingredient = container.getIngredientRepository().getItemIngredient(idRecipe);
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public LiveData<RecipePerson> getRecipePerson() {
        return recipePerson;
    }

    public LiveData<List<Ingredient>> getIngredient() {
        return ingredient;
    }
}
