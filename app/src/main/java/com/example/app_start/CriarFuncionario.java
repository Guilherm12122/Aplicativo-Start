package com.example.app_start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class CriarFuncionario extends AppCompatActivity {

    EditText nome;
    EditText cargo;
    EditText senha;
    Button cadastrar;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_funcionario);

        IniciarComponentes();

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome_user = nome.getText().toString();
                String cargo_user = cargo.getText().toString();
                String senha_user = senha.getText().toString();

                if(nome_user.isEmpty() || cargo_user.isEmpty() || senha_user.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, "Todos os campos devem ser preenchidos.", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                } else {
                    Boolean check_username = db.checkUserName(nome_user);

                    if (check_username == false) {
                        Boolean insert_status = db.insertData(nome_user, senha_user, cargo_user);

                        if (insert_status){
                            Snackbar snackbar = Snackbar.make(view, "Funcionário incluso com sucesso.", Snackbar.LENGTH_SHORT);
                            snackbar.setBackgroundTint(Color.WHITE);
                            snackbar.setTextColor(Color.BLACK);
                            snackbar.show();
                        } else {
                            Snackbar snackbar = Snackbar.make(view, "Erro ao inserir funcionário..", Snackbar.LENGTH_SHORT);
                            snackbar.setBackgroundTint(Color.WHITE);
                            snackbar.setTextColor(Color.BLACK);
                            snackbar.show();
                        }

                    } else {
                        Snackbar snackbar = Snackbar.make(view, "Já existe funcionário com esse nome.", Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.WHITE);
                        snackbar.setTextColor(Color.BLACK);
                        snackbar.show();
                    }



                }

            }
        });

        Toolbar mytoolBar = findViewById(R.id.my_tool_bar_criar);
        setSupportActionBar(mytoolBar);
    }


    public void IniciarComponentes(){
        nome = findViewById(R.id.nome_usuario);
        senha = findViewById(R.id.senha);
        cadastrar =  findViewById(R.id.btn_realizar_cadastro);
        cargo = findViewById(R.id.cargo);
        db = new DBHelper(this);
    }
}