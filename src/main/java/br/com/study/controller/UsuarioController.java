package br.com.study.controller;

import br.com.study.dao.CidadeDao;
import br.com.study.dao.EstadoDao;
import br.com.study.dao.UsuarioDao;
import br.com.study.model.Cidade;
import br.com.study.model.Estado;
import br.com.study.model.Usuario;
import br.com.study.util.FacesMessages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
    private Usuario usuario;
    private List<Cidade> cidades;
    private List<Estado> estados;
    @Inject
    private CidadeDao cidadeDao;
    @Inject
    private UsuarioDao usuarioDao;
    @Inject
    private EstadoDao estadoDao;
    @Inject
    private FacesMessages message;

    public UsuarioController() {
        usuario = new Usuario();
    }

    @PostConstruct
    public void init() {
        estados = estadoDao.listar();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    

    public void carregarCidades() {
        this.cidades = new ArrayList<>();
        Integer idDoEstado = this.usuario.getCidade().getEstado().getId();
        this.cidades = cidadeDao.listarCidadePorEstado(idDoEstado);
    }

    public void salvar() {
        if (usuario.getId() == null) {
            usuarioDao.salvar(usuario);
            usuario = new Usuario();
            carregarCidades();
            message.error("salvo com sucesso!");
        } else {
            try {
                usuarioDao.atualizar(usuario);
                usuario = new Usuario();
                carregarCidades();
                message.error("Atualizado com sucesso!");
            } catch (Exception ex) {
                message.error("erro ao atualizar");
            }
        }
    }

    public void deletar(ActionEvent evento) {
        usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
        try {
            usuarioDao.deletar(usuario);
            usuario = new Usuario();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editar(ActionEvent evento) {
        usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
        carregarCidades();
    }
}
