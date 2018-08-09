
package br.com.study.controller;

import br.com.study.dao.EstadoDao;
import br.com.study.model.Estado;
import br.com.study.util.FacesMessages;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EstadoController {
    @Inject
    private EstadoDao dao;
    @Inject
    private FacesMessages message;
    private Estado estado;
    private List<Estado> estados;

    public EstadoController() {
        this.estado = new Estado();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public EstadoDao getDao() {
        return dao;
    }

    public void setDao(EstadoDao dao) {
        this.dao = dao;
    }
    
    
    
    public void salvar() {
        System.out.println("Salvar");
        dao.salvar(estado);
        message.error("Salvar ...");
        estado = new Estado();
    }
    
    
    
    
    
}
