package com.example.app_start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ConsultarProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_produto);

        Toolbar mytoolBar = findViewById(R.id.my_tool_bar_consulta_produto);
        setSupportActionBar(mytoolBar);
    }
}