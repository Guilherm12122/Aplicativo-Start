package com.example.app_start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class LoginStart extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button btn_teste;
    private Button btn;

    String[] msg = {"Preencha todos os campos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_start);

        IniciarComponentes();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_typed = name.getText().toString();
                String pass_typed = password.getText().toString();

                if(name_typed.isEmpty() || pass_typed.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, msg[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }

            }
        });

        btn_teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginStart.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    public void IniciarComponentes(){
        name = findViewById(R.id.edit_name);
        password = findViewById(R.id.edit_password);
        btn_teste = findViewById(R.id.btn_teste);
        btn =  findViewById(R.id.btn);
    }
}