package com.example.elderlycaresystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Main_Page extends Fragment {
    LinearLayout basic_tp, bal_diet, yogaExer, i_prevent, diseases, profile;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_page, container, false);

        basic_tp = view.findViewById(R.id.basic_tips);
        bal_diet = view.findViewById(R.id.bal_diet);
        yogaExer = view.findViewById(R.id.yogaExer);
        i_prevent = view.findViewById(R.id.i_prevent);
        diseases = view.findViewById(R.id.diseases);
        profile = view.findViewById(R.id.profile);

        basic_tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Basic_Tips.class));
            }
        });

        bal_diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Balanced_Diet.class));
            }
        });

        yogaExer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Yoga_Exercise.class));
            }
        });

        i_prevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PreventInfection.class));
            }
        });

        diseases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Diseases.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Profile.class));
            }
        });

        return view;
    }
}
