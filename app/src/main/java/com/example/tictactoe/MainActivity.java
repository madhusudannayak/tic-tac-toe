package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int black= 0;
    int [] state ={2,2,2,2,2,2,2,2,2};
    int [][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean active =true;
    TextView textView;
    GridLayout gridLayout;
    int count=0;


    public void img(View view) {
        ImageView imageView =(ImageView) view;
        int counter =Integer.parseInt(imageView.getTag().toString());
        if(state[counter]==2 && active ){
        state[counter]=black;
       imageView.setTranslationY(-1500);
        if(black==0){
            count++;
            imageView.setImageResource(R.drawable.black);
            black=1;
        }else{
            imageView.setImageResource(R.drawable.red);
            black=0;
            count++;
        }
        imageView.animate().translationYBy(1500).rotation(3600).setDuration(300);

        for(int [] win :win) {

            if (state[win[0]] == state[win[1]] && state[win[1]] == state[win[2]] && state[win[0]] != 2) {
                String whowin="";
                active=false;
                if (black == 0) {
                    whowin="Red";
                   } else {
                    whowin="Black";

                }
                textView.setText(whowin+" won");
                textView.setTextColor(Color.RED);

                Button playagain = findViewById(R.id.button);
                playagain.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
            }
        }
        }
        if(count>8){
            Button playagain = findViewById(R.id.button);
            playagain.setVisibility(View.VISIBLE);
            textView.setText("No one Won");


        }

    }

        public void playAgain (View v){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.textView);

        textView.setText("");

    }
}