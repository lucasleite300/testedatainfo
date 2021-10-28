/*package teste;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.testedatainfo.logusuario.entidade.Usuario;

public class Principal {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Usuario u1 = new Usuario(null,"1","2","3");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(u1);
		em.getTransaction().commit();
		System.out.print("Pronto!");
		
		
		
	}

}*/
