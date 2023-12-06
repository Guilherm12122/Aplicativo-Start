package com.example.app_start.ui.produto.Operations;

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

public class EditarProduto extends AppCompatActivity {

    private EditText codigo_produto_atualizacao;
    private EditText nome_produto_atualizacao;
    private EditText preco_produto_atualizacao;
    private Button btn_atualizar_produto_edit;
    private Button btn_consultar_produto_edit;
    DBHelper db;
    AlertMsg alertMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);

        IniciarComponentes();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);


        btn_consultar_produto_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String codigo_produto = codigo_produto_atualizacao.getText().toString();

                if (codigo_produto.isEmpty()){
                    alertMsg.ShowMsg(alertDialog, "É necessário um código para consulta.");
                } else {

                    Integer codigo_produto_int = Integer.parseInt(codigo_produto);

                    Boolean status_exits = db.checkProductId(codigo_produto_int);

                    if (status_exits){
                        Cursor dados = db.selectProdutoById(codigo_produto_int);
                        nome_produto_atualizacao.setText(dados.getString(1));
                        preco_produto_atualizacao.setText(dados.getString(2));
                    } else {
                        alertMsg.ShowMsg(alertDialog, "Não existe produto com esse código");
                    }

                }

            }
        });

        btn_atualizar_produto_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String codigo_produto = codigo_produto_atualizacao.getText().toString();

                String nome_produto = nome_produto_atualizacao.getText().toString();

                String preco_produto = preco_produto_atualizacao.getText().toString();

                if (codigo_produto.isEmpty() || nome_produto.isEmpty() || preco_produto.isEmpty() ){
                    alertMsg.ShowMsg(alertDialog, "Todos os campos precisam estar preenchidos.");
                } else {

                    Integer codigo_produto_int = Integer.parseInt(codigo_produto);

                    Boolean status_exits = db.checkProductId(codigo_produto_int);

                    if (status_exits){

                        boolean result = db.updateProduto(codigo_produto_int, nome_produto, preco_produto);

                        if (result){
                            alertMsg.ShowMsg(alertDialog, "Dados do produto atualizados com sucesso");
                        } else {
                            alertMsg.ShowMsg(alertDialog, "Erro ao atualizar os dados");
                        }

                    } else {
                        alertMsg.ShowMsg(alertDialog, "Não existe produto com esse código");
                    }

                }


            }
        });

        Toolbar mytoolBar = findViewById(R.id.my_tool_bar_editar_produto);
        setSupportActionBar(mytoolBar);
    }

    public void IniciarComponentes(){
        codigo_produto_atualizacao = findViewById(R.id.codigo_editar_produto);
        nome_produto_atualizacao = findViewById(R.id.nome_editar_produto);
        preco_produto_atualizacao = findViewById(R.id.preco_editar_produto);
        btn_atualizar_produto_edit = findViewById(R.id.btn_atualizar_produto);
        btn_consultar_produto_edit = findViewById(R.id.btn_consultar_produto_edicao);
        db = new DBHelper(this);
        alertMsg = new AlertMsg();
    }
}