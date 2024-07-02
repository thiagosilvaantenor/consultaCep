package br.com.alura.consultaCep.view;

import java.io.IOException;
import java.util.Scanner;

import br.com.alura.consultaCep.controller.consultaCepController;
import br.com.alura.consultaCep.controller.geradorArquivoJson;
import br.com.alura.consultaCep.model.Cep;

public class consultaCep {
  public static void main(String[] args) {
    consultaCepController consulta = new consultaCepController();
    geradorArquivoJson json = new geradorArquivoJson();
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ola, informe o cep a ser buscado");
    String cep = entrada.next();

    try {
      Cep cepEncontrado = consulta.consultar(cep);
      json.criarJson(cepEncontrado);
    } catch (Exception e) {
      System.err.println(e.getMessage());
      System.err.println("Nao foi possivel obter um endereco apartir deste cep");
    }
    System.err.println("Cep consultado, arquivo com as informacoes criado com sucesso");

  }
}
