package com.example.recipeapp.data.dynamic_data.ingredient;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface IngredientDao {

    @Insert
    ListenableFuture<Long> insertIngredient(Ingredient ingredient);

    @Query("SELECT * FROM NguyenLieu WHERE I_id_cong_thuc_nd = :id")
    LiveData<List<Ingredient>> getItemIngredient(int id);

    @Update
    ListenableFuture<Integer> updateIngredients(List<Ingredient> ingredients);
}
