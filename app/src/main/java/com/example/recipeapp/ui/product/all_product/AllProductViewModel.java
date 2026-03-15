package com.example.recipeapp.ui.product.all_product;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.recipeapp.data.dynamic_data.favourite.Favourite;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;
import com.example.recipeapp.util.FutureHelper;

import java.util.List;

public class AllProductViewModel extends BaseRecipeAndroidViewModel {

    private final LiveData<List<Favourite>> favouriteList;

    public AllProductViewModel(@NonNull Application application) {
        super(application);
        favouriteList = container.getFavouriteRepository().selectFavourite();
    }

    public LiveData<List<Favourite>> getFavouriteList() {
        return favouriteList;
    }

    public boolean fillFavourite(List<Favourite> favourites, int idProduct) {
        if (favourites == null) {
            return false;
        }
        for (Favourite favourite : favourites) {
            if (favourite.idProduct == idProduct) {
                return true;
            }
        }
        return false;
    }

    public void addFavourite(int productId) {
        container.getFavouriteRepository().insertFavourite(new Favourite(0, productId));
    }

    public void deleteFavourite(int idFavourite, int idProduct) {
        container.getFavouriteRepository().deleteFavourite(new Favourite(idFavourite, idProduct));
    }

    public void getIdFavourite(int productId, FutureHelper.Callback<Integer> callback) {
        FutureHelper.observe(container.getFavouriteRepository().getIdFavourite(productId), callback);
    }
}
