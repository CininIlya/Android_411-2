package com.example.fragmdom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button firstFragmentBtn, secondFragmentBtn, threeFragmentBtn;
    Fragment1 firstFragment = new Fragment1();
//    TextView data;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragmentBtn = findViewById(R.id.fragment1Btn);
        secondFragmentBtn = findViewById(R.id.fragment2Btn);
        threeFragmentBtn = findViewById(R.id.fragment3Btn);
        replaceFragment(firstFragment);// сразу создается загрузка ввод фрагмента в фрагмент 1


        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(firstFragment);
            }
        });

        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 secoFragment = new Fragment2();
                replaceFragment(secoFragment);
            }

        });
        threeFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment3 threeFragment = new Fragment3();
                replaceFragment(threeFragment);
            }
        });
//data = findViewById(R.id.data);// в премекннуюэлемент из data доступ к текс полю
//        Intent intent =getIntent();
//        String getData = intent.getStringExtra("key");
//        data.setText(getData);// стороковое значение для получение из ключа

    }

    // метод заменяющии фрагмент приходящии в нешго
    private void replaceFragment(Fragment fragment) {
        // для удалении или замены фрагмента
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);//1 значение меняем на 2 значение
        fragmentTransaction.commit();// применение замененых значении из fragmen 1

    }
}