package com.example.app_start.ui.funcionario;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app_start.ConsultaFuncionario;
import com.example.app_start.CriarFuncionario;
import com.example.app_start.EditarFuncionario;
import com.example.app_start.HomePage;
import com.example.app_start.LoginStart;
import com.example.app_start.R;
import com.example.app_start.RemoverFuncionario;
import com.example.app_start.databinding.FragmentFuncionarioBinding;
import com.google.android.material.snackbar.Snackbar;

public class FuncionarioFragment extends Fragment implements View.OnClickListener {

    private Button button_consultar;
    private Button button_criar;
    private Button button_remover;
    private Button button_atualizar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_funcionario, container, false);

        IniciarComponentes(view);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_consultar_funcionario){
            Intent intent = new Intent(getActivity(), ConsultaFuncionario.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_adicionar_funcionario) {
            Intent intent = new Intent(getActivity(), CriarFuncionario.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_remover_funcionario) {
            Intent intent = new Intent(getActivity(), RemoverFuncionario.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_editar_funcionario) {
            Intent intent = new Intent(getActivity(), EditarFuncionario.class);
            startActivity(intent);
        }
    }

    public void IniciarComponentes(View view){
        button_consultar = view.findViewById(R.id.btn_consultar_funcionario);
        button_criar = view.findViewById(R.id.btn_adicionar_funcionario);
        button_remover = view.findViewById(R.id.btn_remover_funcionario);
        button_atualizar = view.findViewById(R.id.btn_editar_funcionario);

        button_consultar.setOnClickListener(this);
        button_criar.setOnClickListener(this);
        button_remover.setOnClickListener(this);
        button_atualizar.setOnClickListener(this);
    }
}