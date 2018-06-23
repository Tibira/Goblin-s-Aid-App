package com.example.sdf.goblinsaidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ArmasAdapter extends BaseAdapter {

    Context ctx;
    List<Armas> armas;

    public ArmasAdapter(Context ctx, List<Armas> armas) {
        this.ctx = ctx;
        this.armas = armas;
    }
    @Override
    public int getCount() {
        return armas.size();
    }

    @Override
    public Object getItem(int i) {
        return armas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Armas arma = armas.get(i);

        View linha = LayoutInflater.from(ctx).inflate(R.layout.armas_item, null);

        TextView txtNome = (TextView) linha.findViewById(R.id.txtNome);
        TextView txtDesc = (TextView) linha.findViewById(R.id.txtDesc);
        TextView txtTipo = (TextView) linha.findViewById(R.id.txtTipo);
        TextView txtPreco = (TextView) linha.findViewById(R.id.txtPreco);
        TextView txtPeso = (TextView) linha.findViewById(R.id.txtPeso);
        TextView txtDano = (TextView) linha.findViewById(R.id.txtDano);

        txtNome.setText(arma.nome);
        txtDesc.setText(arma.descricao);
        txtTipo.setText(arma.tipo);
        txtPreco.setText(arma.preco);
        txtPeso.setText(arma.peso);
        txtDano.setText(arma.dano);

        return linha;
    }
}
