package com.example.recipeapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.recipeapp.databinding.ActivityMainBinding;
import com.example.recipeapp.util.ThemePreference;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
        }

        setupThemeToggle();
    }

    private void setupThemeToggle() {
        boolean isDarkMode = ThemePreference.isDarkModeEnabled(this);
        updateThemeButtonState(isDarkMode);

        binding.buttonThemeToggle.setOnClickListener(v -> {
            boolean enableDarkMode = !ThemePreference.isDarkModeEnabled(this);
            ThemePreference.setDarkModeEnabled(this, enableDarkMode);
            updateThemeButtonState(enableDarkMode);
            AppCompatDelegate.setDefaultNightMode(
                    enableDarkMode
                            ? AppCompatDelegate.MODE_NIGHT_YES
                            : AppCompatDelegate.MODE_NIGHT_NO
            );
        });
    }

    private void updateThemeButtonState(boolean isDarkMode) {
        binding.buttonThemeToggle.setImageResource(
                isDarkMode ? R.drawable.ic_theme_light : R.drawable.ic_theme_dark
        );
        binding.buttonThemeToggle.setContentDescription(
                getString(isDarkMode ? R.string.action_switch_to_light : R.string.action_switch_to_dark)
        );
    }
}
