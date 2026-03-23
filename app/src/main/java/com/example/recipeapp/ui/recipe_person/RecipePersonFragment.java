package com.example.recipeapp.ui.recipe_person;

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
import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;
import com.example.recipeapp.databinding.FragmentRecipePersonBinding;
import com.example.recipeapp.ui.adapter.RecipePersonAdapter;

public class RecipePersonFragment extends Fragment {

    private FragmentRecipePersonBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRecipePersonBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_recipe_person);
        ShowRecipeViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())).get(ShowRecipeViewModel.class);
        RecipePersonAdapter adapter = new RecipePersonAdapter(new RecipePersonAdapter.OnRecipePersonClickListener() {
            @Override
            public void onClick(RecipePerson recipePerson) {
                Bundle args = new Bundle();
                args.putInt("itemId", recipePerson.id);
                NavHostFragment.findNavController(RecipePersonFragment.this).navigate(R.id.recipeDetailPersonFragment, args);
            }

            @Override
            public void onEditClick(RecipePerson recipePerson) {
                Bundle args = new Bundle();
                args.putInt("itemId", recipePerson.id);
                NavHostFragment.findNavController(RecipePersonFragment.this).navigate(R.id.updateRecipeFragment, args);
            }

            @Override
            public void onDeleteClick(RecipePerson recipePerson) {
                new androidx.appcompat.app.AlertDialog.Builder(requireContext())
                        .setTitle("Xóa công thức")
                        .setMessage("Bạn có chắc chắn muốn xóa công thức này?")
                        .setPositiveButton("Xóa", (dialog, which) -> {
                            viewModel.deleteRecipe(recipePerson);
                            android.widget.Toast.makeText(requireContext(), "Xóa thành công", android.widget.Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("Hủy", null)
                        .show();
            }
        });
        binding.rvRecipePersons.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvRecipePersons.setAdapter(adapter);

        viewModel.getShowDataState().observe(getViewLifecycleOwner(), recipes -> {
            adapter.submitList(recipes);
            binding.tvEmptyState.setVisibility(recipes == null || recipes.isEmpty() ? View.VISIBLE : View.GONE);
        });
        viewModel.getCountRecipeState().observe(getViewLifecycleOwner(), value -> binding.tvRecipeCount.setText(getString(R.string.label_recipe_count) + ": " + value));
        viewModel.getCountFavourState().observe(getViewLifecycleOwner(), value -> binding.tvFavouriteCount.setText(getString(R.string.label_favourite_count) + ": " + value));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
