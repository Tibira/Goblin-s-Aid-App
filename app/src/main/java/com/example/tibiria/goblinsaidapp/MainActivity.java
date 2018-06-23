package com.example.tibiria.goblinsaidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spnSelecao;
    private Button btnShow;
    private ListView lvListagem;
    private List<com.example.sdf.goblinsaidapp.Magias> magias;
    private List<com.example.sdf.goblinsaidapp.Armas> armas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnSelecao = (Spinner) findViewById(R.id.spnSelecao);
        btnShow = (Button) findViewById(R.id.btnShow);
        lvListagem = (ListView) findViewById(R.id.lvListagem);

        btnShow.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item);

        adapter.add("Magias");
        adapter.add("Armas");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/goblins_aid/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
}
    @Override
    public void onClick(View view) {
        String local = spnSelecao.getSelectedItem().toString();
    }
}
