package com.example.pmaminiprojekt.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pmaminiprojekt.R;
import com.example.pmaminiprojekt.databinding.FragmentSlideshowBinding;

import java.util.Objects;
import java.util.Random;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    private static final String [] sectors ={"Burger", "Kebab", "Chinese", "Pizza"};
    private static final String [] activitys ={"Exercise", "Movie", "Clean Up", "Find Friends", "Video Games"};
    private static final String [] gifts ={"Flowers", "Chocolate", "Gift Card", "Book", "Clothes", "Game"};
    private static final int [] sectorDegrees = new int[sectors.length];
    private static final int [] activitysDegrees = new int[activitys.length];
    private static final int [] giftsDegrees = new int[gifts.length];
    private static final Random random = new Random();
    private int degree = 0;
    private boolean isSpinning = false;
    private boolean isTakeaway = true;
    private boolean isActivity = false;
    private boolean isGift = false;

    private ImageView wheel;
    private ImageView wheelActivitys;
    private ImageView wheelGifts;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        wheel = requireView().findViewById(R.id.wheel);
        wheelActivitys = (ImageView) getView().findViewById(R.id.wheelActivity);
        wheelGifts = (ImageView) getView().findViewById(R.id.wheelGifts);

        getDegreeForSectors();
        getDegreeForActivitys();
        getDegreeForGifts();

        binding.spinBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (!isSpinning)
                {
                    spin();
                    isSpinning = true;
                }
            }
        });

        binding.takeawayPreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSpinning && !isTakeaway) {
                    isTakeaway = true;
                    isActivity = false;
                    isGift = false;

                    wheel.setAlpha(1f);
                    wheelActivitys.setAlpha(0f);
                    wheelGifts.setAlpha(0f);

                }
            }
        });

        binding.activityPreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSpinning && !isActivity) {
                    isActivity = true;
                    isTakeaway = false;
                    isGift = false;

                    wheel.setAlpha(0f);
                    wheelActivitys.setVisibility(View.VISIBLE);
                    wheelActivitys.setAlpha(1f);
                    wheelGifts.setAlpha(0f);
                }
            }
        });

        binding.giftIdeasPreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSpinning && !isGift) {
                    isGift = true;
                    isActivity = false;
                    isTakeaway = false;

                    wheel.setAlpha(0f);
                    wheelActivitys.setAlpha(0f);
                    wheelGifts.setVisibility(View.VISIBLE);
                    wheelGifts.setAlpha(1f);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void spin()
    {
        if (isTakeaway) {
            degree = random.nextInt(sectors.length - 1);

            RotateAnimation rotateAnimation = new RotateAnimation(0, (360 * sectors.length) + sectorDegrees[degree],
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

            rotateAnimation.setDuration(3600);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new DecelerateInterpolator());
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    isSpinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            wheel.startAnimation(rotateAnimation);
        }
        else if (isActivity) {
            degree = random.nextInt(activitys.length-1);

            RotateAnimation rotateAnimation = new RotateAnimation(0,(360 * activitys.length) + activitysDegrees[degree],
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

            rotateAnimation.setDuration(3600);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new DecelerateInterpolator());
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation)
                {
                    isSpinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            wheelActivitys.startAnimation(rotateAnimation);
        }
        else if (isGift) {
            degree = random.nextInt(gifts.length-1);

            RotateAnimation rotateAnimation = new RotateAnimation(0,(360 * gifts.length) + giftsDegrees[degree],
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

            rotateAnimation.setDuration(3600);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new DecelerateInterpolator());
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation)
                {
                    isSpinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            wheelGifts.startAnimation(rotateAnimation);
        }

    }


    private void getDegreeForSectors()
    {
        int sectorDegree = 360/sectors.length;

        for (int i=0; i < sectors.length; i++)
        {
            sectorDegrees[i] = (i+1) * sectorDegree;
        }
    }

    private void getDegreeForActivitys()
    {
        int activityDegree = 360/activitys.length;

        for (int i=0; i < activitys.length; i++)
        {
            activitysDegrees[i] = (i+1) * activityDegree;
        }
    }

    private void getDegreeForGifts()
    {
        int giftDegree = 360/gifts.length;

        for (int i=0; i < gifts.length; i++)
        {
            giftsDegrees[i] = (i+1) * giftDegree;
        }
    }

}