package com.example.tibiria.goblinsaidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spnSelecao;
    private Button btnShow;
    private ListView lvListagem;
    private List<Magias> magias;
    private List<Armas> armas;

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

        adapter.add("------");
        adapter.add("Magias");
        adapter.add("Armas");

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnSelecao.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/goblins_aid/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MagiasService serviceMag = retrofit.create(MagiasService.class);

        Call<List<Magias>> magias = serviceMag.getMagias();

        magias.enqueue(new Callback<List<Magias>>() {

            @Override
            public void onResponse(Call<List<Magias>> call,
                                   Response<List<Magias>> response) {
                if (response.isSuccessful()) {

                    List<Magias> lista = response.body();

                    MagiasAdapter adapter = new MagiasAdapter(
                            getApplicationContext(), lista, "http://10.0.2.2/goblins_aid/");

                    lvListagem.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Magias>> call, Throwable t) {

            }
        });

        ArmasService serviceArma = retrofit.create(ArmasService.class);

        Call<List<Armas>> armas = serviceArma.getArmas();

        armas.enqueue(new Callback<List<Armas>>() {

            @Override
            public void onResponse(Call<List<Armas>> call,
                                   Response<List<Armas>> response) {
                if (response.isSuccessful()) {

                    List<Armas> lista = response.body();

                    ArmasAdapter adapterArma = new ArmasAdapter(
                            getApplicationContext(), lista, "http://10.0.2.2/goblins_aid/");

                    lvListagem.setAdapter(adapterArma);
                }
            }

            @Override
            public void onFailure(Call<List<Armas>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {

        String local = spnSelecao.getSelectedItem().toString();
        if (view.getId() == R.id.btnShow) {
            String select = spnSelecao.getSelectedItem().toString();

            if (select.trim().isEmpty()) {
                Toast.makeText(this, "Selecione uma pesquisa", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
}
