package controller;

import model.ProfissionalSaude;
import model.dao.ProfissionalSaudeDAO;

public class ProfissionalSaudeController {

    private final ProfissionalSaudeDAO profissionalSaudeDAO;

    public ProfissionalSaudeController() {
        this.profissionalSaudeDAO = new ProfissionalSaudeDAO();
    }

    public void adicionar(ProfissionalSaude profissional) {
        // Validação de regras de negócio (ex: formato de email, CPF)

        // Chamada ao DAO para persistência
        profissionalSaudeDAO.save(profissional);
    }
}