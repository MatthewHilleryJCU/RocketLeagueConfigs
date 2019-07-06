package ProjectSquishy;

import ProjectSquishy.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunJPA {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlDBconnect");
		GenericDao<Player> playerDao = new GenericDao<>(emf, Player.class);



		Player player = new Player();
		DeadzoneSettings deadzoneSettings = new DeadzoneSettings();
		ControlSettings controlSettings =  new ControlSettings();
		CameraSettings cameraSettings = new CameraSettings();

		player.setControlSettings(controlSettings);
		player.setDeadzoneSettings(deadzoneSettings);
		player.setCameraSettings(cameraSettings);


		playerDao.add(player);


		emf.close();

	}
}
