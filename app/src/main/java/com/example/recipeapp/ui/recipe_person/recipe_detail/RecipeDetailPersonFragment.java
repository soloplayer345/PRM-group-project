package com.example.recipeapp.ui.recipe_person.recipe_detail;

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
import com.example.recipeapp.data.dynamic_data.ingredient.Ingredient;
import com.example.recipeapp.data.static_data.StaticIngredient;
import com.example.recipeapp.databinding.FragmentRecipeDetailPersonBinding;
import com.example.recipeapp.ui.ViewModelFactoryUtil;
import com.example.recipeapp.ui.adapter.StaticIngredientAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetailPersonFragment extends Fragment {

    private FragmentRecipeDetailPersonBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRecipeDetailPersonBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_recipe_detail_person);
        binding.toolbarLayout.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(this).navigateUp());
        RecipeDetailPerViewModel viewModel = new ViewModelProvider(this,
                ViewModelFactoryUtil.savedStateFactory(this, getArguments(), RecipeDetailPerViewModel::new)
        ).get(RecipeDetailPerViewModel.class);

        StaticIngredientAdapter adapter = new StaticIngredientAdapter();
        binding.rvRecipePersonIngredients.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvRecipePersonIngredients.setAdapter(adapter);

        viewModel.getRecipePerson().observe(getViewLifecycleOwner(), recipe -> {
            if (recipe != null) {
                binding.tvRecipePersonName.setText(recipe.nameRecipe);
                binding.tvRecipePersonTime.setText(recipe.time);
                binding.tvRecipePersonSteps.setText(recipe.step);
            }
        });
        viewModel.getIngredient().observe(getViewLifecycleOwner(), ingredients -> {
            List<StaticIngredient> mapped = new ArrayList<>();
            if (ingredients != null) {
                for (Ingredient ingredient : ingredients) {
                    mapped.add(new StaticIngredient(ingredient.id, ingredient.nameIngre, 0, ingredient.weightIngre));
                }
            }
            adapter.submitList(mapped);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
