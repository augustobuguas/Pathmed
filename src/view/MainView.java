package view; // ou seu pacote 'view'

import controller.LoginController;
import model.Login;
import java.util.Scanner;

public class MainView {

    private final LoginController loginController;
    private final Scanner scanner;

    public MainView() {
        this.loginController = new LoginController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuLogin() {
        System.out.println("\n >>> Bem-vindo ao PathMed <<<");
        System.out.println("================================");

        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Login loginResult = loginController.validarLogin(usuario, senha);

        if (loginResult != null) {
            System.out.println("\nLogin realizado com sucesso! Bem-vindo(a)!");

            //Chama o menu de acordo com o TIPO_USUARIO
            exibirMenuPrincipal(loginResult);
        } else {
            System.out.println("\nERRO: Usuário ou senha inválidos. Tente novamente.");
            exibirMenuLogin(); // Tenta de novo
        }
    }

    private void exibirMenuPrincipal(Login login) {
        System.out.println("\nVocê logou como: " + login.getTipoUsuario());

        if ("PACIENTE".equalsIgnoreCase(login.getTipoUsuario())) {
            System.out.println(">>> Carregando Menu do Paciente...");
            // Implementaremos a PacienteView depois
        } else if ("COLABORADOR".equalsIgnoreCase(login.getTipoUsuario())) {
            // Chamando a view do colaborador
            ColaboradorView colaboradorView = new ColaboradorView();
            colaboradorView.exibirMenu();
        }
    }
}