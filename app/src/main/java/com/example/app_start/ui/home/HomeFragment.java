package com.example.app_start.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.app_start.LoginStart;
import com.example.app_start.R;
import com.example.app_start.databinding.FragmentHomeBinding;
import com.example.app_start.ui.funcionario.Operations.ConsultaFuncionario;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding binding;

    private Button btn_sair;

    private Intent intent;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        IniciarComponentes(view);

        return view;

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_log_out){
            startActivity(intent);
        }
    }

    public void IniciarComponentes(View view){
        btn_sair = view.findViewById(R.id.btn_log_out);
        btn_sair.setOnClickListener(this);
        intent = new Intent(getActivity(), LoginStart.class);
    }

}