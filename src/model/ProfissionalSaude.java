package model;

public class ProfissionalSaude {

    private Integer idProfissional;
    private Integer idEspecialidade; // Este é o atributo que o DAO está tentando acessar
    private String cpfProfissional;
    private String emailCorporativoProfissional;
    private String nomeProfissionalSaude;

    // Construtor Vazio
    public ProfissionalSaude() {
    }

    // --- Getters e Setters (Certifique-se de que estão escritos assim) ---

    // O método que o DAO está procurando:
    public Integer getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Integer idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    // Os outros métodos que o DAO está procurando:
    public Integer getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Integer idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getCpfProfissional() {
        return cpfProfissional;
    }

    public void setCpfProfissional(String cpfProfissional) {
        this.cpfProfissional = cpfProfissional;
    }

    public String getEmailCorporativoProfissional() {
        return emailCorporativoProfissional;
    }

    public void setEmailCorporativoProfissional(String emailCorporativoProfissional) {
        this.emailCorporativoProfissional = emailCorporativoProfissional;
    }

    public String getNomeProfissionalSaude() {
        return nomeProfissionalSaude;
    }

    public void setNomeProfissionalSaude(String nomeProfissionalSaude) {
        this.nomeProfissionalSaude = nomeProfissionalSaude;
    }

    // ... (restante da classe)
}