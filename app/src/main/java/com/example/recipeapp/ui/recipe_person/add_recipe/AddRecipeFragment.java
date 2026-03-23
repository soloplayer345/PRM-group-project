package com.example.recipeapp.ui.recipe_person.add_recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recipeapp.R;
import com.example.recipeapp.databinding.FragmentAddRecipeBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

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
        AddedIngredientAdapter ingredientAdapter = new AddedIngredientAdapter();

        binding.rvAddedIngredients.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvAddedIngredients.setAdapter(ingredientAdapter);
        viewModel.getIngredients().observe(getViewLifecycleOwner(), ingredientAdapter::submitList);

        ingredientAdapter.setOnIngredientActionListener(new AddedIngredientAdapter.OnIngredientActionListener() {
            @Override
            public void onEdit(int position, AddRecipeViewModel.UINguyenLieu ingredient) {
                showAddIngredientDialog(viewModel, position, ingredient.nameIngre, ingredient.weightIngre);
            }

            @Override
            public void onDelete(int position, AddRecipeViewModel.UINguyenLieu ingredient) {
                showDeleteIngredientDialog(viewModel, position);
            }
        });

        binding.btnAddIngredient.setOnClickListener(v -> showAddIngredientDialog(viewModel, null, "", ""));
        binding.btnSaveRecipe.setOnClickListener(v -> {
            AddRecipeViewModel.UiStateRecipe state = new AddRecipeViewModel.UiStateRecipe();
            state.nameRecipe = String.valueOf(binding.etRecipeName.getText());
            state.time = String.valueOf(binding.etRecipeTime.getText());
            state.step = String.valueOf(binding.etRecipeSteps.getText());
            viewModel.updateUiState(state);
            viewModel.addRecipe();
            Toast.makeText(requireContext(), R.string.message_recipe_added, Toast.LENGTH_SHORT).show();
        });
    }

    private void showAddIngredientDialog(AddRecipeViewModel viewModel, Integer editPosition, String initialName, String initialWeight) {
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_ingredient, null, false);
        EditText etIngredientName = dialogView.findViewById(R.id.etIngredientName);
        EditText etIngredientWeight = dialogView.findViewById(R.id.etIngredientWeight);
        etIngredientName.setText(initialName);
        etIngredientWeight.setText(initialWeight);

        final boolean isEdit = editPosition != null;

        AlertDialog dialog = new MaterialAlertDialogBuilder(requireContext())
                .setTitle(isEdit ? R.string.title_edit_ingredient : R.string.title_add_ingredient)
                .setView(dialogView)
            .setNegativeButton(R.string.action_cancel, (dialogInterface, which) -> dialogInterface.dismiss())
                .setPositiveButton(R.string.action_confirm, null)
                .create();

        dialog.setOnShowListener(dialogInterface -> dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
                    String name = String.valueOf(etIngredientName.getText()).trim();
                    String weight = String.valueOf(etIngredientWeight.getText()).trim();

                    if (name.isEmpty()) {
                        Toast.makeText(requireContext(), R.string.message_fill_ingredient_name, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (weight.isEmpty()) {
                        Toast.makeText(requireContext(), R.string.message_fill_ingredient_weight, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (isEdit) {
                        viewModel.updateIngredient(editPosition, name, weight);
                        Toast.makeText(requireContext(), R.string.message_ingredient_updated, Toast.LENGTH_SHORT).show();
                    } else {
                        viewModel.addIngredient(name, weight);
                    }
                    dialog.dismiss();
                }));

        dialog.show();
    }

    private void showDeleteIngredientDialog(AddRecipeViewModel viewModel, int position) {
        new MaterialAlertDialogBuilder(requireContext())
                .setMessage(R.string.message_confirm_delete_ingredient)
                .setNegativeButton(R.string.action_cancel, (dialogInterface, which) -> dialogInterface.dismiss())
                .setPositiveButton(R.string.action_delete, (dialogInterface, which) -> {
                    viewModel.removeIngredient(position);
                    Toast.makeText(requireContext(), R.string.message_ingredient_deleted, Toast.LENGTH_SHORT).show();
                })
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
