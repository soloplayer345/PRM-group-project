package com.example.recipeapp.ui.recipe_person.update_recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.recipeapp.R;
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;
import com.example.recipeapp.databinding.FragmentUpdateRecipeBinding;
import com.example.recipeapp.ui.ViewModelFactoryUtil;
import com.example.recipeapp.ui.recipe_person.add_recipe.AddRecipeViewModel;

public class UpdateRecipeFragment extends Fragment {

    private FragmentUpdateRecipeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUpdateRecipeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_update_recipe);
        binding.toolbarLayout.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(this).navigateUp());
        UpdateRecipeViewModel viewModel = new ViewModelProvider(this,
                ViewModelFactoryUtil.savedStateFactory(this, getArguments(), UpdateRecipeViewModel::new)
        ).get(UpdateRecipeViewModel.class);

        viewModel.getRecipePerson().observe(getViewLifecycleOwner(), recipe -> {
            if (recipe != null) {
                binding.etRecipeName.setText(recipe.nameRecipe);
                binding.etRecipeTime.setText(recipe.time);
                binding.etRecipeSteps.setText(recipe.step);
            }
        });

        binding.btnSaveRecipe.setText(R.string.action_update);
        binding.btnSaveRecipe.setOnClickListener(v -> {
            RecipePerson current = viewModel.getRecipePerson().getValue();
            if (current != null) {
                viewModel.updateRecipe(new RecipePerson(
                        current.id,
                        String.valueOf(binding.etRecipeName.getText()),
                        String.valueOf(binding.etRecipeTime.getText()),
                        String.valueOf(binding.etRecipeSteps.getText())
                ));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
