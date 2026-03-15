package com.example.recipeapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipeapp.data.static_data.StaticIngredient;
import com.example.recipeapp.databinding.ItemIngredientBinding;

import java.util.ArrayList;
import java.util.List;

public class StaticIngredientAdapter extends RecyclerView.Adapter<StaticIngredientAdapter.IngredientViewHolder> {

    private final List<StaticIngredient> items = new ArrayList<>();

    public void submitList(List<StaticIngredient> ingredients) {
        items.clear();
        if (ingredients != null) {
            items.addAll(ingredients);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IngredientViewHolder(ItemIngredientBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class IngredientViewHolder extends RecyclerView.ViewHolder {
        private final ItemIngredientBinding binding;

        IngredientViewHolder(ItemIngredientBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(StaticIngredient ingredient) {
            binding.tvIngredientName.setText(ingredient.getName());
            binding.tvIngredientQuantity.setText(ingredient.getQuantity());
            Glide.with(binding.ivIngredientImage.getContext()).load(ingredient.getImage()).into(binding.ivIngredientImage);
        }
    }
}
