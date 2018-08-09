package br.com.study.dao;

import br.com.study.model.Estado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EstadoDao {
    
    @PersistenceContext(unitName = "deletePU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void salvar(Estado estado) {
        this.em.persist(estado);
    }
    
    public List<Estado> listar() {
        Query query = this.em.createQuery("from estado e");
        List<Estado> listaGrupoRedes = query.getResultList();
        return listaGrupoRedes;
    }      
    
}
