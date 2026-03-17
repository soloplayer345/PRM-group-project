package com.example.recipeapp.ui.favouriteRecipe;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.recipeapp.data.dynamic_data.favourite.Favourite;
import com.example.recipeapp.data.static_data.Categories;
import com.example.recipeapp.data.static_data.Category;
import com.example.recipeapp.data.static_data.Product;
import com.example.recipeapp.data.static_data.Products;
import com.example.recipeapp.ui.BaseRecipeAndroidViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRecipeViewModel extends BaseRecipeAndroidViewModel {

    private final LiveData<List<Favourite>> favouriteList;
    private final List<Category> updatedCategories;
    private final Products products = Products.getInstance();

    public FavouriteRecipeViewModel(@NonNull Application application) {
        super(application);
        favouriteList = container.getFavouriteRepository().selectFavourite();
        List<Category> categories = new ArrayList<>(Categories.getInstance().getCategoryList());
        updatedCategories = new ArrayList<>();
        updatedCategories.add(new Category(-1, "Tất cả"));
        updatedCategories.addAll(categories);
    }

    public LiveData<List<Favourite>> getFavouriteList() {
        return favouriteList;
    }

    public List<Category> getUpdatedCategories() {
        return updatedCategories;
    }

    public void deleteFavourite(int idFavourite, int idProduct) {
        container.getFavouriteRepository().deleteFavourite(new Favourite(idFavourite, idProduct));
    }

    public Product getProduct(int id) {
        return products.getProduct(id);
    }
}
