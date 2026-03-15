package com.example.recipeapp.data.static_data;

import java.util.List;

public class Product {
    private final int id;
    private final String name;
    private final int image;
    private final int timeComplete;
    private final List<StaticIngredient> ingredient;
    private final List<Procedure> procedure;
    private final List<Category> category;

    public Product(int id, String name, int image, int timeComplete,
                   List<StaticIngredient> ingredient, List<Procedure> procedure,
                   List<Category> category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.timeComplete = timeComplete;
        this.ingredient = ingredient;
        this.procedure = procedure;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getImage() { return image; }
    public int getTimeComplete() { return timeComplete; }
    public List<StaticIngredient> getIngredient() { return ingredient; }
    public List<Procedure> getProcedure() { return procedure; }
    public List<Category> getCategory() { return category; }
}
