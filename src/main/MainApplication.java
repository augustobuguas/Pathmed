package main;

import view.MainView;

public class MainApplication {
    public static void main(String[] args) {
        // Inicia a aplicação chamando o menu de login da View
        MainView mainView = new MainView();
        mainView.exibirMenuLogin();
    }
}
