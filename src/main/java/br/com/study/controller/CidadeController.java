
package br.com.study.controller;

import br.com.study.dao.CidadeDao;
import br.com.study.model.Cidade;
import br.com.study.util.FacesMessages;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CidadeController {
    @Inject
    private CidadeDao dao;
    @Inject
    private FacesMessages message;
    private Cidade cidade;
    private List<Cidade> cidades;

    public CidadeController() {
        this.cidade = new Cidade();
        this.cidades = new ArrayList<>();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public CidadeDao getDao() {
        return dao;
    }

    public void setDao(CidadeDao dao) {
        this.dao = dao;
    }
    
    
    
    public void salvar() {
        System.out.println("Salvar" + cidade);
        dao.salvar(cidade);
        message.error("Salvar ..." + cidade);
        cidade = new Cidade();
    }
    
    
    
    
    
}
