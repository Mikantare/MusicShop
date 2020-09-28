package com.bespalov.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuantity;
    private Button buttonPlusQuantity;

    private int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewQuantity =  findViewById(R.id.textViewQuantity);

    }

    public void increaseTheQuantity(View view) {
        quantity++;
        textViewQuantity.setText("" + quantity);
    }


    public void toReducequantity(View view) {
        if (quantity != 0) {
            quantity--;
            textViewQuantity.setText("" + quantity);
        }
    }
}