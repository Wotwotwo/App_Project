package com.example.cafeteria;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

public class Sign_Up extends AppCompatActivity {

    ImageButton back;

    Button sign_up;

    TextView username,password,phone,department;

    SharedPreferences sp,fp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);


        back = findViewById(R.id.backbtn);
        sign_up = findViewById(R.id.button2);
        username = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextText2);
        phone = findViewById(R.id.editTextText4);
        department = findViewById(R.id.editTextText3);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_Up.this,Login.class);
                startActivity(intent);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(username.getText()) || TextUtils.isEmpty(password.getText()) || TextUtils.isEmpty(phone.getText()) || TextUtils.isEmpty(department.getText())) {
                    Toast.makeText(Sign_Up.this, "Please fill in all fields", Toast.LENGTH_LONG).show();
                }
                else {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    String number = phone.getText().toString();
                    String depart = department.getText().toString();

                    fp = getSharedPreferences("Prefs",Context.MODE_PRIVATE);
                    SharedPreferences.Editor checker = fp.edit();
                    checker.putString("name1", user);
                    checker.putString("Value","true");
                    checker.putString("MenuValue","N/A");
                    checker.commit();


                    sp = getSharedPreferences(user,Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();

                    editor.putString("name", user);
                    editor.putString("pass", pass);
                    editor.putString("number", number);
                    editor.putString("department", depart);
                    editor.commit();


                    Toast.makeText(Sign_Up.this, "Account Created", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Sign_Up.this, account.class);
                    startActivity(intent);

                }
            }
        });




    }

}