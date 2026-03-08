package exercicio2.app;

import exercicio2.DAO.AlunoDAO;
import exercicio2.model.Aluno;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AlunoDAO dao = new AlunoDAO();
        int op;

        do {
            System.out.println("\n1-Listar  2-Inserir  3-Excluir  4-Atualizar  5-Sair");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                dao.listar().forEach(System.out::println);
            }

            if (op == 2) {
                System.out.print("Codigo: ");
                int codigo = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Idade: ");
                int idade = sc.nextInt();
                sc.nextLine();

                System.out.print("Curso: ");
                String curso = sc.nextLine();

                dao.inserir(new Aluno(codigo, nome, idade, curso));
            }

            if (op == 3) {
                System.out.print("Codigo: ");
                int codigo = sc.nextInt();
                dao.excluir(codigo);
            }

            if (op == 4) {
                System.out.print("Codigo: ");
                int codigo = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Idade: ");
                int idade = sc.nextInt();
                sc.nextLine();

                System.out.print("Curso: ");
                String curso = sc.nextLine();

                dao.atualizar(new Aluno(codigo, nome, idade, curso));
            }

        } while (op != 5);

        sc.close();
    }
}