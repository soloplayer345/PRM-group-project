package com.example.recipeapp.ui.recipe_person.add_recipe;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recipeapp.data.dynamic_data.ingredient.Ingredient;
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;
import com.example.recipeapp.util.FutureHelper;

import java.util.ArrayList;
import java.util.List;

public class AddRecipeViewModel extends BaseRecipeAndroidViewModel {

    private final LiveData<List<RecipePerson>> showDataState;
    private final MutableLiveData<UiStateRecipe> uiStateRecipe = new MutableLiveData<>(new UiStateRecipe());
    private final MutableLiveData<List<UINguyenLieu>> ingredients = new MutableLiveData<>(new ArrayList<>());

    public AddRecipeViewModel(@NonNull Application application) {
        super(application);
        showDataState = container.getRecipePersonRepository().getAll();
    }

    public LiveData<List<RecipePerson>> getShowDataState() {
        return showDataState;
    }

    public LiveData<UiStateRecipe> getUiStateRecipe() {
        return uiStateRecipe;
    }

    public LiveData<List<UINguyenLieu>> getIngredients() {
        return ingredients;
    }

    public void updateUiState(UiStateRecipe state) {
        uiStateRecipe.setValue(state);
    }

    public void addIngredient(String nameIngre, String weightIngre) {
        List<UINguyenLieu> current = new ArrayList<>(safeIngredients());
        current.add(new UINguyenLieu(0, nameIngre, weightIngre, 0));
        ingredients.setValue(current);
    }

    public void updateIngredient(int index, String nameIngre, String weightIngre) {
        List<UINguyenLieu> current = new ArrayList<>(safeIngredients());
        if (index < 0 || index >= current.size()) {
            return;
        }
        UINguyenLieu existing = current.get(index);
        current.set(index, new UINguyenLieu(existing.id, nameIngre, weightIngre, existing.idRecPer));
        ingredients.setValue(current);
    }

    public void removeIngredient(int index) {
        List<UINguyenLieu> current = new ArrayList<>(safeIngredients());
        if (index < 0 || index >= current.size()) {
            return;
        }
        current.remove(index);
        ingredients.setValue(current);
    }

    public void addRecipe() {
        UiStateRecipe recipeState = uiStateRecipe.getValue();
        if (recipeState == null) {
            return;
        }
        container.getRecipePersonRepository().insertRecipePerson(recipeState.toRecipePerson());
        FutureHelper.observe(container.getRecipePersonRepository().getLastInsertId(), id -> {
            if (id == null) {
                return;
            }
            for (UINguyenLieu ingredient : safeIngredients()) {
                container.getIngredientRepository().insertIngredient(ingredient.toIngredient(id));
            }
        });
    }

    private List<UINguyenLieu> safeIngredients() {
        List<UINguyenLieu> value = ingredients.getValue();
        return value == null ? new ArrayList<>() : value;
    }

    public static class UiStateRecipe {
        public int id;
        public String nameRecipe = "";
        public String time = "";
        public String step = "";

        public RecipePerson toRecipePerson() {
            return new RecipePerson(id, nameRecipe, time, step);
        }
    }

    public static class UINguyenLieu {
        public int id;
        public String nameIngre;
        public String weightIngre;
        public int idRecPer;

        public UINguyenLieu(int id, String nameIngre, String weightIngre, int idRecPer) {
            this.id = id;
            this.nameIngre = nameIngre;
            this.weightIngre = weightIngre;
            this.idRecPer = idRecPer;
        }

        public Ingredient toIngredient(int recipeId) {
            return new Ingredient(id, nameIngre, weightIngre, recipeId);
        }
    }
}
