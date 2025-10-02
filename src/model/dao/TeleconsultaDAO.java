package model.dao;

import model.vo.TeleconsultaDetalhe;
import util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class TeleconsultaDAO {

    public List<TeleconsultaDetalhe> findAllDetalhado() {
        List<TeleconsultaDetalhe> consultas = new ArrayList<>();

        // SQL: Usando JOIN para trazer os nomes (Renomeamos as colunas para evitar conflitos)
        String sql = "SELECT " +
                "    T.id_consulta, " +
                "    T.data_hora_consulta, " +
                "    P.nome_paciente, " +
                "    PR.nome_profissional_saude, " +
                "    S.DESCRICAO_STATUS AS nome_status " +
                "FROM " +
                "    TB_PATHMED_TELECONSULTA T " +
                "INNER JOIN TB_PATHMED_PACIENTE P ON T.id_paciente = P.id_paciente " +
                "INNER JOIN TB_PATHMED_PROFISSIONAL_SAUDE PR ON T.id_profissional = PR.id_profissional " +
                "INNER JOIN TB_PATHMED_STATUS_CONSULTA S ON T.id_status = S.id_status";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TeleconsultaDetalhe detalhe = new TeleconsultaDetalhe();
                detalhe.setIdConsulta(rs.getInt("id_consulta"));

                // Mapeia os nomes
                detalhe.setNomePaciente(rs.getString("nome_paciente"));
                detalhe.setNomeProfissional(rs.getString("nome_profissional_saude"));
                detalhe.setNomeStatus(rs.getString("nome_status"));

                // Conversão de Data/Hora
                java.sql.Timestamp dataHora = rs.getTimestamp("data_hora_consulta");
                if (dataHora != null) {
                    detalhe.setDataHoraConsulta(dataHora.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime());
                }

                consultas.add(detalhe);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar teleconsultas detalhadas no banco de dados.");
            e.printStackTrace();
        }
        return consultas;
    }
}
