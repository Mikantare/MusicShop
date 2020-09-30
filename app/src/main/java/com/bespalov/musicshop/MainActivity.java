package com.bespalov.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuantity;
    private Button buttonPlusQuantity;
    private Spinner spinnerSelectItem;
    private TextView textViewPrice;
    private ImageView imageViewGoods;

    private HashMap hashMapTools;

    private int quantity = 0;
    private Double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        creatMap();
        spinnerSelectItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String godsName = spinnerSelectItem.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "" + godsName, Toast.LENGTH_SHORT).show();
                price = ((double) hashMapTools.get(godsName));
                setPrice();
                switch (godsName) {
                    case "guitar":
                        imageViewGoods.setImageResource(R.drawable.gitar);
                        break;
                        case "drum":
                        imageViewGoods.setImageResource(R.drawable.drums);
                        break;
                    case "keyboard":
                        imageViewGoods.setImageResource(R.drawable.keyboard);
                        break;
                    case "bayan":
                        imageViewGoods.setImageResource(R.drawable.bayan);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void init () {
        textViewQuantity = findViewById(R.id.textViewQuantity);
        spinnerSelectItem = findViewById(R.id.spinnerSelectItem);
        imageViewGoods = findViewById(R.id.imageViewGoods);
        textViewPrice = findViewById(R.id.textViewPrice);
    }

    public void creatMap () {
        hashMapTools = new HashMap();
        hashMapTools.put("guitar", 500.00);
        hashMapTools.put("drum", 1500.00);
        hashMapTools.put("keyboard", 1000.00);
        hashMapTools.put("bayan", 750.00);
    }

    public void setPrice() {
        Double summ = price * quantity;
        textViewPrice.setText(summ.toString());
    }

    public void increaseTheQuantity(View view) {
        quantity++;
        textViewQuantity.setText("" + quantity);
        setPrice();
    }


    public void toReducequantity(View view) {
        if (quantity != 0) {
            quantity--;
            textViewQuantity.setText("" + quantity);
            setPrice();
        }
    }
}