package com.example.pmaminiprojekt.ui.slideshow;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.pmaminiprojekt.R;

public class CustomizeFragment extends Fragment {

    SeekBar seekBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customize, container, false);



    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        seekBar = (SeekBar) getActivity().findViewById(R.id.seekBar);

    }

}