package com.example.recipeapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipeapp.R;
import com.example.recipeapp.data.static_data.Product;
import com.example.recipeapp.databinding.ItemProductNewBinding;
import com.example.recipeapp.databinding.ItemProductRandomBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_RANDOM = 0;
    public static final int TYPE_NEW = 1;

    public interface OnProductClickListener {
        void onProductClick(Product product);
    }

    private final List<Product> items = new ArrayList<>();
    private final OnProductClickListener listener;
    private final int viewType;

    public ProductAdapter(int viewType, OnProductClickListener listener) {
        this.viewType = viewType;
        this.listener = listener;
    }

    public void submitList(List<Product> products) {
        items.clear();
        if (products != null) {
            items.addAll(products);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_RANDOM) {
            ItemProductRandomBinding binding = ItemProductRandomBinding.inflate(inflater, parent, false);
            return new RandomViewHolder(binding);
        } else {
            ItemProductNewBinding binding = ItemProductNewBinding.inflate(inflater, parent, false);
            return new NewViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Product product = items.get(position);
        if (holder instanceof RandomViewHolder) {
            ((RandomViewHolder) holder).bind(product);
        } else if (holder instanceof NewViewHolder) {
            ((NewViewHolder) holder).bind(product);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class RandomViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductRandomBinding binding;

        RandomViewHolder(ItemProductRandomBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Product product) {
            binding.tvProductName.setText(product.getName());
            String timeText = product.getTimeComplete() + " " + binding.getRoot().getContext().getString(R.string.unit_minutes);
            binding.tvProductTime.setText(timeText);
            Glide.with(binding.ivProductImage.getContext())
                .load(product.getImage())
                .placeholder(android.R.drawable.progress_horizontal)
                .error(android.R.drawable.ic_menu_gallery)
                .into(binding.ivProductImage);
            binding.getRoot().setOnClickListener(v -> listener.onProductClick(product));
        }
    }

    class NewViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductNewBinding binding;

        NewViewHolder(ItemProductNewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Product product) {
            binding.tvProductName.setText(product.getName());
            String timeText = product.getTimeComplete() + " " + binding.getRoot().getContext().getString(R.string.unit_minutes);
            binding.tvProductTime.setText(timeText);
            Glide.with(binding.ivProductImage.getContext())
                    .load(product.getImage())
                    .placeholder(android.R.drawable.progress_horizontal)
                    .error(android.R.drawable.ic_menu_gallery)
                    .into(binding.ivProductImage);
            binding.getRoot().setOnClickListener(v -> listener.onProductClick(product));
            if (binding.btnViewNow != null) {
                binding.btnViewNow.setOnClickListener(v -> listener.onProductClick(product));
            }
        }
    }

    @Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
        if (holder instanceof RandomViewHolder) {
            Glide.with(((RandomViewHolder) holder).binding.ivProductImage.getContext())
                .clear(((RandomViewHolder) holder).binding.ivProductImage);
        } else if (holder instanceof NewViewHolder) {
            Glide.with(((NewViewHolder) holder).binding.ivProductImage.getContext())
                .clear(((NewViewHolder) holder).binding.ivProductImage);
        }
    }
}
