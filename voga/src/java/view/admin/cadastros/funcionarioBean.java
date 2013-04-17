/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.admin.cadastros;

import controller.dao.model.FuncionarioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Funcionario;
import org.primefaces.context.RequestContext;
import view.interfaces.BeanInteface;

/**
 * @author Lucas
 */
@ManagedBean
@RequestScoped
public class funcionarioBean implements BeanInteface<Funcionario> {

    private Funcionario funcionario;
    private FuncionarioDAO DAOfuncionario = new FuncionarioDAO(Funcionario.class);
    private String confirmacaoSenha;

    public funcionarioBean() {
        funcionario = new Funcionario();
        confirmacaoSenha = "";
    }

    @Override
    public String novo() {
        funcionario = new Funcionario();
        confirmacaoSenha = "";
        return "adm.cadastro.funcionario";
    }

    @Override
    public String submit() {
        FacesContext ct = FacesContext.getCurrentInstance();
        boolean validacao = true;

        //Validação do nome
        if (funcionario.getName().isEmpty() || funcionario.getName().length() < 4) {
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome inválido!", ""));
            validacao = false;
        }
        //Validação do login
        if (funcionario.getLogin().isEmpty() || funcionario.getLogin().length() < 4) {
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido!", ""));
            validacao = false;
        }
        if (funcionario.getCodigo() == 0) {
            //Validação de login eguais
            Funcionario f = DAOfuncionario.selectByLogin(funcionario.getLogin());
            if (f != null) {
                ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário já existe!", ""));
                validacao = false;
            }

            validacao = validarSenha(ct);
        } else {
            System.out.println("senha" + funcionario.getSenha());
            if (funcionario.getSenha() != null) {
                validacao = validarSenha(ct);
            } else {
                //setar a senha antiga se ela está nulla
                Funcionario fsenha = DAOfuncionario.selectByCodigo(funcionario.getCodigo());
                if (funcionario.getSenha() == null) {
                    funcionario.setSenha(fsenha.getSenha());
                }
            }

            //verificação de login iguais
            Funcionario f = DAOfuncionario.selectByLogin(funcionario.getLogin());
            if (f != null) {
                if (f.getCodigo() != funcionario.getCodigo()) {
                    ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login já existe!", ""));
                    validacao = false;
                } else {
                    funcionario.setSenha(f.getSenha());
                }
            }
        }
        if (validacao) {
            if (DAOfuncionario.save(funcionario)) {
                ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", ""));
                return "adm.listar.funcionario";
            } else {
                ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ""));
            }
        }
        return "";
    }

    @Override
    public String edit() {
        return "";
    }

    @Override
    public String delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> getAll() {
        return DAOfuncionario.selectAll();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }

    protected boolean validarSenha(FacesContext ct) {
        boolean validacao = true;
        //Validação da senha 
        if (funcionario.getSenha().isEmpty() || funcionario.getSenha().length() < 4) {
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha inválida!", ""));
            validacao = false;
        }

        //validação da confirmação da senha
        if (!(funcionario.getSenha().equals(confirmacaoSenha))) {
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas Diferentes!", ""));
            validacao = false;
        }
        return validacao;
    }

    public void validarSenha(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        boolean loggedIn = validarSenha(FacesContext.getCurrentInstance());
        if (loggedIn) {
            if (DAOfuncionario.save(funcionario)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ""));
            }
        }
        context.addCallbackParam("loggedIn", loggedIn);
    }
}