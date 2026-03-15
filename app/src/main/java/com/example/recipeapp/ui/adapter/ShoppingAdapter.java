package com.example.recipeapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.data.dynamic_data.shopping.Shopping;
import com.example.recipeapp.data.static_data.Products;
import com.example.recipeapp.databinding.ItemShoppingBinding;

import java.util.ArrayList;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {

    public interface OnShoppingCheckedListener {
        void onChecked(Shopping shopping, boolean checked);
        void onDelete(Shopping shopping);
    }

    private final List<Shopping> items = new ArrayList<>();
    private final OnShoppingCheckedListener listener;
    private final Products products = new Products();

    public ShoppingAdapter(OnShoppingCheckedListener listener) {
        this.listener = listener;
    }

    public void submitList(List<Shopping> shoppings) {
        items.clear();
        if (shoppings != null) {
            items.addAll(shoppings);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShoppingViewHolder(ItemShoppingBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ShoppingViewHolder extends RecyclerView.ViewHolder {
        private final ItemShoppingBinding binding;

        ShoppingViewHolder(ItemShoppingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Shopping shopping) {
            binding.tvShoppingName.setText(products.getNameProduct(shopping.idProduct));
            binding.cbShopping.setOnCheckedChangeListener(null);
            binding.cbShopping.setChecked(false);
            binding.cbShopping.setOnCheckedChangeListener((buttonView, isChecked) -> listener.onChecked(shopping, isChecked));
            binding.btnDeleteShopping.setOnClickListener(v -> listener.onDelete(shopping));
        }
    }
}
