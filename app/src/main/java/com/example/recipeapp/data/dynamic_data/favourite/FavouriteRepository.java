package com.example.recipeapp.data.dynamic_data.favourite;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public interface FavouriteRepository {
    ListenableFuture<Long> insertFavourite(Favourite favourite);
    ListenableFuture<Integer> deleteFavourite(Favourite favourite);
    ListenableFuture<Integer> checkFavourite(int idProduct);
    ListenableFuture<Integer> getIdFavourite(int idProduct);
    LiveData<List<Favourite>> selectFavourite();
    ListenableFuture<Integer> getCountFavourite();
}
