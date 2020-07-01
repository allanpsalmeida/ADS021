package br.iesb.projeto.entitybeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.DatatypeConverter;

@Entity
@Table(name = "assuntos")
@NamedQueries({
    @NamedQuery(name = "Assunto.findAll", query = "SELECT u FROM Assunto u")
    , @NamedQuery(name = "Assunto.findById", query = "SELECT u FROM Assunto u WHERE u.id = :id")
    , @NamedQuery(name = "Assunto.findByTipoAssunto", query = "SELECT u FROM Assunto u WHERE u.tipoAssunto = :tipoAssunto")
    , @NamedQuery(name = "Assunto.findBySituacao", query = "SELECT u FROM Assunto u WHERE u.situacao = :situacao")})
public class Assunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tipoAssunto")
    private String tipoAssunto;
    @Basic(optional = false)
    @Column(name = "situacao")
    private String situacao;

    public Assunto() {
    }

    public Assunto(Integer id) {
        this.id = id;
    }

    public Assunto(Integer id, String tipoAssunto, String situacao) {
        this.id = id;
        this.tipoAssunto = tipoAssunto;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoAssunto() {
        return tipoAssunto;
    }

    public void setTipoAssunto(String tipoAssunto) {
        this.tipoAssunto = tipoAssunto;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assunto)) {
            return false;
        }
        Assunto other = (Assunto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.iesb.projeto.entitybeans.Assunto[ id=" + id + " ]";
    }

}
