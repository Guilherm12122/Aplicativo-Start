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

public class RemoverFuncionario extends AppCompatActivity {
    private EditText codigo_funcionario;
    private Button excluir;
    private AlertMsg alertMsg;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_funcionario);

        IniciarComponentes();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo_func = codigo_funcionario.getText().toString();

                if (codigo_func.isEmpty()){
                    alertMsg.ShowMsg(alertDialog, "Um código precisa ser informado");
                } else {

                    Boolean status_exist = db.checkUserId(Integer.parseInt(codigo_funcionario.getText().toString()));

                    if (status_exist) {

                        Boolean status = db.RemoveFuncionario(Integer.parseInt(codigo_func));

                        if (status) {
                            alertMsg.ShowMsg(alertDialog, "Funcionário excluído com sucesso.");
                        } else {
                            alertMsg.ShowMsg(alertDialog, "Erro ao excluir funcionário.");
                        }

                    } else {
                        alertMsg.ShowMsg(alertDialog, "Não existe funcionário com esse código.");
                    }


                }

            }
        });

        Toolbar mytoolBar = findViewById(R.id.my_tool_bar_deletar);
        setSupportActionBar(mytoolBar);
    }

    public void IniciarComponentes(){
        codigo_funcionario = findViewById(R.id.codigo_remover);
        excluir = findViewById(R.id.btn_realizar_exclusão);
        db = new DBHelper(this);
        alertMsg = new AlertMsg();
    }
}