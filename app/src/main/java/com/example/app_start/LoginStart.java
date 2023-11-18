package com.example.app_start;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_start.DB.DBHelper;
import com.example.app_start.others.AlertMsg;

public class LoginStart extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button btn_teste;
    private Button btn;
    private Intent intent;
    private DBHelper db;
    private AlertMsg alertMsg;
    String[] msg = {"Preencha todos os campos", "Usuário não encontrado."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_start);

        IniciarComponentes();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_typed = name.getText().toString();
                String pass_typed = password.getText().toString();

                if(name_typed.isEmpty() || pass_typed.isEmpty()){
                    alertMsg.ShowMsg(alertDialog, msg[0]);
                } else {
                    Boolean check = db.checkUser(name_typed, pass_typed);

                    if (check) {
                        startActivity(intent);
                    } else {
                        alertMsg.ShowMsg(alertDialog, msg[1]);
                    }

                }

            }
        });

        btn_teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    public void IniciarComponentes(){
        name = findViewById(R.id.edit_name);
        password = findViewById(R.id.edit_password);
        btn_teste = findViewById(R.id.btn_teste);
        btn =  findViewById(R.id.btn);
        intent = new Intent(LoginStart.this, HomePage.class);
        db = new DBHelper(this);
        alertMsg = new AlertMsg();
    }
}