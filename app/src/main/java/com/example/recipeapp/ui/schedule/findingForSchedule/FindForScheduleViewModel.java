package com.example.recipeapp.ui.schedule.findingForSchedule;

import androidx.lifecycle.ViewModel;

import com.example.recipeapp.data.static_data.Product;
import com.example.recipeapp.data.static_data.Products;

import java.util.List;

public class FindForScheduleViewModel extends ViewModel {

    private final Products products = new Products();

    public List<Product> getListProduct(String searchWord) {
        return products.getProductsByName(searchWord == null ? "" : searchWord);
    }
}
