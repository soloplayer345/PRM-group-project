package com.example.recipeapp.ui.product.find_name_product;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.recipeapp.ui.navigation.NavigationKeys;

public class FindNameViewModel extends ViewModel {

    private final String keyproName;

    public FindNameViewModel(SavedStateHandle savedStateHandle) {
        String value = savedStateHandle.get(NavigationKeys.PRODUCT_NAME);
        this.keyproName = value == null ? "" : value;
    }

    public String getKeyproName() {
        return keyproName;
    }
}
