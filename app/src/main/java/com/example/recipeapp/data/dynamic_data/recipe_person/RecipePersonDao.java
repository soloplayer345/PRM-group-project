package com.example.recipeapp.data.dynamic_data.recipe_person;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface RecipePersonDao {

    @Insert
    ListenableFuture<Long> insertRecipePerson(RecipePerson recipePerson);

    @Query("SELECT * FROM CongThucNguoiDung ORDER BY I_id_cong_thuc_nd DESC")
    LiveData<List<RecipePerson>> getAll();

    @Delete
    ListenableFuture<Integer> deleteRecipePerson(RecipePerson recipePerson);

    @Query("SELECT * FROM CongThucNguoiDung WHERE I_id_cong_thuc_nd = :id")
    LiveData<RecipePerson> getItemRecipeStream(int id);

    @Query("SELECT * FROM CongThucNguoiDung WHERE I_id_cong_thuc_nd = :id")
    LiveData<RecipePerson> getRecipeDetail(int id);

    @Update
    ListenableFuture<Integer> updateRecipePerson(RecipePerson recipePerson);

    @Query("SELECT I_id_cong_thuc_nd FROM CongThucNguoiDung ORDER BY I_id_cong_thuc_nd DESC LIMIT 1")
    ListenableFuture<Integer> getLastInsertId();

    @Query("SELECT COUNT(*) AS SoLuongDong FROM CongThucNguoiDung")
    ListenableFuture<Integer> getCount();
}
