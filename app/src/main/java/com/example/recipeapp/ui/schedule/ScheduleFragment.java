package com.example.recipeapp.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recipeapp.R;
import com.example.recipeapp.databinding.FragmentScheduleBinding;
import com.example.recipeapp.ui.adapter.ScheduleAdapter;

import java.time.LocalDate;

public class ScheduleFragment extends Fragment {

    private FragmentScheduleBinding binding;
    private int selectedProductId = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_schedule);
        ScheduleViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())).get(ScheduleViewModel.class);

        ScheduleAdapter adapter = new ScheduleAdapter();
        binding.rvSchedule.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvSchedule.setAdapter(adapter);

        LocalDate today = LocalDate.now();
        binding.tvSelectedDate.setText(ScheduleDateUtils.changeMillisToDateString(ScheduleDateUtils.toMillis(today)));
        viewModel.getListSchedule(ScheduleDateUtils.toMillis(today)).observe(getViewLifecycleOwner(), schedules -> {
            adapter.submitList(schedules);
            binding.tvEmptyState.setVisibility(schedules == null || schedules.isEmpty() ? View.VISIBLE : View.GONE);
        });

        binding.btnPickRecipeForSchedule.setOnClickListener(v -> NavHostFragment.findNavController(this).navigate(R.id.findForScheduleFragment));
        binding.btnSaveSchedule.setOnClickListener(v -> {
            if (selectedProductId < 0) {
                Toast.makeText(requireContext(), R.string.message_select_recipe_first, Toast.LENGTH_SHORT).show();
                return;
            }
            viewModel.updateNote(String.valueOf(binding.etScheduleNote.getText()));
            viewModel.addSchedule(selectedProductId);
            Toast.makeText(requireContext(), R.string.message_schedule_saved, Toast.LENGTH_SHORT).show();
        });

        getParentFragmentManager().setFragmentResultListener("schedule_pick", getViewLifecycleOwner(), (requestKey, result) -> {
            selectedProductId = result.getInt("itemId", -1);
            String productName = result.getString("productName", getString(R.string.selected_recipe_placeholder));
            binding.tvSelectedRecipe.setText(productName);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
