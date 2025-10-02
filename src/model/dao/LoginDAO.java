package model.dao;

import model.Login;
import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public Login findLogin(String usuario, String senha) {
        Login login = null;

        // Aqui no SQL: Busca o registro pelo usuário e senha na TB_PATHMED_LOGIN
        String sql = "SELECT id_login, id_paciente, id_colaborador, tipo_usuario " +
                "FROM TB_PATHMED_LOGIN " +
                "WHERE usuario_login = ? AND senha_login = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    login = new Login();


                    // 1. ID_LOGIN (obrigatório, não pode ser NULL)
                    login.setIdLogin(rs.getInt("id_login"));

                    // 2. ID_PACIENTE (pode ser NULL se id_colaborador for preenchido)
                    int idPacInt = rs.getInt("id_paciente");
                    if (!rs.wasNull()) {
                        login.setIdPaciente(idPacInt);
                    }

                    // 3. ID_COLABORADOR (pode ser NULL se id_paciente for preenchido)
                    int idColInt = rs.getInt("id_colaborador");
                    if (!rs.wasNull()) {
                        login.setIdColaborador(idColInt);
                    }

                    login.setTipoUsuario(rs.getString("tipo_usuario"));
                    login.setUsuarioLogin(usuario);
                    // Não é recomendado armazenar a senha
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao validar login ou conectar com o banco de dados.");
            e.printStackTrace();
        }
        return login;
    }
}