package controller.dao.model;

import controller.dao.db.GenericDAOImplementacao;
import model.Processo;

public class ProcessoDAO extends GenericDAOImplementacao<Processo> {

    public ProcessoDAO(Class<Processo> clazz) {
        super(clazz);
    }
}
