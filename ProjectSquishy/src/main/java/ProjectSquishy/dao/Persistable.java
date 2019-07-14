package ProjectSquishy.dao;

public interface Persistable<T> {
	long getControlSettingsId();
	void update(T updateType);
	
}
