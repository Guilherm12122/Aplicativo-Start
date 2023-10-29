package com.example.app_start.ui.funcionario;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app_start.R;
import com.example.app_start.databinding.FragmentFuncionarioBinding;
import com.google.android.material.snackbar.Snackbar;

public class FuncionarioFragment extends Fragment implements View.OnClickListener {

    private FragmentFuncionarioBinding binding = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_funcionario, container, false);

        Button upButton = view.findViewById(R.id.btn_consultar_funcionario);
        upButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_consultar_funcionario){
            Snackbar snackbar = Snackbar.make(v, "Pressionou o botão", Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();
        }
    }
}