package controller.dao.db;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


/**
 * 
 * @author Adriano Classe generica que serve para o CRUD de todos os objetos. E
 *         possui um metodo extra que retorna uma lista de objetos.
 */
public abstract class GenericDAOImplementacao<T> implements GenericDAOInterface<T> {
	protected EntityManager entityManager;
	private final Class<T> clazz;
	
	public GenericDAOImplementacao(Class<T> clazz) {
		entityManager = Connection.getConnection();
		this.clazz = clazz;
	}

	@Override
	public Object select(long id) {
		entityManager.clear();
		// TODO Auto-generated method stub
		return entityManager.find(clazz, id);
	}

	@Override
	public List<T> selectAll() {
		entityManager.clear();
		return entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t").getResultList();
	}

	@Override
	public boolean save(T t) {
		EntityTransaction tra = entityManager.getTransaction();
		try {
			tra.begin();

			if (getId(t) == 0){
				entityManager.persist(t);
			}else{
				entityManager.merge(t);
			}
			tra.commit();

			return true;
		} catch (Exception e) {
			tra.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(T t) {
		 EntityTransaction tra = entityManager.getTransaction();
		try {
			tra.begin();
			entityManager.remove(entityManager.merge(t));
			tra.commit();
			return true;
		} catch (Exception e) {
			tra.rollback();
			return false;
		}
	}
	
	private long getId(T t) {
		try {
			Class c = t.getClass();
			Field f = c.getDeclaredField("codigo");
			f.setAccessible(true);
			Long id = (Long) f.get(t);
			return id;
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
