package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_agendamento")
public class Agenda implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "age_codigo")
	private long codigo;
	
	@Column(name = "age_cliente", length = 255, nullable = false)
	private String cliente;
	
	@Column(name = "age_telefone", length = 15)
	private String telefone;
	
	@Column(name = "age_celular", length = 15)
	private String celular;
	
	@Column(name = "age_data")
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Column(name = "age_horaEntrada")
	@Temporal(TemporalType.TIME)
	private Calendar horaEntrada;
	
	@Column(name = "age_horaSaida")
	@Temporal(TemporalType.TIME)
	private Calendar horaSaida;
	
	@ManyToOne
    @JoinColumn(name="func_codigo")
	private Funcionario funcionario;
	
	@OneToMany(mappedBy = "agenda", fetch = FetchType.EAGER)
	private List<Processo> processos;

	public Agenda() {
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Calendar horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Calendar getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Calendar horaSaida) {
		this.horaSaida = horaSaida;
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
        hash = 89 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
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
        final Agenda other = (Agenda) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
        
}
