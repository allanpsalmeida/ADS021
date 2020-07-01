package br.iesb.projeto.dao;

import br.iesb.projeto.entitybeans.Assunto;
import java.io.Serializable;

public class AssuntoDAO extends AbstractDAO<Assunto> implements Serializable {
    
    public AssuntoDAO() {
        super(Assunto.class);
    }
    
}
