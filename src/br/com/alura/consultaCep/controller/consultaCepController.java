package br.com.alura.consultaCep.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.consultaCep.model.Cep;

public class consultaCepController {

  public Cep consultar(String cep) throws IOException, InterruptedException, IllegalArgumentException {
    boolean existe = validaCep(cep);
    if (existe) {
      URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      return new Gson().fromJson(response.body(), Cep.class);
    } else {
      throw new IllegalArgumentException("Cep invalido");
    }

  }

  private boolean validaCep(String cep) {
    // Para ser valido um Cep precisa ter exatamente 8 caracteries
    String[] caracteries = cep.split("");
    if (caracteries.length == 8) {
      return true;
    } else {
      return false;
    }
  }

  

}
