package com.hfad.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int counter = 0;
    TextView countTxt;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("CurrentValue", Context.MODE_PRIVATE);
        counter = sp.getInt("currentValue", 0);
        countTxt = (TextView) findViewById(R.id.nbr);
        countTxt.setText(formatString(counter));
    }







    private String formatString(int value)
    {
        String temp;


        if (value < 10) {
            temp = "00" + value;
        }


        else if (value > 9 && value < 100) {
           temp = "0" + value;
        }

        else if (value > 99 && value < 999 ){
            temp = Integer.toString(value);
        }
        else if (value > 998){
            counter = 0;
            temp = Integer.toString(value);

        }

        else {temp = "Hitta inte ett nummer";}

        save();
        return temp;
    }

    private void save()
    {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("currentValue",counter).apply();


    }

    public void SetValue(View view) {

        counter++;


        countTxt = (TextView) findViewById(R.id.nbr);
        countTxt.setText(formatString(counter));
    }
}


