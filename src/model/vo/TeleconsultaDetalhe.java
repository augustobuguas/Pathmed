package model.vo; // Verifique se este é o pacote correto: model.vo

import java.time.LocalDateTime;

public class TeleconsultaDetalhe {

    // --- Atributos (Campos para o Relatório) ---

    private Integer idConsulta;
    private LocalDateTime dataHoraConsulta;

    private String nomePaciente;
    private String nomeProfissional; // O campo que estava faltando o Getter/Setter
    private String nomeStatus;

    // --- Construtor Vazio ---
    public TeleconsultaDetalhe() {
    }

    // --- Getters e Setters ---

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    // Campo detalhado: PACIENTE
    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    // Campo detalhado: PROFISSIONAL (Onde estava o erro de "cannot resolve method")
    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    // Campo detalhado: STATUS
    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }
}
