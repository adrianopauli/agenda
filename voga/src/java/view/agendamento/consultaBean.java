/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.agendamento;

import controller.dao.model.FuncionarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Funcionario;

/**
 *
 * @author Lucas
 */
@ManagedBean
@RequestScoped
public class consultaBean {

    private FuncionarioDAO dao = new FuncionarioDAO(Funcionario.class);
    private Funcionario f;

    public consultaBean() {
        f = new Funcionario();
    }

    public List<Funcionario> getFuncionarios() {
        return dao.selectAtivo();
    }

    public Funcionario getF() {
        return f;
    }

    public void setF(Funcionario f) {
        this.f = f;
    }
}
