package com.example.cafeteria;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class account extends AppCompatActivity {

    ImageButton home,activ,payment,account;


    TextView username,department,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);

        home =  findViewById(R.id.homebtn);
        activ =  findViewById(R.id.actbtn);
        payment =  findViewById(R.id.paymentbtn);
        account =  findViewById(R.id.accountbtn);


        username = findViewById(R.id.Name);
        department = findViewById(R.id.Department);
        phone = findViewById(R.id.Number);

        SharedPreferences fp = getApplication().getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        String user = fp.getString("name1","");

        SharedPreferences sp = getApplication().getSharedPreferences(user, Context.MODE_PRIVATE);
        String name = sp.getString("name","");
        String depart =sp.getString("department","");
        String  number = sp.getString("number","");

        username.setText(name);
        department.setText(depart);
        phone.setText(number);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account.this, Home.class);
                startActivity(intent);
            }
        });
        activ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account.this, Acti.class);
                startActivity(intent);
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account.this, Payment.class);
                startActivity(intent);
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}