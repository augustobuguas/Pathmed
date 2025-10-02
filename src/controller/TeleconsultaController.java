package controller;

import model.vo.TeleconsultaDetalhe;
import model.dao.TeleconsultaDAO;
import java.util.List;

public class TeleconsultaController {

    private final TeleconsultaDAO teleconsultaDAO;

    public TeleconsultaController() {
        this.teleconsultaDAO = new TeleconsultaDAO();
    }

    public List<TeleconsultaDetalhe> listarTodasDetalhado() { // Novo método
        return teleconsultaDAO.findAllDetalhado();
    }
}
