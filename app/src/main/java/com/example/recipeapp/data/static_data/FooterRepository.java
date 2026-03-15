package com.example.recipeapp.data.static_data;

import java.util.ArrayList;
import java.util.List;

public final class FooterRepository {

    private FooterRepository() {
    }

    public static List<FooterItem> getFooterItems() {
        List<FooterItem> items = new ArrayList<>();
        items.add(new FooterItem(1, android.R.drawable.ic_menu_view, true));
        items.add(new FooterItem(2, android.R.drawable.btn_star_big_on, false));
        items.add(new FooterItem(3, android.R.drawable.ic_input_add, false));
        items.add(new FooterItem(4, android.R.drawable.ic_menu_agenda, false));
        items.add(new FooterItem(5, android.R.drawable.ic_menu_myplaces, false));
        return items;
    }
}
