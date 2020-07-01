package br.iesb.projeto.managedbeans;

import br.iesb.projeto.dao.AssuntoDAO;
import br.iesb.projeto.entitybeans.Assunto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "assuntoMB")
@RequestScoped
public class AssuntoMB implements Serializable {

    private Assunto assunto;
    private AssuntoDAO dao;
    private List<Assunto> lista;

    public AssuntoMB() {
        this.assunto = new Assunto();
        this.dao = new AssuntoDAO();
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setTipoAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public List<Assunto> getLista() {
        if (lista == null) {            
            lista = dao.findAll();
        }
        return lista;
    }

    public void setLista(List<Assunto> lista) {
        this.lista = lista;
    }
            
    public String criar() {
        this.assunto = new Assunto();
        return "/pages/assuntos/criar";
    }
    
    public String editar(Assunto assunto) {
        this.assunto = assunto;
        return "/pages/assuntos/criar";
    }
    
    public String remover(Assunto assunto) {
        dao.remove(assunto);
        return "/pages/assuntos/listar?faces-redirect=true";
    }
    
    public String salvar(Assunto assunto) {
        if (assunto.getId() == null) {
            dao.create(assunto);
        } else {
            dao.edit(assunto);
        }
        return "/pages/assuntos/listar?faces-redirect=true";
    }

}
