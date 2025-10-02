package controller;

import model.Paciente;
import model.dao.PacienteDAO;
// import java.util.List; // Não necessário agora, mas será para Listar

public class PacienteController {

    private final PacienteDAO pacienteDAO;

    public PacienteController() {
        this.pacienteDAO = new PacienteDAO();
    }

    public void adicionar(Paciente paciente) {
        // Lógica de validação pode vir aqui (ex: checar se CPF já existe)

        // Chamada ao DAO para persistência
        pacienteDAO.save(paciente);
    }
    
}