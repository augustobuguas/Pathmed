package model;

public class Login {

    // Atributos que espelham as colunas da TB_PATHMED_LOGIN

    private Integer idLogin;        // P (INTEGER)
    private Integer idPaciente;     // F (INTEGER - pode ser NULL)
    private Integer idColaborador;  // F (INTEGER - pode ser NULL)
    private String usuarioLogin;    // VARCHAR2(150)
    private String senhaLogin;      // VARCHAR2(50)
    private String tipoUsuario;     // VARCHAR2(20)

    // Construtor
    public Login() {
    }

    // Getters e Setters

    // O DAO estava procurando por setIDLogin
    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    // O DAO estava procurando por setIDPaciente
    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    // O DAO estava procurando por setIDColaborador
    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(String senhaLogin) {
        this.senhaLogin = senhaLogin;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    // Opcional: Para facilitar a impressão de resultados no console
    @Override
    public String toString() {
        return "Login{" +
                "idLogin=" + idLogin +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", usuario='" + usuarioLogin + '\'' +
                '}';
    }
}
