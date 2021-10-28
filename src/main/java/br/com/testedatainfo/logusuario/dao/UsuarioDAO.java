package br.com.testedatainfo.logusuario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.testedatainfo.logusuario.entidade.Usuario;

public class UsuarioDAO {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
    private EntityManager em = factory.createEntityManager();
    
    public Usuario getUsuario(String email, String senha) {

        try {
          Usuario usuario = (Usuario) em
           .createQuery("SELECT u from Usuario u where u.email = :email and u.senha = :senha")
           .setParameter("email", email)
           .setParameter("senha", senha).getSingleResult();

          return usuario;
        } catch (NoResultException e) {
              return null;
        }
    }
	
	public boolean inserirUsuario(Usuario usuario) {
          try {
        	  em.getTransaction().begin();
              em.merge(usuario);
              em.getTransaction().commit();
              return true;
          } catch (Exception e) {
              e.printStackTrace();
              return false;
          }
    }

    public boolean deletarUsuario(Usuario usuario) {
          try {
        	  em.getTransaction().begin();
              em.remove(usuario);
              em.getTransaction().commit();
              return true;
          } catch (Exception e) {
              e.printStackTrace();
              return false;
          }
    }
    
    @SuppressWarnings("unchecked")
    public List<Usuario> consultarTodos() {
    	 return em.createNativeQuery("SELECT * FROM Usuario", Usuario.class).getResultList();
    }
    
    public Usuario consultarPorId(Long id) {
    	return em.find(Usuario.class, id);
    }
}
