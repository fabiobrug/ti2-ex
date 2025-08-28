package maven.demo;

import java.util.Scanner;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        usersDAO dao = new usersDAO();
        Scanner sc = new Scanner(System.in);
        int opcao;
        Random rand = new Random();
        int numInt = rand.nextInt(10000);

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar usuários");
            System.out.println("2 - Inserir usuário");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Excluir usuário");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("\n-- Lista de usuários --");
                    dao.listar().forEach(System.out::println);
                    break;

                case 2:
                    System.out.println("\n-- Inserir usuário --");
                    System.out.print("Login: ");
                    String login = sc.nextLine();
                    System.out.print("Senha: ");
                    String pass = sc.nextLine();
                    System.out.print("Gênero (M/F): ");
                    char gender = sc.nextLine().charAt(0);

                    users novo = new users(numInt, login, pass, gender);
                    dao.inserir(novo);
                    System.out.println("Usuário inserido!");
                    break;

                case 3:
                    System.out.println("\n-- Atualizar usuário --");
                    System.out.print("ID (code) do usuário: ");
                    int codeUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo login: ");
                    String newLogin = sc.nextLine();
                    System.out.print("Nova senha: ");
                    String newPass = sc.nextLine();
                    System.out.print("Novo gênero (M/F): ");
                    char newGender = sc.nextLine().charAt(0);

                    users atualizado = new users(codeUpdate, newLogin, newPass, newGender);
                    dao.atualizar(atualizado);
                    System.out.println("Usuário atualizado!");
                    break;

                case 4:
                    System.out.println("\n-- Excluir usuário --");
                    System.out.print("ID (code) do usuário: ");
                    int codeDelete = sc.nextInt();
                    sc.nextLine();

                    dao.excluir(codeDelete);
                    System.out.println("Usuário excluído!");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}
