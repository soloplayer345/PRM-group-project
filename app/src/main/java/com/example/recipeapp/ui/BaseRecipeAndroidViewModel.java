package com.example.recipeapp.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.recipeapp.RecipeApplication;
import com.example.recipeapp.data.AppDataContainer;

public abstract class BaseRecipeAndroidViewModel extends AndroidViewModel {

    protected final AppDataContainer container;

    public BaseRecipeAndroidViewModel(@NonNull Application application) {
        super(application);
        this.container = ((RecipeApplication) application).getContainer();
    }
}
