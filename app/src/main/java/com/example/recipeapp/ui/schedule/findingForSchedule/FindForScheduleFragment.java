package com.example.recipeapp.ui.schedule.findingForSchedule;

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
import com.example.recipeapp.databinding.FragmentFindForScheduleBinding;
import com.example.recipeapp.ui.adapter.ProductAdapter;

public class FindForScheduleFragment extends Fragment {

    private FragmentFindForScheduleBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentFindForScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.toolbarLayout.toolbar.setTitle(R.string.title_find_schedule);
        binding.toolbarLayout.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        binding.toolbarLayout.toolbar
                .setNavigationOnClickListener(v -> NavHostFragment.findNavController(this).navigateUp());
        FindForScheduleViewModel viewModel = new ViewModelProvider(this).get(FindForScheduleViewModel.class);
        ProductAdapter adapter = new ProductAdapter(ProductAdapter.TYPE_NEW, product -> {
            getParentFragmentManager().setFragmentResult("schedule_pick",
                    createResultBundle(product.getId(), product.getName()));
            NavHostFragment.findNavController(this).popBackStack();
        });
        binding.rvFindScheduleProducts.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvFindScheduleProducts.setAdapter(adapter);
        binding.etSearchSchedule.setOnEditorActionListener((v, actionId, event) -> {
            adapter.submitList(viewModel.getListProduct(String.valueOf(v.getText())));
            binding.tvEmptyState.setVisibility(adapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
            return true;
        });
        adapter.submitList(viewModel.getListProduct(""));
        binding.tvEmptyState.setVisibility(adapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
    }

    private Bundle createResultBundle(int productId, String productName) {
        Bundle bundle = new Bundle();
        bundle.putInt("itemId", productId);
        bundle.putString("productName", productName);
        return bundle;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
