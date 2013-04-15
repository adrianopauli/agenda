/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.admin;

import controller.dao.model.FuncionarioDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Funcionario;

/**
 *
 * @author Lucas
 */
@ManagedBean
@SessionScoped
public class loginBean implements Serializable{

    private String senha;
    private String login;
    private boolean logado;

    public loginBean() {
    }

    public String getSenha() {
        return senha;
    }

    public String validaLogin() {
        FacesContext ct = FacesContext.getCurrentInstance();
        FuncionarioDAO dao = new FuncionarioDAO(Funcionario.class);
        Funcionario f = dao.selectLogin(login, senha);
        if (f != null) {
            logado = true;
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, f.getName()+" - Seja Bem Vindo", ""));
            login = "";
            senha = "";
            return "";
        } else {
            logado = false;
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acesso Negado!", ""));
            login = "";
            senha = "";
            return "";
        }
    }

    public String deslogar() {
        FacesContext ct = FacesContext.getCurrentInstance();
        login = "";
        senha = "";
        logado = false;
        ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deslogado!", ""));
        return "home.home";
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
}
