package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "func_codigo")
	private long codigo;
	
	@Column(name = "funca_nome", length = 60)
	private String name;
	
	@Column(name = "func_login", length = 15, nullable = false)
	private String login;
	
	@Column(name = "func_senha", length = 15, nullable = false)
	private String senha;
	
	@Column(name = "func_admin", nullable = false)
	private boolean admin = false;
	
	@Column(name = "func_ativo", nullable = false)
	private boolean ativo = true;
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER)
	private List<Agenda> eventos;

	@OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER)
	private List<Processo> processos;
	
	public Funcionario() {
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Agenda> getEventos() {
		return eventos;
	}

	public void setEventos(List<Agenda> eventos) {
		this.eventos = eventos;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
        
}
