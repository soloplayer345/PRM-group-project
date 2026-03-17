package com.example.recipeapp.ui.home;

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
import com.example.recipeapp.data.static_data.Categories;
import com.example.recipeapp.data.static_data.Products;
import com.example.recipeapp.databinding.FragmentHomeBinding;
import com.example.recipeapp.ui.adapter.CategoryAdapter;
import com.example.recipeapp.ui.adapter.ProductAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_home);

        Products products = Products.getInstance();

        CategoryAdapter categoryAdapter = new CategoryAdapter(category -> {
            Bundle args = new Bundle();
            args.putInt("cateId", category.getId());
            NavHostFragment.findNavController(this).navigate(R.id.categoryProductFragment, args);
        });
        binding.rvCategories.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvCategories.setAdapter(categoryAdapter);
        binding.rvCategories.setHasFixedSize(true);
        categoryAdapter.submitList(Categories.getInstance().getCategoryList());

        ProductAdapter randomAdapter = new ProductAdapter(product -> openDetail(product.getId()));
        binding.rvRandomProducts.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvRandomProducts.setAdapter(randomAdapter);
        binding.rvRandomProducts.setHasFixedSize(true);
        randomAdapter.submitList(products.getRandomProducts());

        ProductAdapter newAdapter = new ProductAdapter(product -> openDetail(product.getId()));
        binding.rvNewProducts.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvNewProducts.setAdapter(newAdapter);
        binding.rvNewProducts.setHasFixedSize(true);
        newAdapter.submitList(products.getLastFiveProducts());

        binding.etSearch.setOnEditorActionListener((v, actionId, event) -> {
            Bundle args = new Bundle();
            args.putString("proname", String.valueOf(v.getText()));
            NavHostFragment.findNavController(this).navigate(R.id.findNameProductFragment, args);
            return true;
        });
    }

    private void openDetail(int productId) {
        Bundle args = new Bundle();
        args.putInt("itemId", productId);
        NavHostFragment.findNavController(this).navigate(R.id.recipeDetailFragment, args);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
