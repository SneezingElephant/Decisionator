package com.example.pmaminiprojekt.ui.gallery;

import android.animation.ValueAnimator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pmaminiprojekt.R;
import com.example.pmaminiprojekt.databinding.FragmentGalleryBinding;

import java.util.Random;
import android.view.animation.Animation;

import android.view.animation.Transformation;
import android.graphics.Camera;
import android.graphics.Matrix;


public class GalleryFragment extends Fragment {

    private SensorManager sm;

    private float acelVal;
    private float acelLast;
    private float shake;

    private static final Random RANDOM = new Random();
    private ImageView coin;
    private Random randomSide;

    private FragmentGalleryBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Shake to spin
        sm = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        coin = getView().findViewById(R.id.coiniestCoin);
        binding.flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            flipCoin();
            }
        });
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            acelLast = acelVal;
            acelVal = (float) Math.sqrt(x*x + y*y + z*z);
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 12) {
                flipCoin();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    private void flipCoin(){


        //This makes the coin rotate very very fast, yes yes
        Animation rotateLeft = new RotateAnimation(4320, 0, 328, 322);
        rotateLeft.setInterpolator(new AccelerateInterpolator());
        rotateLeft.setDuration(1000);
        rotateLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


                Animation rotateRight = new RotateAnimation(0, 0);
                rotateRight.setInterpolator(new DecelerateInterpolator());
                rotateRight.setDuration(3000);
                rotateRight.setFillAfter(true);
                randomSide = new Random();

            }

            @Override
            public void onAnimationEnd(Animation animation) {
               int side = randomSide.nextInt(2);
               if (side == 1)
               {
               coin.setImageResource(R.drawable.coin_heads);
               }
               else
               {
                   coin.setImageResource(R.drawable.coin_tails);
               }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }


        });
        coin.startAnimation(rotateLeft);


    }








    @Override
    public void onPause() {
        super.onPause();
        sm.unregisterListener(sensorListener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;




    }

}