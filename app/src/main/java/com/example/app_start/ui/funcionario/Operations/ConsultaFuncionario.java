package com.example.app_start.ui.funcionario.Operations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.app_start.DB.DBHelper;
import com.example.app_start.R;
import com.example.app_start.ui.funcionario.FuncionarioRVAdapter;
import com.example.app_start.ui.funcionario.model.FuncionarioModel;

import java.util.ArrayList;

public class ConsultaFuncionario extends AppCompatActivity {

    private ArrayList<FuncionarioModel> funcionarioModels;
    private DBHelper dbHelper;
    private FuncionarioRVAdapter funcionarioRVAdapter;
    private RecyclerView funcionarioRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_funcionario);

        IniciarComponentes();

        funcionarioModels = dbHelper.readFuncionario();

        funcionarioRVAdapter = new FuncionarioRVAdapter(funcionarioModels, ConsultaFuncionario.this);
        funcionarioRV = findViewById(R.id.idRVFuncionario);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ConsultaFuncionario.this,
                RecyclerView.VERTICAL, false);

        funcionarioRV.setLayoutManager(linearLayoutManager);

        funcionarioRV.setAdapter(funcionarioRVAdapter);

        Toolbar mytoolBar = findViewById(R.id.my_tool_bar_consultar_funcionario);
        setSupportActionBar(mytoolBar);
    }

    public void IniciarComponentes(){
        funcionarioModels = new ArrayList<>();
        dbHelper = new DBHelper(ConsultaFuncionario.this);
    }
}