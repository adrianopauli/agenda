package controller.dao.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vogaPU");

    public static EntityManager getConnection() {       
        return emf.createEntityManager();     
    }
    
    public static void limpaCache(){
    	emf.getCache().evictAll();
    }
}
