package com.example.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button BtnLogin;
    EditText username, password;

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        BtnLogin = findViewById(R.id.btnLogin);

        login();

        if (SharedPref.getInstance(LoginActivity.this).isLogin()) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }


    private void login() {
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_ = username.getText().toString();
                String pass_ = password.getText().toString();
                if (username_.equals("admin") && pass_.equals("admin123")) {
                    Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
                    SharedPref.getInstance(LoginActivity.this).setName(username_);
                    SharedPref.getInstance(LoginActivity.this).setLogin(true);

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                } else {

                    Toast.makeText(getApplicationContext(), "Username dan Password tidak sesuai dan Anda gagal login", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}

