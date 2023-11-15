package com.example.app_start.ui.funcionario.Operations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.app_start.R;

public class RemoverFuncionario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_funcionario);

        Toolbar mytoolBar = findViewById(R.id.my_tool_bar_remover);
        setSupportActionBar(mytoolBar);
    }
}