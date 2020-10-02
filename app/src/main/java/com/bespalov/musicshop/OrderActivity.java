package com.bespalov.musicshop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private TextView textViewOrder;

    private String addresses = "abespalov33@gmail.ru";
    private String subject = "Заказ";
    private String order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        this.setTitle("Your order");
        textViewOrder = findViewById(R.id.textViewOrder);
        Intent intent = getIntent();
        int quantity = intent.getIntExtra("quantity",0);
        double summ = intent.getDoubleExtra("summ",0);
        double price = summ/quantity;
        order = "Имя пользователя: " + intent.getStringExtra("name") + "." +
                "\nИнстумент: " + intent.getStringExtra("godsName") + "." +
                "\nКолличество : " + quantity +
                "\nЦена: " + price + "." +
                "\nСумма: " + summ;
        textViewOrder.setText(order);
    }


    public void sendOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,order);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}