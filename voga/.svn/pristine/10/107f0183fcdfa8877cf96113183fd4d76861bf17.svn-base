package model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_age_status")
public class Processo implements Serializable  {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="codigo_processo")
    private long codigo;
    
	@ManyToOne
	@JoinColumn(name = "codigo_agendamento")
	private Agenda agenda;
	
	@ManyToOne
	@JoinColumn(name = "codigo_status")
	private Status status;

	@Column(name = "age_data")
	@Temporal(TemporalType.DATE)
	private Calendar data;

	@Column(name = "age_hora")
	@Temporal(TemporalType.TIME)
	private Calendar hora;

	@ManyToOne
	@JoinColumn(name = "func_codigo")
	private Funcionario funcionario;

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
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
        final Processo other = (Processo) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
        
}
