package com.example.recipeapp.data.static_data;

import com.example.recipeapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Static ingredient data class (not to be confused with the Room entity Ingredient).
 * This represents a recipe ingredient with display name and image.
 */
public class StaticIngredient {
    private final int id;
    private final String name;
    private final int image;
    private String quantity;

    public StaticIngredient(int id, String name, int image, String quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
    }

    public StaticIngredient copy(String newQuantity) {
        return new StaticIngredient(id, name, image, newQuantity);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getImage() { return image; }
    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
}
