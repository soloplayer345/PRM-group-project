package com.example.recipeapp;

import android.app.Application;

import com.example.recipeapp.data.AppDataContainer;
import com.example.recipeapp.data.static_data.Products;

public class RecipeApplication extends Application {

    private AppDataContainer container;

    @Override
    public void onCreate() {
        super.onCreate();
        container = new AppDataContainer(this);
        Products.init(this);
    }

    public AppDataContainer getContainer() {
        return container;
    }
}
