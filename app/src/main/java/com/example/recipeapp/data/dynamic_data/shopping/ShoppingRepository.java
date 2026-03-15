package com.example.recipeapp.data.dynamic_data.shopping;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public interface ShoppingRepository {
    ListenableFuture<Long> insertShopping(Shopping shopping);
    ListenableFuture<Integer> deleteShopping(Shopping shopping);
    ListenableFuture<Integer> getIdShopping(int idProduct);
    LiveData<List<Shopping>> selectShopping();
}
