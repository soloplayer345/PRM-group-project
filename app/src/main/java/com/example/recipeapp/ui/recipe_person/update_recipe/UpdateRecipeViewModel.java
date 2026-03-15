package com.example.recipeapp.ui.recipe_person.update_recipe;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.recipeapp.data.dynamic_data.ingredient.Ingredient;
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;
import com.example.recipeapp.ui.navigation.NavigationKeys;
import com.example.recipeapp.ui.recipe_person.add_recipe.AddRecipeViewModel;

import java.util.ArrayList;
import java.util.List;

public class UpdateRecipeViewModel extends BaseRecipeAndroidViewModel {

    private final int idRecipe;
    private final LiveData<RecipePerson> recipePerson;
    private final LiveData<List<Ingredient>> ingredient;
    private final MutableLiveData<AddRecipeViewModel.UiStateRecipe> uiState = new MutableLiveData<>(new AddRecipeViewModel.UiStateRecipe());

    public UpdateRecipeViewModel(@NonNull Application application, SavedStateHandle savedStateHandle) {
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

    public LiveData<AddRecipeViewModel.UiStateRecipe> getUiState() {
        return uiState;
    }

    public void updateRecipe(RecipePerson updatedRecipe) {
        container.getRecipePersonRepository().updateRecipePerson(updatedRecipe);
    }

    public void updateIngredients(List<Ingredient> updatedIngredients) {
        container.getIngredientRepository().updateIngredients(updatedIngredients);
    }

    public void updateUiState(AddRecipeViewModel.UiStateRecipe uiStateRecipe) {
        uiState.setValue(uiStateRecipe);
    }

    public List<Ingredient> updateIngredientName(List<Ingredient> ingredients, int index, String newName) {
        List<Ingredient> updated = new ArrayList<>(ingredients);
        if (index >= 0 && index < updated.size()) {
            Ingredient current = updated.get(index);
            updated.set(index, new Ingredient(current.id, newName, current.weightIngre, current.idRecPer));
        }
        return updated;
    }

    public List<Ingredient> updateIngredientWeight(List<Ingredient> ingredients, int index, String newWeight) {
        List<Ingredient> updated = new ArrayList<>(ingredients);
        if (index >= 0 && index < updated.size()) {
            Ingredient current = updated.get(index);
            updated.set(index, new Ingredient(current.id, current.nameIngre, newWeight, current.idRecPer));
        }
        return updated;
    }
}
