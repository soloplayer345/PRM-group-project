package com.example.recipeapp.data.dynamic_data.favourite;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public class OfflineFavouriteRepository implements FavouriteRepository {

    private final FavouriteDao favouriteDao;

    public OfflineFavouriteRepository(FavouriteDao favouriteDao) {
        this.favouriteDao = favouriteDao;
    }

    @Override
    public ListenableFuture<Long> insertFavourite(Favourite favourite) {
        return favouriteDao.insertFavourite(favourite);
    }

    @Override
    public ListenableFuture<Integer> deleteFavourite(Favourite favourite) {
        return favouriteDao.deleteFavourite(favourite);
    }

    @Override
    public ListenableFuture<Integer> checkFavourite(int idProduct) {
        return favouriteDao.checkFavourite(idProduct);
    }

    @Override
    public ListenableFuture<Integer> getIdFavourite(int idProduct) {
        return favouriteDao.getIdFavourite(idProduct);
    }

    @Override
    public LiveData<List<Favourite>> selectFavourite() {
        return favouriteDao.selectFavourite();
    }

    @Override
    public ListenableFuture<Integer> getCountFavourite() {
        return favouriteDao.getCountFavourite();
    }
}
