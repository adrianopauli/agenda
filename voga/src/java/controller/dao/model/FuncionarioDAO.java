package controller.dao.model;

import controller.dao.db.GenericDAOImplementacao;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Funcionario> selectAtivo(){
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            funcionarios = entityManager.createQuery("SELECT f FROM Funcionario f where "
                    + "f.ativo = :ativo and f.admin = :admin")
                    .setParameter("ativo", true)
                    .setParameter("admin", false)
                    .getResultList();
        } catch (Exception e) {
        e.printStackTrace();}
        return funcionarios;
    }
    
    public List<Funcionario> selectAtivoByName(String name){
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            funcionarios = entityManager.createQuery("SELECT f FROM Funcionario f where "
                    + " f.name like :name and f.ativo = :ativo and f.admin = :admin")
                    .setParameter("name", "%"+name+"%")
                    .setParameter("ativo", true)
                    .setParameter("admin", false)
                    .getResultList();
        } catch (Exception e) {}
        return funcionarios;
    }
}
