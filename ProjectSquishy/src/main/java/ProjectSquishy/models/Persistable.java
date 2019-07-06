package ProjectSquishy.models;

public interface Persistable<T> {
	long getControlSettingsId();
	void update(T updateType);
	
}
