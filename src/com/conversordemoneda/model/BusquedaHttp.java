package com.conversordemoneda.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BusquedaHttp {

public Moneda moneda ( String tipoMoneda1, String tipoMoneda2){

    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d2104d2999c050a36e9ca444/pair/" + tipoMoneda1 + "/" + tipoMoneda2  );
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
            .uri(direccion)
            .build();

    HttpResponse<String> response = null;
    try {
        response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Este es el response :" + response);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    return new Gson().fromJson(response.body(), Moneda.class);



}
}
