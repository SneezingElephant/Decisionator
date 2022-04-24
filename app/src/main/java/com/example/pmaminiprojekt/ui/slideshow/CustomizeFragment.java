package com.example.pmaminiprojekt.ui.slideshow;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.pmaminiprojekt.R;

public class CustomizeFragment extends Fragment {

    String wheelInput1, wheelInput2, wheelInput3, wheelInput4, wheelInput5, wheelInput6;
    public int wheelSize;

    SeekBar seekBar;
    TextView seekBarNr;

    EditText input1;
    EditText input2;
    EditText input3;
    EditText input4;
    EditText input5;
    EditText input6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customize, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.createWheelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomizeFragmentDirections.ActionCustomizeFragmentToNavSlideshow action = CustomizeFragmentDirections.actionCustomizeFragmentToNavSlideshow();
                action.setCustomPresetSizeArg(wheelSize);
                NavHostFragment.findNavController(CustomizeFragment.this).navigate(action);
            }
        });

        seekBarNr = (TextView) getActivity().findViewById(R.id.textWheelSizeNr);
        seekBar = (SeekBar) getActivity().findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                wheelSize = i;
                seekBarNr.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        input1 = (EditText) getActivity().findViewById(R.id.editInput1);
        input2 = (EditText) getActivity().findViewById(R.id.editInput2);
        input3 = (EditText) getActivity().findViewById(R.id.editInput3);
        input4 = (EditText) getActivity().findViewById(R.id.editInput4);
        input5 = (EditText) getActivity().findViewById(R.id.editInput5);
        input6 = (EditText) getActivity().findViewById(R.id.editInput6);

    }

}