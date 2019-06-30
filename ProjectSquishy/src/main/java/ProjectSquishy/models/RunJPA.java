package ProjectSquishy.models;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunJPA {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDBconnect");

		


		emf.close();
	}

} 
