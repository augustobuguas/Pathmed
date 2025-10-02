package model;

import java.time.LocalDateTime; // Para mapear DATA_HORA_CONSULTA (DATE/TIMESTAMP)
import java.time.format.DateTimeFormatter;

public class Teleconsulta {

    // --- Atributos (Espelham as colunas da TB_PATHMED_TELECONSULTA) ---

    private Integer idConsulta;        // P (INTEGER)
    private Integer idPaciente;        // F (INTEGER)
    private Integer idProfissional;    // F (INTEGER)
    private Integer idStatus;          // F (INTEGER)
    private LocalDateTime dataHoraConsulta; // DATE (Usamos LocalDateTime para Data e Hora)

    // --- Construtor Vazio ---
    public Teleconsulta() {
    }

    // --- Getters e Setters (Essenciais para o DAO) ---

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Integer idProfissional) {
        this.idProfissional = idProfissional;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    @Override
    public String toString() {
        return "Consulta ID: " + idConsulta +
                " | Paciente ID: " + idPaciente +
                " | Profissional ID: " + idProfissional +
                " | Status ID: " + idStatus +
                " | Data/Hora: " + (dataHoraConsulta != null ? dataHoraConsulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : "N/A");
    }
}
