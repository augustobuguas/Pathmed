package model.dao;

import model.ProfissionalSaude;
import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfissionalSaudeDAO {

    public void save(ProfissionalSaude profissional) {

        // SQL: INSERT sem a chave primária ID_PROFISSIONAL (Auto-Increment)
        String sql = "INSERT INTO TB_PATHMED_PROFISSIONAL_SAUDE (" +
                "id_especialidade, cpf_profissional, email_corporativo_profissional, nome_profissional_saude) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             // Passamos o nome da coluna para que o Oracle retorne o ID gerado
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"ID_PROFISSIONAL"})) {

            // 1. Mapeamento dos valores
            stmt.setInt(1, profissional.getIdEspecialidade());
            stmt.setString(2, profissional.getCpfProfissional());
            stmt.setString(3, profissional.getEmailCorporativoProfissional());
            stmt.setString(4, profissional.getNomeProfissionalSaude());

            // 2. Executa a inserção
            stmt.executeUpdate();

            // 3. Captura do ID gerado
            try (java.sql.ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    profissional.setIdProfissional(generatedKeys.getInt(1));
                }
            }

            System.out.println("Profissional " + profissional.getNomeProfissionalSaude() + " inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar profissional de saúde no banco de dados.");

            // Tratamento específico para campos UNIQUE/NOT NULL
            if (e.getErrorCode() == 1) { // ORA-00001: restrição de unicidade violada
                System.err.println("ERRO: CPF ou Email Corporativo já cadastrado!");
            } else {
                e.printStackTrace();
            }
        }
    }
}
