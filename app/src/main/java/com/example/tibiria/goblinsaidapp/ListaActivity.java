package com.example.tibiria.goblinsaidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaActivity extends AppCompatActivity{
    private ListView lvListagem;
    private List<Armas> armas;
    private List<Magias> magias;
    private MagiasAdapter magadapter;
    private ArmasAdapter armadapter;
    private Spinner spnSelecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (spnSelecao.equals("Magias")) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            lvListagem = (ListView) findViewById(R.id.lvListagem);
            magias = new ArrayList<Magias>();

            String filename = "magias.txt";
            FileInputStream inputStream;

            try {
                inputStream = openFileInput(filename);
                Scanner entrada = new Scanner(inputStream);

                // enquanto houver linhas para serem lidas
                while (entrada.hasNextLine()) {
                    // lê uma linha do arquivo
                    String linha = entrada.nextLine();
                    // separa a linha pela ocorrência do ";"
                    String[] partes = linha.split(";");

                }
                // fecha o arquivo
                inputStream.close();

                magadapter = new MagiasAdapter(this,magias);

                // insere os dados no listView
                lvListagem.setAdapter(magadapter);

            } catch (Exception e) {
                Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            lvListagem = (ListView) findViewById(R.id.lvListagem);
            armas = new ArrayList<Armas>();

            String filename = "armas.txt";
            FileInputStream inputStream;

            try {
                inputStream = openFileInput(filename);
                Scanner entrada = new Scanner(inputStream);

                // enquanto houver linhas para serem lidas
                while (entrada.hasNextLine()) {
                    // lê uma linha do arquivo
                    String linha = entrada.nextLine();
                    // separa a linha pela ocorrência do ";"
                    String[] partes = linha.split(";");

                }
                // fecha o arquivo
                inputStream.close();

                armadapter = new ArmasAdapter(this, armas);

                // insere os dados no listView
                lvListagem.setAdapter(armadapter);

            } catch (Exception e) {
                Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }
}