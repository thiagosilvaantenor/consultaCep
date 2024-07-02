package br.com.alura.consultaCep.model;

public record Cep(String cep, String logadouro, String complemento, String unidade, String bairro, String localidade,
    String uf) {

}
