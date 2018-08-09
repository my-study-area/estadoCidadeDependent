package br.com.study.controller;

import br.com.study.model.Estado;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TesteController {
    
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public void salvar() {
        System.out.println("Salvar");
    }
    
}
