package com.example.recipeapp.ui.recipe_person.add_recipe;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recipeapp.R;
import com.google.android.material.button.MaterialButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AddedIngredientAdapter extends RecyclerView.Adapter<AddedIngredientAdapter.AddedIngredientViewHolder> {

    public interface OnIngredientActionListener {
        void onEdit(int position, AddRecipeViewModel.UINguyenLieu ingredient);

        void onDelete(int position, AddRecipeViewModel.UINguyenLieu ingredient);
    }

    private final List<AddRecipeViewModel.UINguyenLieu> items = new ArrayList<>();
    private OnIngredientActionListener actionListener;

    public void setOnIngredientActionListener(OnIngredientActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void submitList(List<AddRecipeViewModel.UINguyenLieu> ingredients) {
        items.clear();
        if (ingredients != null) {
            items.addAll(ingredients);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AddedIngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_added_ingredient, parent, false);
        return new AddedIngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddedIngredientViewHolder holder, int position) {
        AddRecipeViewModel.UINguyenLieu ingredient = items.get(position);
        holder.bind(ingredient);
        holder.btnEdit.setOnClickListener(v -> {
            int adapterPosition = holder.getBindingAdapterPosition();
            if (adapterPosition == RecyclerView.NO_POSITION) {
                return;
            }
            if (actionListener != null) {
                actionListener.onEdit(adapterPosition, ingredient);
            }
        });
        holder.btnDelete.setOnClickListener(v -> {
            int adapterPosition = holder.getBindingAdapterPosition();
            if (adapterPosition == RecyclerView.NO_POSITION) {
                return;
            }
            if (actionListener != null) {
                actionListener.onDelete(adapterPosition, ingredient);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class AddedIngredientViewHolder extends RecyclerView.ViewHolder {
        private final TextView textName;
        private final TextView textWeight;
        private final MaterialButton btnEdit;
        private final MaterialButton btnDelete;

        AddedIngredientViewHolder(@NonNull ViewGroup itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.tvIngredientName);
            textWeight = itemView.findViewById(R.id.tvIngredientWeight);
            btnEdit = itemView.findViewById(R.id.btnEditIngredient);
            btnDelete = itemView.findViewById(R.id.btnDeleteIngredient);
        }

        void bind(AddRecipeViewModel.UINguyenLieu ingredient) {
            textName.setText(ingredient.nameIngre);
            textWeight.setText(ingredient.weightIngre);
        }
    }
}
