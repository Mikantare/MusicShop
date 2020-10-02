package com.bespalov.musicshop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private TextView textViewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        textViewOrder = findViewById(R.id.textViewOrder);
        Intent intent = getIntent();
        int quantity = intent.getIntExtra("quantity",0);
        double summ = intent.getDoubleExtra("summ",0);
        double price = summ/quantity;
        textViewOrder.setText("Имя пользователя: " + intent.getStringExtra("name") + "." + "\nИнстумент: " + intent.getStringExtra("godsName") + "." + "\nКолличество : " + quantity + "\nЦена: " + price + "." + "\nСумма: " + summ);
        this.setTitle("Your order");
    }


}