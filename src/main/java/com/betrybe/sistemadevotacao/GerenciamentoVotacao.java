package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  List<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  List<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  List<String> cpfsComputados = new ArrayList<>();


  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {

    boolean numeroJaCadastrado = pessoasCandidatas.stream()
        .anyMatch(n -> n.getNumero() == numero);

    if (numeroJaCadastrado) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata novoNumero = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(novoNumero);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {

    boolean pessoaJaCadastrada = pessoasEleitoras.stream()
        .anyMatch(p -> p.getCpf().equals(cpf));

    if (pessoaJaCadastrada) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novaPessoaEleitora);
    }

  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

    boolean pessoaJaVotou = cpfsComputados.contains(cpfPessoaEleitora);

    if (pessoaJaVotou) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      cpfsComputados.add(cpfPessoaEleitora);
    }

  }

  @Override
  public void mostrarResultado() {

    boolean jaTemVotos = pessoasCandidatas.stream()
        .anyMatch(v -> v.getVotos() > 0);

    if (!jaTemVotos) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {

    }

  }
}
