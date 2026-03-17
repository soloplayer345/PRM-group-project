package com.example.recipeapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.data.dynamic_data.schedule.Schedule;
import com.example.recipeapp.data.static_data.Products;
import com.example.recipeapp.databinding.ItemScheduleBinding;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private final List<Schedule> items = new ArrayList<>();
    private final Products products = Products.getInstance();

    public void submitList(List<Schedule> schedules) {
        items.clear();
        if (schedules != null) {
            items.addAll(schedules);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ScheduleViewHolder(ItemScheduleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ScheduleViewHolder extends RecyclerView.ViewHolder {
        private final ItemScheduleBinding binding;

        ScheduleViewHolder(ItemScheduleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Schedule schedule) {
            binding.tvScheduleMeal.setText(schedule.position);
            binding.tvScheduleRecipe.setText(products.getNameProduct(schedule.idProduct));
            binding.tvScheduleNote.setText(schedule.description);
        }
    }
}
