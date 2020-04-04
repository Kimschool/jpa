import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.kimschool.manage.entity.User_Info;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
		EntityManager em = emf.createEntityManager();

		List<User_Info> results = em.createQuery("select u from User_Info u", User_Info.class).getResultList();

		System.out.println(results);

	}

}
