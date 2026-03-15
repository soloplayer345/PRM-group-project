package com.example.recipeapp.data.dynamic_data.favourite;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface FavouriteDao {

    @Insert
    ListenableFuture<Long> insertFavourite(Favourite favourite);

    @Delete
    ListenableFuture<Integer> deleteFavourite(Favourite favourite);

    @Query("SELECT COUNT(*) FROM yeuthich WHERE I_id_san_pham = :idProduct")
    ListenableFuture<Integer> checkFavourite(int idProduct);

    @Query("SELECT I_id_yeu_thich FROM yeuthich WHERE I_id_san_pham = :idProduct")
    ListenableFuture<Integer> getIdFavourite(int idProduct);

    @Query("SELECT * FROM yeuthich ORDER BY I_id_yeu_thich DESC")
    LiveData<List<Favourite>> selectFavourite();

    @Query("SELECT COUNT(*) AS SoLuong FROM yeuthich")
    ListenableFuture<Integer> getCountFavourite();
}
