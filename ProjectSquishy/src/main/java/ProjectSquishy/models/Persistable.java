package ProjectSquishy.models;

public interface Persistable<T> {
	int getId();
	void update(T updateType);
	
}
