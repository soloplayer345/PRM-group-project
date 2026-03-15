package com.example.recipeapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipeapp.data.static_data.Product;
import com.example.recipeapp.databinding.ItemProductRandomBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    public interface OnProductClickListener {
        void onProductClick(Product product);
    }

    private final List<Product> items = new ArrayList<>();
    private final OnProductClickListener listener;

    public ProductAdapter(OnProductClickListener listener) {
        this.listener = listener;
    }

    public void submitList(List<Product> products) {
        items.clear();
        if (products != null) {
            items.addAll(products);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductRandomBinding binding = ItemProductRandomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductRandomBinding binding;

        ProductViewHolder(ItemProductRandomBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Product product) {
            binding.tvProductName.setText(product.getName());
            binding.tvProductTime.setText(product.getTimeComplete() + " phut");
            Glide.with(binding.ivProductImage.getContext()).load(product.getImage()).into(binding.ivProductImage);
            binding.getRoot().setOnClickListener(v -> listener.onProductClick(product));
        }
    }
}
