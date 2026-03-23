package com.example.recipeapp.ui.favouriteRecipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recipeapp.R;
import com.example.recipeapp.data.dynamic_data.favourite.Favourite;
import com.example.recipeapp.data.static_data.Product;
import com.example.recipeapp.databinding.FragmentFavouriteBinding;
import com.example.recipeapp.ui.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRecipeFragment extends Fragment {

    private FragmentFavouriteBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_favourite);
        binding.toolbarLayout.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        binding.toolbarLayout.toolbar
                .setNavigationOnClickListener(v -> NavHostFragment.findNavController(this).navigateUp());
        FavouriteRecipeViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(FavouriteRecipeViewModel.class);
        ProductAdapter adapter = new ProductAdapter(ProductAdapter.TYPE_NEW, product -> {
            Bundle args = new Bundle();
            args.putInt("itemId", product.getId());
            NavHostFragment.findNavController(this).navigate(R.id.recipeDetailFragment, args);
        });
        binding.rvFavourites.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvFavourites.setAdapter(adapter);
        viewModel.getFavouriteList().observe(getViewLifecycleOwner(), favourites -> {
            List<Product> products = new ArrayList<>();
            if (favourites != null) {
                for (Favourite favourite : favourites) {
                    products.add(viewModel.getProduct(favourite.idProduct));
                }
            }
            adapter.submitList(products);
            binding.tvEmptyState.setVisibility(products.isEmpty() ? View.VISIBLE : View.GONE);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
