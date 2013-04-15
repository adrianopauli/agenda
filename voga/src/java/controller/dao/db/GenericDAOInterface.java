package controller.dao.db;

import java.util.List;

/**
 *
 * @author Adriano
 * Interface genérica que serve para o CRUD de todos os objetos. E possue um metodo extra
 * que retorna uma lista de objetos.
 */
public interface GenericDAOInterface<T> {
    
    public boolean save(T t);
    
    public boolean delete(T t);
    
    public Object select(long id);
     
    public List<T> selectAll();
     
}
