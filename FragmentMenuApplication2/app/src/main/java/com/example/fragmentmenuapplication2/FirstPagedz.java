package com.example.fragmentmenuapplication2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class FirstPage extends Fragment {

    RatingBar ratingBar;
    Button ratingButton;
    Spinner spinnerColors;
    Button buttonFindDescrition;
    TextView textViewDescrition;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_page, container, false);

        ratingBar = view.findViewById(R.id.ratingBar);
        ratingButton = view.findViewById(R.id.ratin_btn);

        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// расчет райтинга с десятичной дробью через float на графику звездочек
                float value = ratingBar.getRating();
                Toast.makeText(getContext(), "Rating: " + value, Toast.LENGTH_SHORT).show();
            }
        });


        //длступ к слудующим элеметав питнер и текстовое поле
        spinnerColors = view.findViewById(R.id.spinner_list);
        View viewById = buttonFindDescrition.findViewById(R.id.button_find_description);
        textViewDescrition = view.findViewById(R.id.textView_description);

        buttonFindDescrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinnerColors.getSelectedItemPosition();// вызов цветов из массива при выборе спиненпра

                String descrition  = getDesriptionPosition(position);//переменная в которую ложим значения позиции элемента массивыа
                textViewDescrition.setText(descrition);

                String colors= getColors(position);
                buttonFindDescrition.setBackgroundColor(Color.parseColor(colors));
            }
        });
        return view;
    }

    //  мЕТОД ВОЗРАЩАКТ СТРОКОРВОЕ ЗНАЧЕНИЕ ПРИНИМАЕТ ЧИСЛОВОЕ ЗНАЧЕНИЕ
    private String getDesriptionPosition(int position) {
        String[] description = getResources().getStringArray(R.array.descriptiob_of_temp);
        return description[position];

    }
    private String getColors (int position){
        String [] descrition = getResources().getStringArray(R.array.colors_button);
        return descrition[position];

    }
}