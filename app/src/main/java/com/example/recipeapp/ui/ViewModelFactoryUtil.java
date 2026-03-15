package com.example.recipeapp.ui;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;

public final class ViewModelFactoryUtil {

    public interface SavedStateViewModelCreator<T extends ViewModel> {
        T create(Application application, SavedStateHandle handle);
    }

    private ViewModelFactoryUtil() {
    }

    public static <T extends ViewModel> ViewModelProvider.Factory simpleFactory(Fragment fragment, SavedStateViewModelCreator<T> creator) {
        return savedStateFactory(fragment, fragment.getArguments(), creator);
    }

    public static <T extends ViewModel> ViewModelProvider.Factory savedStateFactory(
            Fragment fragment,
            Bundle defaultArgs,
            SavedStateViewModelCreator<T> creator
    ) {
        Application application = fragment.requireActivity().getApplication();
        SavedStateRegistryOwner owner = fragment;
        return new AbstractSavedStateViewModelFactory(owner, defaultArgs) {
            @NonNull
            @Override
            @SuppressWarnings("unchecked")
            protected <VM extends ViewModel> VM create(
                    @NonNull String key,
                    @NonNull Class<VM> modelClass,
                    @NonNull SavedStateHandle handle
            ) {
                return (VM) creator.create(application, handle);
            }
        };
    }
}
