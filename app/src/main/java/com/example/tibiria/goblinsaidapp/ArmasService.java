package com.example.tibiria.goblinsaidapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArmasService {
    @GET("consulta_armas.php")
    Call<List<Armas>> getArmas();

}
