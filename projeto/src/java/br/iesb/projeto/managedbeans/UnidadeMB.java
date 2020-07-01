package br.iesb.projeto.managedbeans;

import br.iesb.projeto.dao.UnidadeDAO;
import br.iesb.projeto.entitybeans.Unidade;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "unidadeMB")
@RequestScoped
public class UnidadeMB implements Serializable {

    private Unidade unidade;
    private UnidadeDAO dao;
    private List<Unidade> lista;

    public UnidadeMB() {
        this.unidade = new Unidade();
        this.dao = new UnidadeDAO();
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public List<Unidade> getLista() {
        if (lista == null) {            
            lista = dao.findAll();
        }
        return lista;
    }

    public void setLista(List<Unidade> lista) {
        this.lista = lista;
    }
            
    public String criar() {
        this.unidade = new Unidade();
        return "/pages/unidades/criar";
    }
    
    public String editar(Unidade unidade) {
        this.unidade = unidade;
        return "/pages/unidades/criar";
    }
    
    public String remover(Unidade unidade) {
        dao.remove(unidade);
        return "/pages/unidades/listar?faces-redirect=true";
    }
    
    public String salvar(Unidade unidade) {
        if (unidade.getId() == null) {
            dao.create(unidade);
        } else {
            dao.edit(unidade);
        }
        return "/pages/unidades/listar?faces-redirect=true";
    }

}
