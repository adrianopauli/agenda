package view.admin.cadastros;

import controller.dao.model.StatusDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Status;
import view.interfaces.BeanInteface;

@ManagedBean
@RequestScoped
public class statusBean implements BeanInteface<Status> {

    private Status status;
    private StatusDAO dao = new StatusDAO(Status.class);

    public statusBean() {
        status = new Status();
    }

    @Override
    public String novo() {
        status = new Status();
        return "adm.cadastro.status";
    }

    @Override
    public String submit() {
        FacesContext ct = FacesContext.getCurrentInstance();
        boolean validator = true;
        if (status.getColor().isEmpty()) {
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cor inválida!", ""));
            validator = false;
        }
        Status s = dao.selectByColor(status.getColor());
        if(s != null && status.getCodigo()!= s.getCodigo()){
            ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cor já cadastrada", ""));
            validator = false;
        }
        if (validator){
            if(dao.save(status))
                ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", ""));
            else
                ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ""));
            return "adm.listar.status";
        }
        return "";
    }

    @Override
    public String edit() {
        return "adm.cadastro.status";
    }

    @Override
    public String delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Status> getAll() {
        return dao.selectAll();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
