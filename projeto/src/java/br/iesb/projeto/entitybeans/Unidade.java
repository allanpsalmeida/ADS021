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
@Table(name = "unidades")
@NamedQueries({
    @NamedQuery(name = "Unidade.findAll", query = "SELECT u FROM Unidade u")
    , @NamedQuery(name = "Unidade.findById", query = "SELECT u FROM Unidade u WHERE u.id = :id")
    , @NamedQuery(name = "Unidade.findByNome", query = "SELECT u FROM Unidade u WHERE u.nomeUnidade = :nomeUnidade")
    , @NamedQuery(name = "Unidade.findBySigla", query = "SELECT u FROM Unidade u WHERE u.siglaUnidade = :siglaUnidade")})
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nomeUnidade")
    private String nomeUnidade;
    @Basic(optional = false)
    @Column(name = "siglaUnidade")
    private String siglaUnidade;

    public Unidade() {
    }

    public Unidade(Integer id) {
        this.id = id;
    }

    public Unidade(Integer id, String nomeUnidade, String siglaUnidade) {
        this.id = id;
        this.nomeUnidade = nomeUnidade;
        this.siglaUnidade = siglaUnidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nomeUnidade;
    }

    public void setNome(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String getSiglaUnidade() {
        return siglaUnidade;
    }

    public void setSiglaUnidade(String siglaUnidade) {
        this.siglaUnidade = DatatypeConverter.printHexBinary(siglaUnidade.getBytes()).toUpperCase();
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
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.iesb.projeto.entitybeans.Unidade[ id=" + id + " ]";
    }

}
