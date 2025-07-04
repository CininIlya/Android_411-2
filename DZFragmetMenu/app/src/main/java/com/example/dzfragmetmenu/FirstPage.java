package com.example.dzfragmetmenu;

import static com.example.dzfragmetmenu.R.array.colors;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.dzfragmetmenu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class FirstPage extends Fragment {

    RatingBar ratingBar;
    Button ratingButton;
    Spinner spinnerColors;
    Button buttonFindDescrition;
    TextView textViewDescrition;

    SeekBar seekBar;
    TextView textView;

    SeekBar seekBarDiscrete;
    TextView textSize;

    ImageView imageView;

    FloatingActionButton fab;


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_page,
                container, false);

        ratingBar = view.findViewById(R.id.ratingBar);
        ratingButton = view.findViewById(R.id.rating_btn);
        fab  = view.findViewById(R.id.fab);

        ratingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
// расчет райтинга с десятичной дробью через float на графику звездочек
                float value = ratingBar.getRating();
                Toast.makeText(getContext(), "Rating: " + value, Toast.LENGTH_SHORT).show();
            }
        });


        spinnerColors = view.findViewById(R.id.spinner_list);
        buttonFindDescrition = view.findViewById(R.id.button_find_description);
        textViewDescrition = view.findViewById(R.id.textView_description);
        imageView = (ImageView) view.findViewById(R.id.imageHonda);

        buttonFindDescrition.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinnerColors.getSelectedItemPosition();// вызов цветов из массива при выборе спиненпра

                String descrition = getDesriptionPosition(position);//переменная в которую ложим значения позиции элемента массивыа
                textViewDescrition.setText(descrition);


                String colors = getColors(position);
                buttonFindDescrition.setBackgroundColor(Color.parseColor(colors));

                Integer Avto = (position);
                imageView.getDrawable();
            }
        });
        seekBar = view.findViewById(R.id.seekBar);
        textView = view.findViewById(R.id.textView);
        //Общии метод включает в себя линию прогресс бара касание на линию и конец
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(progress + "/100"); // изменяем  значение первого нуля в лини  прогресса
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {// что происходит в началии линии прогресса
                Toast.makeText(getContext(), "Min", Toast.LENGTH_SHORT).show();
                textView.setTextColor(Color.parseColor("red"));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {// что про происходить при до нажатии до конца
                Toast.makeText(getContext(), "Max", Toast.LENGTH_SHORT).show();
                textView.setTextColor(Color.parseColor("green"));
            }
        });

        seekBarDiscrete = view.findViewById(R.id.seekBar2);
        textSize = view.findViewById(R.id.textSize);

        seekBarDiscrete.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSize.setTextSize(progress * 3); // нижнии прогресс бар увеличиваем в размере текст ниже
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomDialog();
            }
        });

        return view;
    }
    private void showBottomDialog() { // Окошко при нажатии на плюс

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_layout);

        // получение доступа к созданным страницам

        TextView second = dialog.findViewById(R.id.second);
        TextView third = dialog.findViewById(R.id.third);
        TextView fourth = dialog.findViewById(R.id.fourth);


        second.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                replaceFragment (new SecondPage());
            }
        });

        third.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                replaceFragment (new ThirdPage());
            }
        });

        fourth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                replaceFragment (new FouthPage());
            }
        });

        dialog.show();

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, // программно устанавливаем ширину и высоту меню окна при нажатии на плюсик
                ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// прозрачный фон по низон окна
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;//
        dialog.getWindow().setGravity(Gravity.BOTTOM);


    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment); // Переход на вторую страницу
        fragmentTransaction.commit();

    }
    //  мЕТОД ВОЗРАЩАКТ СТРОКОРВОЕ ЗНАЧЕНИЕ ПРИНИМАЕТ ЧИСЛОВОЕ ЗНАЧЕНИЕ
    private String getDesriptionPosition(int position) {
        String[] description = getResources().getStringArray(R.array.descriptiob_of_temp);
        return description[position];

    }

    private String getColors(int position) {
        String[] descrition = getResources().getStringArray(R.array.colors_button);
        return descrition[position];

    }

    private Integer getAvto(int position) {
        int[] descrition = getResources().getIntArray(R.array.foto);
        return descrition[position];


//    Resources res = getResources();
//    TypedArray icons = res.obtainTypedArray(R.array.foto);
//    Drawable drawable = icons.getDrawable(0);
//
//    TypedArray colors = res.obtainTypedArray(R.array.colors);
//    int color = colors.getColor(0,0);


    }
}
