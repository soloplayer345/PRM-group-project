package com.example.recipeapp;

import android.app.Application;

import com.example.recipeapp.data.AppDataContainer;

public class RecipeApplication extends Application {

    private AppDataContainer container;

    @Override
    public void onCreate() {
        super.onCreate();
        container = new AppDataContainer(this);
    }

    public AppDataContainer getContainer() {
        return container;
    }
}
