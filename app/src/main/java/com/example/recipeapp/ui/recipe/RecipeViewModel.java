package com.example.recipeapp.ui.recipe;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.recipeapp.R;
import com.example.recipeapp.data.dynamic_data.favourite.Favourite;
import com.example.recipeapp.data.dynamic_data.shopping.Shopping;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;
import com.example.recipeapp.ui.navigation.NavigationKeys;
import com.example.recipeapp.util.FutureHelper;

public class RecipeViewModel extends BaseRecipeAndroidViewModel {

    private final int productId;
    private final MutableLiveData<Integer> checkFavorite = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> favouriteActionMessageRes = new MutableLiveData<>(0);
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

    public LiveData<Integer> getFavouriteActionMessageRes() {
        return favouriteActionMessageRes;
    }

    public void clearFavouriteActionMessage() {
        favouriteActionMessageRes.setValue(0);
    }

    public void addFavourite() {
        if (productId < 0) {
            favouriteActionMessageRes.setValue(R.string.message_cannot_add_favourite);
            return;
        }

        FutureHelper.observe(container.getFavouriteRepository().checkFavourite(productId), count -> {
            int currentCount = count == null ? 0 : count;
            if (currentCount > 0) {
                checkFavorite.setValue(currentCount);
                favouriteActionMessageRes.setValue(R.string.message_already_in_favourites);
                return;
            }

            FutureHelper.observe(container.getFavouriteRepository().insertFavourite(new Favourite(0, productId)), insertedId -> {
                if (insertedId != null && insertedId > 0) {
                    favouriteActionMessageRes.setValue(R.string.message_added_to_favourites);
                    updateCheckFavourite();
                    return;
                }
                favouriteActionMessageRes.setValue(R.string.message_cannot_add_favourite);
            });
        });
    }

    public void toggleFavourite() {
        Integer current = checkFavorite.getValue();
        if (current != null && current > 0) {
            deleteFavourite();
        } else {
            addFavourite();
        }
    }

    public void deleteFavourite() {
        FutureHelper.observe(container.getFavouriteRepository().getIdFavourite(productId), idFavourite -> {
            if (idFavourite != null) {
                container.getFavouriteRepository().deleteFavourite(new Favourite(idFavourite, productId));
                favouriteActionMessageRes.setValue(R.string.message_removed_from_favourites);
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
