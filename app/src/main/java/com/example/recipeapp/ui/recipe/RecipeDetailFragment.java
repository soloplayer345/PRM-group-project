package com.example.recipeapp.ui.recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.recipeapp.R;
import com.example.recipeapp.data.static_data.Product;
import com.example.recipeapp.data.static_data.Products;
import com.example.recipeapp.data.static_data.Procedure;
import com.example.recipeapp.databinding.FragmentRecipeDetailBinding;
import com.example.recipeapp.ui.ViewModelFactoryUtil;
import com.example.recipeapp.ui.adapter.StaticIngredientAdapter;

public class RecipeDetailFragment extends Fragment {

    private FragmentRecipeDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_recipe_detail);
        binding.toolbarLayout.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(this).navigateUp());
        RecipeViewModel viewModel = new ViewModelProvider(this,
                ViewModelFactoryUtil.savedStateFactory(this, getArguments(), RecipeViewModel::new)
        ).get(RecipeViewModel.class);

        Product product = Products.getInstance().getProduct(viewModel.getProductId());
        if (product == null) {
            Toast.makeText(requireContext(), R.string.message_product_not_found, Toast.LENGTH_SHORT).show();
            NavHostFragment.findNavController(this).navigateUp();
            return;
        }
        binding.tvRecipeName.setText(product.getName());
        binding.tvRecipeTime.setText(product.getTimeComplete() + " phut");
        Glide.with(this).load(product.getImage()).into(binding.ivRecipeImage);

        StaticIngredientAdapter ingredientAdapter = new StaticIngredientAdapter();
        binding.rvIngredients.setAdapter(ingredientAdapter);
        ingredientAdapter.submitList(product.getIngredient());

        binding.layoutProcedureContainer.removeAllViews();
        for (Procedure procedure : product.getProcedure()) {
            TextView textView = new TextView(requireContext());
            textView.setText(procedure.getStep() + "\n" + procedure.getDes());
            textView.setPadding(0, 0, 0, 24);
            binding.layoutProcedureContainer.addView(textView);
        }

        viewModel.getCheckFavorite().observe(getViewLifecycleOwner(), count -> {
            boolean isFavourite = count != null && count > 0;
            binding.btnFavourite.setText(isFavourite ? R.string.action_remove_from_favourite : R.string.action_add_to_favourite);
        });
        viewModel.getFavouriteActionMessageRes().observe(getViewLifecycleOwner(), messageRes -> {
            if (messageRes != null && messageRes > 0) {
                Toast.makeText(requireContext(), messageRes, Toast.LENGTH_SHORT).show();
                viewModel.clearFavouriteActionMessage();
            }
        });

        binding.btnFavourite.setOnClickListener(v -> viewModel.toggleFavourite());
        binding.btnAddShopping.setOnClickListener(v -> viewModel.addShopping());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
