package com.example.app_start.ui.produto.Operations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.app_start.DB.DBHelper;
import com.example.app_start.R;
import com.example.app_start.ui.funcionario.FuncionarioRVAdapter;
import com.example.app_start.ui.funcionario.Operations.ConsultaFuncionario;
import com.example.app_start.ui.funcionario.model.FuncionarioModel;
import com.example.app_start.ui.produto.ProdutoRVAdapter;
import com.example.app_start.ui.produto.model.ProdutoModel;

import java.util.ArrayList;

public class ConsultarProduto extends AppCompatActivity {

    private ArrayList<ProdutoModel> produtoModels;
    private DBHelper dbHelper;
    private ProdutoRVAdapter produtoRVAdapter;
    private RecyclerView produtoRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_produto);

        IniciarComponentes();

        produtoModels = dbHelper.readProduto();

        produtoRVAdapter = new ProdutoRVAdapter(produtoModels, ConsultarProduto.this);
        produtoRV = findViewById(R.id.idRVProduto);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ConsultarProduto.this,
                RecyclerView.VERTICAL, false);

        produtoRV.setLayoutManager(linearLayoutManager);

        produtoRV.setAdapter(produtoRVAdapter);
    }

    public void IniciarComponentes(){
        produtoModels = new ArrayList<>();
        dbHelper = new DBHelper(ConsultarProduto.this);
    }
}