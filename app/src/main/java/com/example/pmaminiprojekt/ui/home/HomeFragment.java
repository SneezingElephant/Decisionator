package com.example.pmaminiprojekt.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pmaminiprojekt.R;
import com.example.pmaminiprojekt.databinding.FragmentHomeBinding;
import com.example.pmaminiprojekt.ui.slideshow.SlideshowFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    binding.CoinFlipButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openGalleryFragment();
        }
    });

    binding.WheelSpinButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openSlideshowFragment();
        }
    });
    }

    public void openGalleryFragment() {
        NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_nav_home_to_nav_gallery);
    }

    public void openSlideshowFragment() {
        NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_nav_home_to_nav_slideshow);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}