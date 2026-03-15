package com.example.recipeapp.ui.product.category_product;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.recipeapp.ui.navigation.NavigationKeys;

public class CateProViewModel extends ViewModel {

    private final int cateId;

    public CateProViewModel(SavedStateHandle savedStateHandle) {
        Integer value = savedStateHandle.get(NavigationKeys.CATEGORY_ID);
        this.cateId = value == null ? -1 : value;
    }

    public int getCateId() {
        return cateId;
    }
}
