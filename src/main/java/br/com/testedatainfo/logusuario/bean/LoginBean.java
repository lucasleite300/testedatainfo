package br.com.testedatainfo.logusuario.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.testedatainfo.logusuario.dao.UsuarioDAO;
import br.com.testedatainfo.logusuario.entidade.Usuario;

@ViewScoped
@ManagedBean(name = "loginBean")
public class LoginBean {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String envia() {

		usuario = usuarioDAO.getUsuario(usuario.getEmail(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!","Erro no Login!"));
			return null;
		} else {
			return "/paginainicial";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
