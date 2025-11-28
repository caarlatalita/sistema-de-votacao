package com.betrybe.sistemadevotacao;

public class PessoaEleitora extends Pessoa {

  public PessoaEleitora(String nome, String cpf) {
    this.cpf = cpf;
    super.setNome(nome);
  }

  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
