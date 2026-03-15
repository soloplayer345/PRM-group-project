package com.example.recipeapp.data;

import android.content.Context;

import com.example.recipeapp.data.dynamic_data.favourite.FavouriteRepository;
import com.example.recipeapp.data.dynamic_data.favourite.OfflineFavouriteRepository;
import com.example.recipeapp.data.dynamic_data.ingredient.IngredientRepository;
import com.example.recipeapp.data.dynamic_data.ingredient.OfflinedIngredientRepository;
import com.example.recipeapp.data.dynamic_data.recipe_person.OfflineRecipePRepository;
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePersonRepository;
import com.example.recipeapp.data.dynamic_data.schedule.OfflineScheduleRepository;
import com.example.recipeapp.data.dynamic_data.schedule.ScheduleRepository;
import com.example.recipeapp.data.dynamic_data.shopping.OfflineShoppingRepository;
import com.example.recipeapp.data.dynamic_data.shopping.ShoppingRepository;

public class AppDataContainer {

    private final Context context;

    private FavouriteRepository favouriteRepository;
    private ShoppingRepository shoppingRepository;
    private RecipePersonRepository recipePersonRepository;
    private IngredientRepository ingredientRepository;
    private ScheduleRepository scheduleRepository;

    public AppDataContainer(Context context) {
        this.context = context.getApplicationContext();
    }

    public FavouriteRepository getFavouriteRepository() {
        if (favouriteRepository == null) {
            favouriteRepository = new OfflineFavouriteRepository(
                    RecipeDatabase.getDatabase(context).favouriteDao()
            );
        }
        return favouriteRepository;
    }

    public ShoppingRepository getShoppingRepository() {
        if (shoppingRepository == null) {
            shoppingRepository = new OfflineShoppingRepository(
                    RecipeDatabase.getDatabase(context).shoppingDao()
            );
        }
        return shoppingRepository;
    }

    public RecipePersonRepository getRecipePersonRepository() {
        if (recipePersonRepository == null) {
            recipePersonRepository = new OfflineRecipePRepository(
                    RecipeDatabase.getDatabase(context).recipePersonDao()
            );
        }
        return recipePersonRepository;
    }

    public IngredientRepository getIngredientRepository() {
        if (ingredientRepository == null) {
            ingredientRepository = new OfflinedIngredientRepository(
                    RecipeDatabase.getDatabase(context).ingredientDao()
            );
        }
        return ingredientRepository;
    }

    public ScheduleRepository getScheduleRepository() {
        if (scheduleRepository == null) {
            scheduleRepository = new OfflineScheduleRepository(
                    RecipeDatabase.getDatabase(context).scheduleDao()
            );
        }
        return scheduleRepository;
    }
}
