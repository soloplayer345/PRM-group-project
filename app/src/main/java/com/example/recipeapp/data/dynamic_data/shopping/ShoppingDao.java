package com.example.recipeapp.data.dynamic_data.shopping;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface ShoppingDao {

    @Insert
    ListenableFuture<Long> insertShopping(Shopping shopping);

    @Delete
    ListenableFuture<Integer> deleteShopping(Shopping shopping);

    @Query("SELECT I_id_mua_sam FROM muasam WHERE I_id_san_pham = :idProduct")
    ListenableFuture<Integer> getIdShopping(int idProduct);

    @Query("SELECT * FROM muasam ORDER BY I_id_mua_sam DESC")
    LiveData<List<Shopping>> selectShopping();
}
