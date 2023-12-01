package com.example.app_start.ui.produto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_start.R;
import com.example.app_start.ui.funcionario.FuncionarioRVAdapter;
import com.example.app_start.ui.funcionario.model.FuncionarioModel;
import com.example.app_start.ui.produto.model.ProdutoModel;

import java.util.ArrayList;

public class ProdutoRVAdapter extends RecyclerView.Adapter<ProdutoRVAdapter.ViewHolder> {

    private ArrayList<ProdutoModel> produtoModelArrayList;
    private Context context;

    public ProdutoRVAdapter(ArrayList<ProdutoModel> produtoModelArrayList, Context context) {
        this.produtoModelArrayList = produtoModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProdutoRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoRVAdapter.ViewHolder holder, int position) {
        ProdutoModel produtoModel = produtoModelArrayList.get(position);
        holder.nome_produto.setText("Nome: " + produtoModel.getNome_produto());
        holder.preco.setText("Preço: " + "R$" + produtoModel.getPreco().toString());
        holder.codigo_produto.setText("Código do produto: " + produtoModel.getId_produto().toString());

    }

    @Override
    public int getItemCount() {
        return produtoModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nome_produto;
        private TextView preco;
        private TextView codigo_produto;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            nome_produto = itemView.findViewById(R.id.idProdutoNome);
            preco = itemView.findViewById(R.id.idProdutoPreco);
            codigo_produto = itemView.findViewById(R.id.idCodigoProduto);
        }

    }
}
