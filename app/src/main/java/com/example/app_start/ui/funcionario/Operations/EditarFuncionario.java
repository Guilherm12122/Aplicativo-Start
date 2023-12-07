package com.example.app_start.ui.funcionario.Operations;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_start.DB.DBHelper;
import com.example.app_start.R;
import com.example.app_start.others.AlertMsg;

public class EditarFuncionario extends AppCompatActivity {

    private EditText codigo_funcionario_atualizacao;
    private EditText nome_funcionario_atualizacao;
    private EditText cargo_funcionario_atualizacao;
    private Button btn_atualizar_edit;
    private Button btn_consultar_edit;
    DBHelper db;
    AlertMsg alertMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_funcionario);

        IniciarComponentes();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        btn_consultar_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String codigo_funcionario = codigo_funcionario_atualizacao.getText().toString();

                if (codigo_funcionario.isEmpty()){
                    alertMsg.ShowMsg(alertDialog, "É necessário um código para consulta.");
                } else {

                    Integer codigo_funcionario_int = Integer.parseInt(codigo_funcionario);

                    Boolean status_exits = db.checkUserId(codigo_funcionario_int);

                    if (status_exits){
                        Cursor dados = db.selectFuncionarioById(codigo_funcionario_int);
                        nome_funcionario_atualizacao.setText(dados.getString(1));
                        cargo_funcionario_atualizacao.setText(dados.getString(2));
                    } else {
                        alertMsg.ShowMsg(alertDialog, "Não existe funcionário com esse código");
                    }
                }
            }
        });

        btn_atualizar_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String codigo_funcionario = codigo_funcionario_atualizacao.getText().toString();

                String nome_funcionario = nome_funcionario_atualizacao.getText().toString();

                String cargo_funcionario = cargo_funcionario_atualizacao.getText().toString();

                if (codigo_funcionario.isEmpty() || nome_funcionario.isEmpty() || cargo_funcionario.isEmpty() ){
                    alertMsg.ShowMsg(alertDialog, "Todos os campos precisam estar preenchidos.");
                } else {
                    Integer codigo_funcionario_int = Integer.parseInt(codigo_funcionario);

                    Boolean status_exits = db.checkUserId(codigo_funcionario_int);

                    if (status_exits){

                        boolean result = db.updateFuncionario(codigo_funcionario_int, nome_funcionario, cargo_funcionario);

                        if (result){
                            alertMsg.ShowMsg(alertDialog, "Dados do funcionário atualizados com sucesso");
                        } else {
                            alertMsg.ShowMsg(alertDialog, "Erro ao atualizar os dados");
                        }

                    } else {
                        alertMsg.ShowMsg(alertDialog, "Não existe funcionário com esse código");
                    }
                }

            }
        });



        Toolbar mytoolBar = findViewById(R.id.my_tool_bar_editar);
        setSupportActionBar(mytoolBar);
    }

    public void IniciarComponentes(){
        codigo_funcionario_atualizacao = findViewById(R.id.codigo_editar_funcionario);
        nome_funcionario_atualizacao = findViewById(R.id.nome_editar_funcionario);
        cargo_funcionario_atualizacao = findViewById(R.id.cargo_editar_funcionario);
        btn_atualizar_edit = findViewById(R.id.btn_atualizar_funcionario);
        btn_consultar_edit = findViewById(R.id.btn_consultar_funcionario_edicao);
        db = new DBHelper(this);
        alertMsg = new AlertMsg();
    }
}