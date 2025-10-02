package view;

import controller.LoginController;
import model.vo.Login;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MainView {

    private final Scanner scanner;
    private final LoginController loginController;

    public MainView() {
        this.scanner = new Scanner(System.in);
        this.loginController = new LoginController();
    }

    public void exibirMenuLogin() {
        int opcao;

        do {
            System.out.println("\n >>> Bem-vindo ao PathMed <<<");
            System.out.println("=============================");
            System.out.println("1. Entrar");
            System.out.println("2. Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Digite um número.");
                scanner.nextLine();
                opcao = 0;
            }

            switch(opcao) {
                case 1:
                    processarLogin();
                    break;
                case 2:
                    System.out.println("Obrigado por usar o PathMed. Encerrando sistema.");
                    break;
                default:
                    if (opcao != 2) System.out.println("Opção não reconhecida.");
            }

        } while (opcao != 2);
    }

    private void processarLogin() {
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // 1. Chama o Controller para tentar o login
        Login login = loginController.realizarLogin(usuario, senha);

        if (login != null) {
            System.out.println("Login realizado com sucesso! Bem-vindo(a)!");

            // 2. Redirecionamento baseado no Tipo de Usuário
            String tipoUsuario = login.getTipoUsuario();

            if ("COLABORADOR".equals(tipoUsuario)) {
                System.out.println("Você logou como: COLABORADOR");
                System.out.println(">>> Carregando Menu do Colaborador...");
                ColaboradorView colaboradorView = new ColaboradorView();
                colaboradorView.exibirMenu();

            } else if ("PACIENTE".equals(tipoUsuario)) {
                System.out.println("Você logou como: PACIENTE");
                System.out.println(">>> Carregando Menu do Paciente...");

                // CRIA A PACIENTEVIEW PASSANDO O ID DO PACIENTE LOGADO
                PacienteView pacienteView = new PacienteView(login.getIdPaciente());
                pacienteView.exibirMenu();

            } else {
                System.err.println("Tipo de usuário (" + tipoUsuario + ") desconhecido ou sem permissão.");
            }
        } else {
            System.err.println("Falha no login. Verifique o usuário e senha.");
        }
    }
}