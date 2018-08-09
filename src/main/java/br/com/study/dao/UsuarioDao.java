package br.com.study.dao;

import br.com.study.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsuarioDao {

    @PersistenceContext(unitName = "deletePU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void salvar(Usuario usuario) {
        this.em.persist(usuario);
    }

    public void deletar(Usuario usuario) throws Exception {
        em.remove(em.merge(usuario));
    }
    
    
    public void atualizar(Usuario usuario) throws Exception {
        Usuario usuarioModificado = em.find(Usuario.class, usuario.getId());
        usuarioModificado.setNome(usuario.getNome());
        em.merge(usuario);
    }

    public List<Usuario> listar() {
        Query query = this.em.createQuery("from usuario e");
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }

}
