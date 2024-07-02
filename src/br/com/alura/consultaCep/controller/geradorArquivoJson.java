package br.com.alura.consultaCep.controller;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.consultaCep.model.Cep;

public class geradorArquivoJson {
  public void criarJson(Cep cep) throws IOException {
    Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();
    // File json = new File(null)
    FileWriter escrita = new FileWriter(cep.cep() + ".json");
    escrita.write(gson.toJson(cep));
    escrita.close();
  }
}
