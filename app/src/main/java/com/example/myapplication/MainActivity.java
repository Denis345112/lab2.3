package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button Yes,No;
    TextView fcolor,scolor,otvet;
    int count;
    int right;
    String[] textcolor;
    Resources res;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Yes=(Button) findViewById(R.id.button1);
        No=(Button) findViewById(R.id.button2);
        fcolor=(TextView) findViewById(R.id.textView3);
        scolor=(TextView) findViewById(R.id.textView4);
        otvet=(TextView) findViewById(R.id.textView5);
        TextView txtseconds = (TextView) findViewById(R.id.textView);
        Button btnStart = (Button) findViewById(R.id.button);

        res = getResources();
        textcolor = res.getStringArray(R.array.textcolor);
        count = 0;
        right = 0;


        fcolor.setText(textcolor[count]);

        scolor.setText(textcolor[count]);

        View.OnClickListener oclbtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer my_timer = new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long l) {
                        txtseconds.setText(Long.toString(l / 1000));
                    }

                    @Override
                    public void onFinish() {
                        txtseconds.setText("Игра завершена");
                        String score = Integer.toString(right);
                        otvet.setText(score);
                    }

                };
                my_timer.start();

        Yes.setOnClickListener(new View.OnClickListener()

                           {
                               @Override
                               public void onClick (View v)
                               {
                                   if (count <= 5 || fcolor != scolor) {
                                       count++;
                                       fcolor.setText(textcolor[count]);
                                       scolor.setText(textcolor[count]);
                                       right++;
                                   } else {
                                       count = 0;
                                       fcolor.setText(textcolor[count]);
                                       scolor.setText(textcolor[count]);
                                   }


                                   Random rnd = new Random();
                                   int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                                   scolor.setTextColor(color);
                               }

                           });
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                if (count <= 5 || fcolor == scolor){
                    count++;
                    fcolor.setText(textcolor[count]);
                    scolor.setText(textcolor[count]);
                    right++;
                }else {
                    count = 0;
                    fcolor.setText(textcolor[count]);
                    scolor.setText(textcolor[count]);

                }
                scolor.setTextColor(color);
            }

        });
            }


        };
        btnStart.setOnClickListener(oclbtn);
    }


}

