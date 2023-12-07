package com.example.app_start.ui.funcionario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_start.R;
import com.example.app_start.ui.funcionario.model.FuncionarioModel;

import java.util.ArrayList;

public class FuncionarioRVAdapter extends RecyclerView.Adapter<FuncionarioRVAdapter.ViewHolder> {

    private ArrayList<FuncionarioModel> funcionarioModelArrayList;
    private Context context;

    public FuncionarioRVAdapter(ArrayList<FuncionarioModel> funcionarioModelArrayList, Context context) {
        this.funcionarioModelArrayList = funcionarioModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public FuncionarioRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.funcionario_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuncionarioRVAdapter.ViewHolder holder, int position) {
        FuncionarioModel funcionarioModel = funcionarioModelArrayList.get(position);
        holder.funcionario_nome.setText("Nome: " + funcionarioModel.getNome_usuario());
        holder.funcionario_cargo.setText("Cargo: " + funcionarioModel.getCargo());
        holder.codigo_funcionario.setText("Código: " + funcionarioModel.getId_usuario().toString());
    }

    @Override
    public int getItemCount() {
        return funcionarioModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView funcionario_nome;
        private TextView funcionario_cargo;
        private TextView codigo_funcionario;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            funcionario_nome = itemView.findViewById(R.id.idFuncionarioNome);
            funcionario_cargo = itemView.findViewById(R.id.idFuncionarioCargo);
            codigo_funcionario = itemView.findViewById(R.id.idCodigoFuncionario);
        }

    }

}
