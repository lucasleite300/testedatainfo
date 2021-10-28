package br.com.testedatainfo.logusuario.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.testedatainfo.logusuario.dao.UsuarioDAO;
import br.com.testedatainfo.logusuario.entidade.Usuario;

@ViewScoped
@ManagedBean(name = "listaUsuarioBean")
public class ListaUsuarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
    private List<Usuario> usuarios = new ArrayList<>();
    
    private List<Usuario> usuarioSelecionados = new ArrayList<>();

    @PostConstruct
    public void Inicializar() {
    	usuarios = usuarioDAO.consultarTodos();
    }
    
    public void excluirSelecionados() {
    	for(Usuario usuario : usuarioSelecionados) {
    		usuarioDAO.deletarUsuario(usuario);
    		usuarios.remove(usuario);
    	}
    	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuários(s) excluido(s) com sucesso!","Excluido com sucesso"));
    }

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarioSelecionados() {
		return usuarioSelecionados;
	}

	public void setUsuarioSelecionados(List<Usuario> usuarioSelecionados) {
		this.usuarioSelecionados = usuarioSelecionados;
	}
}
