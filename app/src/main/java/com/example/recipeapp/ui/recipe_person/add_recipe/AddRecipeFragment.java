package com.example.recipeapp.ui.recipe_person.add_recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.recipeapp.R;
import com.example.recipeapp.databinding.FragmentAddRecipeBinding;

public class AddRecipeFragment extends Fragment {

    private FragmentAddRecipeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddRecipeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_add_recipe);
        binding.toolbarLayout.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(this).navigateUp());
        AddRecipeViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())).get(AddRecipeViewModel.class);

        binding.btnAddIngredient.setOnClickListener(v -> viewModel.addIngredient("Nguyen lieu moi", "100 g"));
        binding.btnSaveRecipe.setOnClickListener(v -> {
            AddRecipeViewModel.UiStateRecipe state = new AddRecipeViewModel.UiStateRecipe();
            state.nameRecipe = String.valueOf(binding.etRecipeName.getText());
            state.time = String.valueOf(binding.etRecipeTime.getText());
            state.step = String.valueOf(binding.etRecipeSteps.getText());
            viewModel.updateUiState(state);
            viewModel.addRecipe();
            Toast.makeText(requireContext(), R.string.action_add, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
