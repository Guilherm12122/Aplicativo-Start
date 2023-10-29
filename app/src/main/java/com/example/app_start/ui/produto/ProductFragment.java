package com.example.app_start.ui.produto;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app_start.ConsultaFuncionario;
import com.example.app_start.ConsultarProduto;
import com.example.app_start.CriarFuncionario;
import com.example.app_start.CriarProduto;
import com.example.app_start.EditarFuncionario;
import com.example.app_start.EditarProduto;
import com.example.app_start.R;
import com.example.app_start.RemoverFuncionario;
import com.example.app_start.RemoverProduto;
import com.example.app_start.databinding.FragmentProductBinding;

public class ProductFragment extends Fragment implements View.OnClickListener {

    private Button button_consultar_produto;
    private Button button_criar_produto;
    private Button button_remover_produto;
    private Button button_atualizar_produto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product, container, false);

        IniciarComponentes(view);

        return view;

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_consultar_produto){
            Intent intent = new Intent(getActivity(), ConsultarProduto.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_adicionar_produto) {
            Intent intent = new Intent(getActivity(), CriarProduto.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_remover_produto) {
            Intent intent = new Intent(getActivity(), RemoverProduto.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_editar_produto) {
            Intent intent = new Intent(getActivity(), EditarProduto.class);
            startActivity(intent);
        }
    }

    public void IniciarComponentes(View view){
        button_consultar_produto = view.findViewById(R.id.btn_consultar_produto);
        button_criar_produto = view.findViewById(R.id.btn_adicionar_produto);
        button_remover_produto = view.findViewById(R.id.btn_remover_produto);
        button_atualizar_produto = view.findViewById(R.id.btn_editar_produto);

        button_consultar_produto.setOnClickListener(this);
        button_criar_produto.setOnClickListener(this);
        button_remover_produto.setOnClickListener(this);
        button_atualizar_produto.setOnClickListener(this);
    }
}