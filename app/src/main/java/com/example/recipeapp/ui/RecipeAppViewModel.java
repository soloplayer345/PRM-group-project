package com.example.recipeapp.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recipeapp.data.static_data.FooterItem;
import com.example.recipeapp.data.static_data.FooterRepository;

import java.util.ArrayList;
import java.util.List;

public class RecipeAppViewModel extends ViewModel {

    private final MutableLiveData<Boolean> footerState = new MutableLiveData<>(false);
    private final MutableLiveData<List<FooterItem>> footerItems = new MutableLiveData<>(FooterRepository.getFooterItems());
    private int idProductAddSchedule = -1;

    public LiveData<Boolean> getFooterState() {
        return footerState;
    }

    public LiveData<List<FooterItem>> getFooterItems() {
        return footerItems;
    }

    public int getIdProductAddSchedule() {
        return idProductAddSchedule;
    }

    public void setFooterState(boolean newState) {
        footerState.setValue(newState);
    }

    public void updateIdProductSchedule(int idProduct) {
        idProductAddSchedule = idProduct;
    }

    public void onItemClicked(int itemId) {
        List<FooterItem> current = footerItems.getValue();
        if (current == null) {
            return;
        }
        List<FooterItem> updated = new ArrayList<>();
        for (FooterItem item : current) {
            updated.add(new FooterItem(item.getId(), item.getIconResId(), item.getId() == itemId));
        }
        footerItems.setValue(updated);
    }
}
