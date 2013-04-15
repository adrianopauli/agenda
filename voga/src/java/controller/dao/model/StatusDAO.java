package controller.dao.model;

import controller.dao.db.GenericDAOImplementacao;
import model.Status;

public class StatusDAO extends GenericDAOImplementacao<Status> {

    public StatusDAO(Class<Status> clazz) {
        super(clazz);
    }

    public Status selectByColor(String color) {
        Status s = null;
        try {
            s = (Status) entityManager.createQuery("SELECT s FROM Status s where "
                    + " s.color = :color")
                    .setParameter("color", color)
                    .getSingleResult();
        } catch (Exception e) {}
        return s;
    }
}
