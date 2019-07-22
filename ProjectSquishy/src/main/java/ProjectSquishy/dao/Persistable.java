package ProjectSquishy.dao;

public interface Persistable<T> {
	long getId();
	void update(T updateType);
	
}
