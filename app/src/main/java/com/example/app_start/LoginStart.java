package com.example.app_start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginStart extends AppCompatActivity {

    private Button btn_teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_start);

        IniciarComponentes();

        btn_teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginStart.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    public void IniciarComponentes(){
        btn_teste = findViewById(R.id.btn_teste);
    }
}