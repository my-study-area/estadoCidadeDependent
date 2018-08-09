package br.com.study.dao;

import br.com.study.model.Cidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CidadeDao {
    
    @PersistenceContext(unitName = "deletePU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void salvar(Cidade cidade) {
        this.em.persist(cidade);
    }

    
    public List<Cidade> listar() {
        Query query = this.em.createQuery("from cidade c");
        List<Cidade> cidades = query.getResultList();
        return cidades;
    }      
    
    public List<Cidade> listarCidadePorEstado(Integer id) {
        Query query = this.em.createQuery("select c from cidade c where c.estado.id = :estado");
        query.setParameter("estado", id);
        List<Cidade> cidades = query.getResultList();
        
        return cidades;
    }      
}
