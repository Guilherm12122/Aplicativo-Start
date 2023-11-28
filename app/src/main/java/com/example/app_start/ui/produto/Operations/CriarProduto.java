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

public class CriarProduto extends AppCompatActivity {

    EditText nome_produto;
    EditText preco;
    Button cadastrar_produto;

    DBHelper db;

    AlertMsg alertMsg;
    String[] msg = {"Todos os campos devem ser preenchidos.", "Produto incluso com sucesso.", "Erro ao inserir produto..."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_produto);

        IniciarComponentes();

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        cadastrar_produto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nome_produto.getText().toString();
                String preco_produto = preco.getText().toString();

                if(name.isEmpty() || preco_produto.isEmpty()){
                    alertMsg.ShowMsg(alertDialog, msg[0]);
                } else {

                    try {
                        Float preco_produto_float = Float.parseFloat(preco_produto);

                        Boolean status = db.insertDataProduto(name, preco_produto_float);

                        if (status){
                            alertMsg.ShowMsg(alertDialog, msg[1]);
                        } else {
                            alertMsg.ShowMsg(alertDialog, msg[2]);
                        }

                    } catch (Exception e) {
                        System.out.println("Preço inválido.");
                        alertMsg.ShowMsg(alertDialog, "Preço inválido");
                    }

                }
            }
        });


    }


    public void IniciarComponentes(){
        nome_produto = findViewById(R.id.nome_produto);
        preco = findViewById(R.id.preco_produto);
        cadastrar_produto = findViewById(R.id.btn_realizar_cadastro_produto);
        db = new DBHelper(this);
        alertMsg = new AlertMsg();
    }
}