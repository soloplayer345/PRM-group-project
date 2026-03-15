package com.example.recipeapp.data.static_data;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private final List<Category> listCategory;

    public Categories() {
        listCategory = new ArrayList<>();
        listCategory.add(new Category(0, "Món khai vị"));
        listCategory.add(new Category(1, "Món chính"));
        listCategory.add(new Category(2, "Món tráng miệng"));
        listCategory.add(new Category(3, "Món ăn sáng"));
        listCategory.add(new Category(4, "Đồ nướng"));
        listCategory.add(new Category(5, "Món rau củ"));
        listCategory.add(new Category(6, "Món canh"));
    }

    public List<Category> getCategoryList() {
        return listCategory;
    }
}
