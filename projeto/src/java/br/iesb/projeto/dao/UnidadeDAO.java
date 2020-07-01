package br.iesb.projeto.dao;

import br.iesb.projeto.entitybeans.Unidade;
import java.io.Serializable;

public class UnidadeDAO extends AbstractDAO<Unidade> implements Serializable {
    
    public UnidadeDAO() {
        super(Unidade.class);
    }
    
}
