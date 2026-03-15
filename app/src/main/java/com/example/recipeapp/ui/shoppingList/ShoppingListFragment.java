package com.example.recipeapp.ui.shoppingList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recipeapp.R;
import com.example.recipeapp.data.dynamic_data.shopping.Shopping;
import com.example.recipeapp.databinding.FragmentShoppingListBinding;
import com.example.recipeapp.ui.adapter.ShoppingAdapter;
import com.example.recipeapp.ui.adapter.StaticIngredientAdapter;

import java.util.List;

public class ShoppingListFragment extends Fragment {

    private FragmentShoppingListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentShoppingListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_shopping_list);
        binding.toolbarLayout.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        binding.toolbarLayout.toolbar.setNavigationOnClickListener(v -> androidx.navigation.fragment.NavHostFragment.findNavController(this).navigateUp());
        ShoppingListViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())).get(ShoppingListViewModel.class);

        ShoppingAdapter shoppingAdapter = new ShoppingAdapter(new ShoppingAdapter.OnShoppingCheckedListener() {
            @Override
            public void onChecked(com.example.recipeapp.data.dynamic_data.shopping.Shopping shopping, boolean checked) {
                if (checked) {
                    viewModel.addListSelect(shopping.idProduct);
                } else {
                    viewModel.deleteListSelect(shopping.idProduct);
                }
            }

            @Override
            public void onDelete(com.example.recipeapp.data.dynamic_data.shopping.Shopping shopping) {
                viewModel.deleteShoppingList(shopping.idProduct);
            }
        });
        binding.rvShopping.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvShopping.setAdapter(shoppingAdapter);

        StaticIngredientAdapter ingredientAdapter = new StaticIngredientAdapter();
        binding.rvShoppingIngredients.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvShoppingIngredients.setAdapter(ingredientAdapter);

        viewModel.getShoppingList().observe(getViewLifecycleOwner(), shoppings -> {
            shoppingAdapter.submitList(shoppings);
            boolean empty = shoppings == null || shoppings.isEmpty();
            binding.tvEmptyState.setVisibility(empty ? View.VISIBLE : View.GONE);
        });
        viewModel.getIngredientList().observe(getViewLifecycleOwner(), ingredientAdapter::submitList);
        binding.btnCompleteShopping.setOnClickListener(v -> viewModel.completeShopping());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
