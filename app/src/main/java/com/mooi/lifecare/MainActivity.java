package com.mooi.lifecare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button loginBtn;
    TextView registerHere;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginButton);
        registerHere = findViewById(R.id.registerTV);

        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                Database db = new Database(getApplicationContext(),"LifeCare",null,1);
                if(userName.equals("") || passWord.equals("")){
                    //do somthing
                    Toast.makeText(MainActivity.this, "enter details", Toast.LENGTH_SHORT).show();
                }else{
                    if(db.login(userName,passWord) == 1){
                        Toast.makeText(MainActivity.this, "login Success", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }


                    startActivity(new Intent(MainActivity.this,HomeActivity.class));

                }
            }
        });


    }
}