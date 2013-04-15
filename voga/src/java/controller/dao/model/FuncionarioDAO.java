package controller.dao.model;

import controller.dao.db.GenericDAOImplementacao;
import model.Funcionario;

public class FuncionarioDAO extends GenericDAOImplementacao<Funcionario> {

    public FuncionarioDAO(Class<Funcionario> clazz) {
        super(clazz);
    }

    public Funcionario selectLogin(String login, String senha) {
        Funcionario f = null;
        try {
            f = (Funcionario) entityManager.createQuery("SELECT f FROM Funcionario f where "
                    + " f.login = :login AND f.senha = :senha AND f.admin = :admin")
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .setParameter("admin", true)
                    .getSingleResult();
        } catch (Exception e) {
        }
        return f;
    }

    public Funcionario selectByLogin(String login) {
        Funcionario f = null;
        try {
            f = (Funcionario) entityManager.createQuery("SELECT f FROM Funcionario f where "
                    + "f.func_login = :login")
                    .setParameter("login", login)
                    .getSingleResult();
            
        } catch (Exception e) {
        }
        return f;
    }
}
