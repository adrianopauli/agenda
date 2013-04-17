/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.agendamento;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Agenda;

@ManagedBean
@RequestScoped
public class agendaBean implements Serializable{

    private Agenda agenda;

    public agendaBean() {
        agenda = new Agenda();
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
