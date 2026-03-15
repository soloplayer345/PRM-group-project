package com.example.recipeapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.data.dynamic_data.recipe_person.RecipePerson;
import com.example.recipeapp.databinding.ItemRecipePersonBinding;

import java.util.ArrayList;
import java.util.List;

public class RecipePersonAdapter extends RecyclerView.Adapter<RecipePersonAdapter.RecipePersonViewHolder> {

    public interface OnRecipePersonClickListener {
        void onClick(RecipePerson recipePerson);
    }

    private final List<RecipePerson> items = new ArrayList<>();
    private final OnRecipePersonClickListener listener;

    public RecipePersonAdapter(OnRecipePersonClickListener listener) {
        this.listener = listener;
    }

    public void submitList(List<RecipePerson> recipes) {
        items.clear();
        if (recipes != null) {
            items.addAll(recipes);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipePersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipePersonViewHolder(ItemRecipePersonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipePersonViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class RecipePersonViewHolder extends RecyclerView.ViewHolder {
        private final ItemRecipePersonBinding binding;

        RecipePersonViewHolder(ItemRecipePersonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(RecipePerson recipePerson) {
            binding.tvRecipeName.setText(recipePerson.nameRecipe);
            binding.tvRecipeTime.setText(recipePerson.time);
            binding.getRoot().setOnClickListener(v -> listener.onClick(recipePerson));
        }
    }
}
