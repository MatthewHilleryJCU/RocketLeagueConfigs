package ProjectSquishy.models;

import javax.persistence.*;
import java.util.List;

public class GenericDao<T extends Persistable<T>> {

	private EntityManagerFactory emf;
	private Class<T> clazz; 

	public GenericDao(EntityManagerFactory emf, Class<T> clazz) {
		this.emf = emf;
		this.clazz = clazz; 
	}

	public void add(T type) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(type);
		cleanUp(manager, transaction);

	}

	public void remove(int id) { 
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		T found = manager.find(clazz, id);
		transaction.begin();
		manager.remove(found); 
		cleanUp(manager, transaction);

	}

	public void update(T updateType) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		T databaseType = manager.find(clazz, updateType.getControlSettingsId());
		transaction.begin();  
		databaseType.update(updateType);
		cleanUp(manager, transaction); 

	}

	public T get(int id) {
		EntityManager manager = emf.createEntityManager();
		T found = manager.find(clazz, id);

		manager.close();
		return found;
 
	}

	public List<T> getAll() {
		String tableName = clazz.getAnnotation(Table.class).name();
		EntityManager manager = emf.createEntityManager();
		TypedQuery<T> query = manager.createQuery("SELECT e FROM " + tableName + " e", clazz);
		List<T> result = query.getResultList();
		manager.close(); 

		return result;

	}
	public List<T> getAllSearch(String searchRequest) {
		String tableName = clazz.getAnnotation(Table.class).name();
		EntityManager manager = emf.createEntityManager();
		TypedQuery<T> query = manager.createQuery("SELECT e FROM " + tableName + " e WHERE e.PLAYER_NAME LIKE :search", clazz).setParameter(":search", searchRequest);
		List<T> result = query.getResultList();
		manager.close(); 
		
		return result;
		
	}

	private void cleanUp(EntityManager manager, EntityTransaction transaction) {
		transaction.commit();
		manager.close();
	}
}
