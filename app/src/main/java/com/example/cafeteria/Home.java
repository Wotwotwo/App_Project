package com.example.cafeteria;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {


    RelativeLayout Potato_Corner,The_Shawarma_Shack;
    ImageButton home,activ,payment,account, reccomended1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        home =  findViewById(R.id.homebtn);
        activ =  findViewById(R.id.actbtn);
        payment =  findViewById(R.id.paymentbtn);
        account =  findViewById(R.id.accountbtn);

        Potato_Corner = findViewById(R.id.Potato_Corner);
        The_Shawarma_Shack = findViewById(R.id.Shawarma);

        reccomended1 = findViewById(R.id.reccomended1);

        SharedPreferences fp = getSharedPreferences("Prefs", Context.MODE_PRIVATE);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        reccomended1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor checker = fp.edit();
                checker.putString("MenuValue","Potato_Corner");
                checker.commit();

                Intent intent = new Intent(Home.this, Order.class);
                startActivity(intent);
            }
        });


        Potato_Corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor checker = fp.edit();
                checker.putString("MenuValue","Potato_Corner");
                checker.commit();

                Intent intent = new Intent(Home.this, Order.class);
                startActivity(intent);
            }
        });

        The_Shawarma_Shack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor checker = fp.edit();
                checker.putString("MenuValue","Shawarma");
                checker.commit();

                Intent intent = new Intent(Home.this, Order.class);
                startActivity(intent);
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        activ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Acti.class);
                startActivity(intent);
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Payment.class);
                startActivity(intent);
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, account.class);
                startActivity(intent);
            }
        });


    }
}