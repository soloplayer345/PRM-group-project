package com.example.recipeapp.util;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

public final class FutureHelper {

    public interface Callback<T> {
        void onResult(@Nullable T result);
    }

    public interface ErrorCallback {
        void onError(Throwable throwable);
    }

    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    private FutureHelper() {
    }

    public static <T> void observe(ListenableFuture<T> future, Callback<T> callback) {
        observe(future, callback, null);
    }

    public static <T> void observe(ListenableFuture<T> future, Callback<T> callback, @Nullable ErrorCallback errorCallback) {
        Futures.addCallback(future, new FutureCallback<T>() {
            @Override
            public void onSuccess(@Nullable T result) {
                MAIN_HANDLER.post(() -> callback.onResult(result));
            }

            @Override
            public void onFailure(Throwable t) {
                if (errorCallback != null) {
                    MAIN_HANDLER.post(() -> errorCallback.onError(t));
                }
            }
        }, MoreExecutors.directExecutor());
    }
}
