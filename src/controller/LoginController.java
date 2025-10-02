package controller;

import model.Login;
import model.dao.LoginDAO;

public class LoginController {

    private final LoginDAO loginDAO;

    public LoginController() {
        this.loginDAO = new LoginDAO();
    }

    public Login validarLogin(String usuario, String senha) {
        // O DAO busca o login. Se for nulo, a validação falhou.
        return loginDAO.findLogin(usuario, senha);
    }
}