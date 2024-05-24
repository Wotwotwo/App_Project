package com.example.cafeteria;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order extends AppCompatActivity {

    ImageButton back,home,activ,payment,account;

    SharedPreferences fp;
    String check;


    List<Menu> MenuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);


        fp = getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        check = fp.getString("MenuValue", "");


        FillMenuList();

        back = findViewById(R.id.backbtn);
        home = findViewById(R.id.homebtn);
        activ = findViewById(R.id.actbtn);
        payment = findViewById(R.id.paymentbtn);
        account = findViewById(R.id.accountbtn);

        LinearLayout Food_Holder = findViewById(R.id.Menu_Holder);

        for (Menu menu : MenuList) {
            RelativeLayout foodItemLayout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.activity_test2, null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(70, 50, 0, 0);
            foodItemLayout.setLayoutParams(layoutParams);

            // Find views in the inflated layout
            TextView nameTextView = foodItemLayout.findViewById(R.id.Name);
            TextView priceTextView = foodItemLayout.findViewById(R.id.Price);
            ImageView imageView = foodItemLayout.findViewById(R.id.Product);

            // Set data to views
            nameTextView.setText(menu.getName());
            priceTextView.setText(String.format("%.2f", menu.getPrice()));// Convert price to string
            imageView.setImageResource(menu.getImageURL());
            // Add the inflated layout to the LinearLayout
            Food_Holder.addView(foodItemLayout);
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, Home.class);
                startActivity(intent);
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, Home.class);
                startActivity(intent);
            }
        });
        activ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, Acti.class);
                startActivity(intent);
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, Payment.class);
                startActivity(intent);
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, account.class);
                startActivity(intent);
            }
        });






    }

    private void FillMenuList() {
        if (check.equals("Potato_Corner")) {
            Menu f0 = new Menu("Regular Fries", 41.00, R.drawable.regular_size_fries);
            Menu f1 = new Menu("Large Fries", 67.00, R.drawable.large_size_fries);
            Menu f2 = new Menu("Jumbo Fries", 97.00, R.drawable.jumbo_size_fries);
            Menu f3 = new Menu("Mega Fries", 127.00, R.drawable.mega_size_fries);
            Menu f4 = new Menu("Giga Fries", 198.00, R.drawable.giga_fries);
            Menu f5 = new Menu("Tera Fries", 228.00, R.drawable.terra_fries);
            Menu f6 = new Menu("Valentines Special Fries", 100.00, R.drawable.rectangle_10);

            MenuList.addAll(Arrays.asList(new Menu[]{f0, f1, f2, f3, f4, f5,f6}));
        } else if (check.equals("Shawarma")) {

        }

    }
}