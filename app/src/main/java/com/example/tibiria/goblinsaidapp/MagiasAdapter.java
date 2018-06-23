package com.example.sdf.goblinsaidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MagiasAdapter extends BaseAdapter{
    Context ctx;
    List<Magias> magias;

    public MagiasAdapter(Context ctx, List<Magias> magias) {
        this.ctx = ctx;
        this.magias = magias;

    }

    @Override
    public int getCount() {
        return magias.size();
    }

    @Override
    public Object getItem(int i) {
        return magias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Magias magia = magias.get(i);

        View linha = LayoutInflater.from(ctx).inflate(R.layout.magias_item, null);

        TextView txtNome = (TextView) linha.findViewById(R.id.txtNome);
        TextView txtDesc = (TextView) linha.findViewById(R.id.txtDesc);
        TextView txtConj = (TextView) linha.findViewById(R.id.txtConj);
        TextView txtNivel = (TextView) linha.findViewById(R.id.txtNivel);
        TextView txtEscola = (TextView) linha.findViewById(R.id.txtEscola);
        TextView txtTempo = (TextView) linha.findViewById(R.id.txtTempo);
        TextView txtComp = (TextView) linha.findViewById(R.id.txtComp);
        TextView txtAlcance = (TextView) linha.findViewById(R.id.txtAlcance);
        TextView txtDurac = (TextView) linha.findViewById(R.id.txtDurac);

        txtNome.setText(magia.nome);
        txtDesc.setText(magia.descricao);
        txtConj.setText(magia.conjuradores);
        txtNivel.setText(magia.nivel);
        txtEscola.setText(magia.escola);
        txtTempo.setText(magia.tempo);
        txtComp.setText(magia.componentes);
        txtAlcance.setText(magia.alcance);
        txtDurac.setText(magia.duracao);

        return linha;
    }
}
