package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The class Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  /**
   * The Pessoas candidatas.
   */
  ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  /**
   * The Pessoas eleitoras.
   */
  ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  /**
   * The Cpfs computados.
   */
  ArrayList<String> cpfsComputados = new ArrayList<>();


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

      Optional<PessoaCandidata> candidato = pessoasCandidatas.stream()
          .filter(n -> n.getNumero() == numeroPessoaCandidata)
          .findAny();

      candidato.ifPresent(PessoaCandidata::receberVoto);

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

      int totalDeVotos = pessoasCandidatas.stream()
          .mapToInt(PessoaCandidata::getVotos)
          .sum();

      for (PessoaCandidata candidato : pessoasCandidatas) {

        int percentual = Math.round(candidato.getVotos() * 100 / totalDeVotos);
        System.out.printf("Nome: %s - %d votos ( %d )", candidato.getNome(), candidato.getVotos(),
            percentual);
        System.out.println();

      }

      System.out.println("Total de votos: " + totalDeVotos);

    }
  }
}
