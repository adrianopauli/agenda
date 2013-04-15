/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.convert;

import controller.dao.db.Connection;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import model.Funcionario;

/**
 *
 * @author Adriano
 */
@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConvert implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            EntityManager banco = Connection.getConnection();
            Funcionario funcionario = banco.find(Funcionario.class, Long.valueOf(id));
            return funcionario;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o instanceof Funcionario){
            Funcionario funcionario = (Funcionario) o;
            return ""+funcionario.getCodigo();
        }
        return "0";
    }
}
