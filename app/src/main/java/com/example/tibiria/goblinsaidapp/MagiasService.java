package com.example.tibiria.goblinsaidapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MagiasService {
    @GET("lista_magias.php")
    Call<List<Magias>> getMagias();

    // no POST deve-se colocar o nome do WebService PHP que irá receber os dados
    // cada campo do WS de inclusão deve ser indicado no Field
}