package br.com.testedatainfo.logusuario.bean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.testedatainfo.logusuario.dao.UsuarioDAO;
import br.com.testedatainfo.logusuario.entidade.Usuario;

@ManagedBean(name="usuarioBean")
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
    private Usuario usuario = new Usuario();
     
    private Long idUsuario;

    @PostConstruct
    public void inicializar() {
    	if(idUsuario != null) {
    		usuario = usuarioDAO.consultarPorId(idUsuario);
    	}
    }
     
     public String cadastraUsuario() throws SQLException {
         usuarioDAO.inserirUsuario(usuario);
         return "paginainicial.xhtml?faces-redirect=true";
	}

     public Usuario getUsuario() {
          return usuario;
     }

     public void setUsuario(Usuario usuario) {
          this.usuario = usuario;
     }

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
}

