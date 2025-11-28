package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The class Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    GerenciamentoVotacao gerenciador = new GerenciamentoVotacao();
    Scanner scan = new Scanner(System.in);

    int opcao;

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");

      opcao = scan.nextInt();
      scan.nextLine();

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata: ");
        String nomeCandidato = scan.nextLine();

        System.out.println("Entre com o número da pessoa candidata: ");
        int numero = Integer.parseInt(scan.nextLine());

        gerenciador.cadastrarPessoaCandidata(nomeCandidato, numero);

      }

    } while (opcao != 2);
    {
      System.out.println();
    }

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      opcao = scan.nextInt();
      scan.nextLine();

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitor = scan.next();

        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.nextLine();
        scan.nextLine();

        gerenciador.cadastrarPessoaEleitora(nomeEleitor, cpf);
      }

    } while (opcao != 2);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      opcao = Integer.parseInt(scan.nextLine());

      switch (opcao) {
        case 1:
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpf = scan.nextLine();

          System.out.println("Entre com o número da pessoa candidata:");
          int numero = Integer.parseInt(scan.nextLine());

          gerenciador.votar(cpf, numero);

          break;

        case 2:

        case 3:
          gerenciador.mostrarResultado();

          break;

        default:
      }

    } while (opcao != 3);
  }
}
