package com.example.recipeapp.ui.recipe;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.recipeapp.data.dynamic_data.favourite.Favourite;
import com.example.recipeapp.data.dynamic_data.shopping.Shopping;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;
import com.example.recipeapp.ui.navigation.NavigationKeys;
import com.example.recipeapp.util.FutureHelper;

public class RecipeViewModel extends BaseRecipeAndroidViewModel {

    private final int productId;
    private final MutableLiveData<Integer> checkFavorite = new MutableLiveData<>(0);
    private final MutableLiveData<Boolean> checkAddShopping = new MutableLiveData<>(true);

    public RecipeViewModel(@NonNull Application application, SavedStateHandle savedStateHandle) {
        super(application);
        Integer value = savedStateHandle.get(NavigationKeys.PRODUCT_ID);
        productId = value == null ? -1 : value;
        updateCheckFavourite();
        checkShopping();
    }

    public int getProductId() {
        return productId;
    }

    public LiveData<Integer> getCheckFavorite() {
        return checkFavorite;
    }

    public LiveData<Boolean> getCheckAddShopping() {
        return checkAddShopping;
    }

    public void addFavourite() {
        container.getFavouriteRepository().insertFavourite(new Favourite(0, productId));
    }

    public void deleteFavourite() {
        FutureHelper.observe(container.getFavouriteRepository().getIdFavourite(productId), idFavourite -> {
            if (idFavourite != null) {
                container.getFavouriteRepository().deleteFavourite(new Favourite(idFavourite, productId));
                updateCheckFavourite();
            }
        });
    }

    public void updateCheckFavourite() {
        FutureHelper.observe(container.getFavouriteRepository().checkFavourite(productId), result ->
                checkFavorite.setValue(result == null ? 0 : result));
    }

    public void addShopping() {
        container.getShoppingRepository().insertShopping(new Shopping(0, productId));
        checkShopping();
    }

    private void checkShopping() {
        FutureHelper.observe(container.getShoppingRepository().getIdShopping(productId), result ->
                checkAddShopping.setValue(result == null || result <= 0));
    }
}
