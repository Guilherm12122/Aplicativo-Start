package com.example.app_start.ui.produto.Operations;

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

public class RemoverProduto extends AppCompatActivity {

    private EditText codigo_produto;
    private Button excluir_produto;
    DBHelper db;
    AlertMsg alertMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_produto);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        IniciarComponentes();

        excluir_produto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod_produto = codigo_produto.getText().toString();

                if (cod_produto.isEmpty()){
                    alertMsg.ShowMsg(alertDialog, "Um código precisa ser informado");
                } else {

                    Boolean status_exist = db.checkProductId(Integer.parseInt(codigo_produto.getText().toString()));

                    if (status_exist) {

                        Boolean status = db.RemoveProduto(Integer.parseInt(cod_produto));

                        if (status) {
                            alertMsg.ShowMsg(alertDialog, "Produto excluído com sucesso.");
                        } else {
                            alertMsg.ShowMsg(alertDialog, "Erro ao excluir produto.");
                        }

                    } else {
                        alertMsg.ShowMsg(alertDialog, "Não existe produto com esse código.");
                    }


                }
            }
        });

        Toolbar mytoolBar = findViewById(R.id.my_tool_bar_remover_produto);
        setSupportActionBar(mytoolBar);
    }

    public void IniciarComponentes(){
        codigo_produto = findViewById(R.id.codigo_remover_produto);
        excluir_produto = findViewById(R.id.btn_realizar_exclusão_produto);
        db = new DBHelper(this);
        alertMsg = new AlertMsg();
    }
}