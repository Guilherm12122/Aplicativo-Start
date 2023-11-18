package com.example.app_start.ui.funcionario.Operations;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_start.DB.DBHelper;
import com.example.app_start.R;
import com.example.app_start.others.AlertMsg;
import com.google.android.material.snackbar.Snackbar;

public class CriarFuncionario extends AppCompatActivity {

    EditText nome;
    EditText cargo;
    EditText senha;
    Button cadastrar;

    Snackbar snackbar;

    DBHelper db;
    private AlertMsg alertMsg;

    String[] msg = {"Todos os campos devem ser preenchidos.", "Funcionário incluso com sucesso.", "Erro ao inserir funcionário..",
            "Já existe funcionário com esse nome."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_funcionario);

        IniciarComponentes();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome_user = nome.getText().toString();
                String cargo_user = cargo.getText().toString();
                String senha_user = senha.getText().toString();

                if(nome_user.isEmpty() || cargo_user.isEmpty() || senha_user.isEmpty()){
                    alertMsg.ShowMsg(alertDialog, msg[0]);
                } else {
                    Boolean check_username = db.checkUserName(nome_user);

                    if (check_username == false) {
                        Boolean insert_status = db.insertData(nome_user, senha_user, cargo_user);

                        if (insert_status){
                            alertMsg.ShowMsg(alertDialog, msg[1]);
                        } else {
                            alertMsg.ShowMsg(alertDialog, msg[2]);
                        }

                    } else {
                        alertMsg.ShowMsg(alertDialog, msg[3]);
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
        alertMsg = new AlertMsg();
    }
}