package com.example.gamelannagakencana;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizFragment extends Fragment {
    TextView tvQuiz, tvResult;
    Button btnQ1, btnQ2, btnQ3, btnQ4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        tvQuiz = view.findViewById(R.id.textViewQuestion);
        tvResult = view.findViewById(R.id.textViewResult);
        btnQ1 = view.findViewById(R.id.buttonQn1);
        btnQ2 = view.findViewById(R.id.buttonQn2);
        btnQ3 = view.findViewById(R.id.buttonQn3);
        btnQ4 = view.findViewById(R.id.buttonQn4);

        tvQuiz.setText("Where does Gamelan originate? ");

        btnQ1.setText("Malaysia");
        btnQ2.setText("Singapore");
        btnQ3.setText("Thailand");
        btnQ4.setText("Indonesia");

        btnQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setTextColor(getResources().getColor(R.color.red));
                tvResult.setText("Try Again");

            }
        });

        btnQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setTextColor(getResources().getColor(R.color.red));
                tvResult.setText("Try Again");

            }
        });

        btnQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setTextColor(getResources().getColor(R.color.red));
                tvResult.setText("Try Again");

            }
        });

        btnQ4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setTextColor(getResources().getColor(R.color.green));
                tvResult.setText("Well Done");

            }
        });
    return view;
    }

}
