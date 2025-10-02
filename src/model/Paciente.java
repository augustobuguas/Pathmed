package model;

import java.time.LocalDate;

public class Paciente {

    //Atributos que Espelham as colunas da TB_PATHMED_PACIENTE

    private Integer idPaciente;          // INTEGER
    private String identificadorRghc;    // VARCHAR2(10)
    private String cpfPaciente;          // VARCHAR2(11)
    private String nomePaciente;         // VARCHAR2(150)
    private LocalDate dataNascimento;    // DATE
    private String tipoSanguineo;        // VARCHAR2(3)

    // Construtor Vazio (Necessário para a deserialização no DAO)
    public Paciente() {
    }

    // Construtor
    public Paciente(Integer idPaciente, String identificadorRghc, String cpfPaciente, String nomePaciente, LocalDate dataNascimento, String tipoSanguineo) {
        this.idPaciente = idPaciente;
        this.identificadorRghc = identificadorRghc;
        this.cpfPaciente = cpfPaciente;
        this.nomePaciente = nomePaciente;
        this.dataNascimento = dataNascimento;
        this.tipoSanguineo = tipoSanguineo;
    }

    // Getters e Setters

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdentificadorRghc() {
        return identificadorRghc;
    }

    public void setIdentificadorRghc(String identificadorRghc) {
        this.identificadorRghc = identificadorRghc;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    // --- Método toString (Útil para o método listarClientes na View) ---
    @Override
    public String toString() {
        return "ID: " + idPaciente +
                " | RGHC: " + identificadorRghc +
                " | Nome: " + nomePaciente +
                " | CPF: " + cpfPaciente;
    }
}