package com.mooi.lifecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username,password,confirmPsw;
    Button regbtn;
    TextView loginHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.rgusername);
        password = findViewById(R.id.rgpassword);
        confirmPsw = findViewById(R.id.confirmPassword);
        regbtn = findViewById(R.id.regbutton);
        loginHere = findViewById(R.id.loginTv);

        loginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String passWord = password.getText().toString();
                String cnfPsw = confirmPsw.getText().toString();

                Database db = new Database(getApplicationContext(),"LifeCare",null,1);

                if(userName.length() == 0 || passWord.length() == 0 || cnfPsw.length() == 0 ){

                    Toast.makeText(RegisterActivity.this, "Enter all details", Toast.LENGTH_SHORT).show();
                }else{
                    db.register(userName,passWord);
                    Toast.makeText(RegisterActivity.this, "record inserted", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}