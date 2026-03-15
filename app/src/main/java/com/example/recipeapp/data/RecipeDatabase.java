package com.example.recipeapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.recipeapp.data.dynamic_data.favourite.Favourite;
import com.example.recipeapp.data.dynamic_data.favourite.FavouriteDao;
import com.example.recipeapp.data.dynamic_data.ingredient.Ingredient;
import com.example.recipeapp.data.dynamic_data.ingredient.IngredientDao;
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePersonDao;
import com.example.recipeapp.data.dynamic_data.schedule.Schedule;
import com.example.recipeapp.data.dynamic_data.schedule.ScheduleDao;
import com.example.recipeapp.data.dynamic_data.shopping.Shopping;
import com.example.recipeapp.data.dynamic_data.shopping.ShoppingDao;

@Database(
        entities = {
                Favourite.class,
                Shopping.class,
                RecipePerson.class,
                Ingredient.class,
                Schedule.class
        },
        version = 4,
        exportSchema = false
)
public abstract class RecipeDatabase extends RoomDatabase {

    public abstract FavouriteDao favouriteDao();
    public abstract ShoppingDao shoppingDao();
    public abstract RecipePersonDao recipePersonDao();
    public abstract IngredientDao ingredientDao();
    public abstract ScheduleDao scheduleDao();

    private static volatile RecipeDatabase INSTANCE;

    public static RecipeDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (RecipeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    RecipeDatabase.class,
                                    "item_database"
                            )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
