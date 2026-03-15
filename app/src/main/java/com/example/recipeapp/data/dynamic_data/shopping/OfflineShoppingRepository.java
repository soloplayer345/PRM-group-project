package com.example.recipeapp.data.dynamic_data.shopping;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public class OfflineShoppingRepository implements ShoppingRepository {

    private final ShoppingDao shoppingDao;

    public OfflineShoppingRepository(ShoppingDao shoppingDao) {
        this.shoppingDao = shoppingDao;
    }

    @Override
    public ListenableFuture<Long> insertShopping(Shopping shopping) {
        return shoppingDao.insertShopping(shopping);
    }

    @Override
    public ListenableFuture<Integer> deleteShopping(Shopping shopping) {
        return shoppingDao.deleteShopping(shopping);
    }

    @Override
    public ListenableFuture<Integer> getIdShopping(int idProduct) {
        return shoppingDao.getIdShopping(idProduct);
    }

    @Override
    public LiveData<List<Shopping>> selectShopping() {
        return shoppingDao.selectShopping();
    }
}
