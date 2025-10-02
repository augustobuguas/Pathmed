package model.dao;

import model.Paciente;
import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PacienteDAO {

    public void save(Paciente paciente) {

        // SQL: INSERT que lista todas as colunas, EXCETO a chave primária ID_PACIENTE
        String sql = "INSERT INTO TB_PATHMED_PACIENTE (" +
                "identificador_rghc, cpf_paciente, nome_paciente, data_nascimento, tipo_sanguineo) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"ID_PACIENTE"})) {

            stmt.setString(1, paciente.getIdentificadorRghc());
            stmt.setString(2, paciente.getCpfPaciente());
            stmt.setString(3, paciente.getNomePaciente());

            if (paciente.getDataNascimento() != null) {
                stmt.setDate(4, java.sql.Date.valueOf(paciente.getDataNascimento()));
            } else {
                stmt.setNull(4, java.sql.Types.DATE);
            }

            stmt.setString(5, paciente.getTipoSanguineo());

            // 3. Executa a inserção
            stmt.executeUpdate();

            // Opcional: Para bancos com Auto-Increment, você deve capturar o ID gerado
            // e setá-lo no objeto Paciente. (Como discutido anteriormente)
            try (java.sql.ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    paciente.setIdPaciente(generatedKeys.getInt(1));
                }
            }

            System.out.println("Paciente " + paciente.getNomePaciente() + " inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar paciente no banco de dados.");
            e.printStackTrace();
        }
    }
}