package com.example.gamequizdz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;
import java.util.Random;

public class Level1dz extends AppCompatActivity {

    Dialog dialog;

    Dialog dialogEnd; // ДИАЛОГ ПОЯВЛЯЮЩИЙСЯ В КОНЦЕ ИГРЫ

    public int numleft; // переменная для левой картики + текст
    public int numRight; // переменная для правой картики + текст
    Array array = new Array();
    Random random = new Random();


    // создаем за пределами  метода онкреет

    public int count = 0; //счетчик правильный ответов

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.universal);

        // Устанавливаем  номер уровня
        TextView textLevels = findViewById(R.id.textView);
        textLevels.setText(R.string.level_1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);// строка состояния скрывается сама после вытягивания

        //получение доступа к перечисленным элементам
        final ImageView imgLeft = findViewById(R.id.img_left);
        final ImageView imgRight = findViewById(R.id.img_rigth);

        //скругление углов

        imgLeft.setClipToOutline(true);
        imgRight.setClipToOutline(true);

        final TextView textLeft = findViewById(R.id.textV_left); // путь к левой картинки
        final TextView textRight = findViewById(R.id.textV_right); // путь к левой картинк

        //вызов диалогово окно в начала игры

        dialog = new Dialog(this);// cjplftv lbfkjujt jtyj pltcm
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);// скрывает заголовок
        dialog.setContentView(R.layout.privioew_dialofdz);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialog.setCancelable(false);// не закрывать при кликам за пределами окна

        // кнопка назад
        TextView btnClose = dialog.findViewById(R.id.button_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level1dz.this, GameLevelsdz.class);
                startActivity(intent);
                dialog.dismiss();//закрытие диалогового окна

            }
        });

        // Кнопка продолжить
        Button btnContinue = dialog.findViewById(R.id.button_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); //звкрытие диалого окна
            }
        });

        dialog.show();//показать диалоговое окно

//------------------------------------------------------
        // Вызов диалогового окна в конце игры

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);// скрываем заголовок
        dialogEnd.setContentView(R.layout.dialof_end); // путь к диалоговому окну
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// фон прозрачный
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);// чтобы диалоговое окно расширялось на весь экран
        dialogEnd.setCancelable(false); // нельзя закрыть за пределами окна

        TextView btnClose2 = dialogEnd.findViewById(R.id.button_close);
        btnClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // вернемся к выбору уровня
                Intent intent = new Intent(Level1dz.this, GameLevelsdz.class);
                startActivity(intent);
                dialogEnd.dismiss();

            }
        });

        //--------------------------------------------------------

        // Кнопка Назад из окна с Уровнем

        Button btnBack = findViewById(R.id.button_back_level1);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level1dz.this, GameLevelsdz.class);
                startActivity(intent);

            }
        });
                final Animation animation = AnimationUtils.loadAnimation(Level1dz.this, R.anim.alfa); // подключение на уровент 1 созданный анимации в директори anim -alfa.xml

                // генерация значение для левой картинки
                numleft = random.nextInt(10);
                imgLeft.setImageResource(array.image1[numleft]);
                textLeft.setText(array.text1[numleft]);// достаем из  массива текст

                // генерация значение для правой картинки

                do
                {// еСЛИ СЛУЧАЙНОЕ РАВНО ПРАВОЙ  ТО ГЕНЕРИРУЕМ ЗАНОВО ПОКА РАВНЫ ДАЛЬШЕ НЕ УСТАНАВЛИВАЕМ ЗНАЧЕНИЯ
                    numRight = random.nextInt(10);
                } while (numleft == numRight);

                imgRight.setImageResource(array.image1[numRight]);
                textRight.setText(array.text1[numRight]);// достаем из  массива текст

                //Массив для прогресса игры
                final int[] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                        R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,};

                // обрабатываем нажатие на левую картинку
                imgLeft.setOnTouchListener(new View.OnTouchListener() {
                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {// если коснулись картитнки переход на какую чуть ниже
                            imgRight.setEnabled(false);// блокируем правую картинку
                            if (numleft > numRight) {
                                imgLeft.setImageResource(R.drawable.img_true);// сравнение для поставки зеленой галочки
                            } else {
                                imgLeft.setImageResource(R.drawable.img_false); // установка картинке с красным крестиком при данном условии
                            }
                        } else if (event.getAction() == MotionEvent.ACTION_UP) {// условия если отжали кнопку с картинки
                            if (numleft > numRight) {// до каких пор будет увелтчтвать элемент
                                if (count < 20) {
                                    count++; // увеличиваем на 1  так как их 19 отсчет я нулевого 0 ячейкм массива
                                }
                                // закрашиваеи программно прогресс серым цветом
                                for (int j : progress) {
                                    TextView tv = findViewById(j);
                                    tv.setBackgroundResource(R.drawable.style_points);

                                }
                                // определяем правильные ответы и закриваем зеленым
                                for (int i = 0; i < count; i++) {
                                    TextView tv = findViewById(progress[i]); // количество правильных ответов
                                    tv.setBackgroundResource(R.drawable.style_points_green);


                                }
                            } else {   //если левая картинка меньше правой

                                if (count > 0) {
                                    if (count == 1) {// обнуляем и вычитаем 1
                                        count = 0;
                                    } else {
                                        count -= 2;// чтобы не выйти за допустимое значение
                                    }
                                    for (int i = 0; i < progress.length - 1; i++) {//закращиваем серым цветов прогресс до момсента
                                        TextView tv = findViewById(progress[i]);
                                        tv.setBackgroundResource(R.drawable.style_points);
                                    }
                                    // определяем правильные ответы и закрашиваем зеленым цветом
                                    for (int i = 0; i < count; i++) {
                                        TextView tv = findViewById(progress[i]);
                                        tv.setBackgroundResource(R.drawable.style_points_green);
                                    }
                                }
                            }
                            if (count == 20) {
                                dialogEnd.show();// показать окно окончания
                                // выход  из уровня если больше 20
                            } else {
                                numleft = random.nextInt(10);
                                imgLeft.setImageResource(array.image1[numleft]); // достаем из массива картинку
                                imgLeft.startAnimation(animation);// запускаем анимацию для левой картингки
                                textLeft.setText(array.text1[numleft]);// достаем из массива текст
                                do {
                                    numRight = random.nextInt(10);
                                } while (numleft == numRight);


                                imgRight.setImageResource(array.image1[numRight]); // достаем из массива картинку
                                imgRight.startAnimation(animation);// запускаем анимацию для левой картингки
                                textRight.setText(array.text1[numRight]);// достаем из массива текст
                                imgRight.setEnabled(true);// включаем обратно правую картинку
                            }
                        }
                        return true;
                    }
                });

                // обрабатываем нажатие на правую картинку
                imgRight.setOnTouchListener(new View.OnTouchListener() {
                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {// если коснулись картитнки переход на какую чуть ниже
                            imgLeft.setEnabled(false);// блокируем левую картинку
                            if (numleft < numRight) {
                                imgRight.setImageResource(R.drawable.img_true);// сравнение для поставки зеленой галочки
                            } else {
                                imgRight.setImageResource(R.drawable.img_false); // установка картинке с красным крестиком при данном условии
                            }
                        } else if (event.getAction() == MotionEvent.ACTION_UP) {// условия если отжали кнопку с картинки
                            if (numleft < numRight) {// до каких пор будет увелтчтвать элемент
                                if (count < 20) {
                                    count++; // увеличиваем на 1  так как их 19 отсчет я нулевого 0 ячейкм массива
                                }
                                // закрашиваеи программно прогресс серым цветом
                                for (int j : progress) {
                                    TextView tv = findViewById(j);
                                    tv.setBackgroundResource(R.drawable.style_points);

                                }
                                // определяем правильные ответы и закриваем зеленым
                                for (int i = 0; i < count; i++) {
                                    TextView tv = findViewById(progress[i]); // количество правильных ответов
                                    tv.setBackgroundResource(R.drawable.style_points_green);


                                }
                            } else {   //если левая картинка меньше правой

                                if (count > 0) {
                                    if (count == 1) {// обнуляем и вычитаем 1
                                        count = 0;
                                    } else {
                                        count -= 2;// чтобы не выйти за допустимое значение
                                    }
                                    for (int i = 0; i < progress.length - 1; i++) {//закращиваем серым цветов прогресс до момсента
                                        TextView tv = findViewById(progress[i]);
                                        tv.setBackgroundResource(R.drawable.style_points);
                                    }
                                    // определяем правильные ответы и закрашиваем зеленым цветом
                                    for (int i = 0; i < count; i++) {
                                        TextView tv = findViewById(progress[i]);
                                        tv.setBackgroundResource(R.drawable.style_points_green);
                                    }
                                }
                            }
                            if (count == 20) {
                                dialogEnd.show();
                                ; // выход  из уровня если больше 20
                            } else {
                                numleft = random.nextInt(10);
                                imgLeft.setImageResource(array.image1[numleft]); // достаем из массива картинку
                                imgLeft.startAnimation(animation);// запускаем анимацию для левой картингки
                                textLeft.setText(array.text1[numleft]);// достаем из массива текст

                                do {
                                    numleft = random.nextInt(10);
                                } while (numleft == numRight);
                                imgRight.setImageResource(array.image1[numRight]); // достаем из массива картинку
                                imgRight.startAnimation(animation);// запускаем анимацию для левой картингки
                                textRight.setText(array.text1[numRight]);// достаем из массива текст
                                imgLeft.setEnabled(true);// включаем обратно правую картинку
                            }
                        }

                        return true;

                    }
                });
            }
        }