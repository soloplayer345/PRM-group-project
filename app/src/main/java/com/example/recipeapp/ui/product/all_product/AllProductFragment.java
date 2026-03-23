package com.example.recipeapp.ui.product.all_product;

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
import com.example.recipeapp.data.static_data.Products;
import com.example.recipeapp.databinding.FragmentAllProductBinding;
import com.example.recipeapp.ui.adapter.ProductAdapter;

public class AllProductFragment extends Fragment {

    private FragmentAllProductBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentAllProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_all_products);
        binding.toolbarLayout.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        binding.toolbarLayout.toolbar
                .setNavigationOnClickListener(v -> NavHostFragment.findNavController(this).navigateUp());
        ProductAdapter adapter = new ProductAdapter(ProductAdapter.TYPE_NEW, product -> {
            Bundle args = new Bundle();
            args.putInt("itemId", product.getId());
            NavHostFragment.findNavController(this).navigate(R.id.recipeDetailFragment, args);
        });
        binding.rvProducts.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvProducts.setAdapter(adapter);
        binding.rvProducts.setHasFixedSize(true);
        adapter.submitList(Products.getInstance().getProductList());
        binding.tvEmptyState.setVisibility(adapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
