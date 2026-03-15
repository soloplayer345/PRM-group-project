package com.example.recipeapp.ui.product.category_product;

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
import com.example.recipeapp.databinding.FragmentCategoryProductBinding;
import com.example.recipeapp.ui.ViewModelFactoryUtil;
import com.example.recipeapp.ui.adapter.ProductAdapter;

public class CategoryProductFragment extends Fragment {

    private FragmentCategoryProductBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCategoryProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_category_products);
        binding.toolbarLayout.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(this).navigateUp());
        CateProViewModel viewModel = new ViewModelProvider(this,
                ViewModelFactoryUtil.savedStateFactory(this, getArguments(), (application, handle) -> new CateProViewModel(handle))
        ).get(CateProViewModel.class);

        ProductAdapter adapter = new ProductAdapter(product -> {
            Bundle args = new Bundle();
            args.putInt("itemId", product.getId());
            NavHostFragment.findNavController(this).navigate(R.id.recipeDetailFragment, args);
        });
        binding.rvCategoryProducts.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvCategoryProducts.setAdapter(adapter);
        adapter.submitList(new Products().getProductsByCategoryId(viewModel.getCateId()));
        binding.tvEmptyState.setVisibility(adapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
