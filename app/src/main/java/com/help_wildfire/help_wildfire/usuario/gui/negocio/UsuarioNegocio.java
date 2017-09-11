package com.help_wildfire.help_wildfire.usuario.gui.negocio;

import android.content.Context;

import com.help_wildfire.help_wildfire.usuario.gui.dao.UsuarioDAO;
import com.help_wildfire.help_wildfire.usuario.gui.dominio.Usuario;

public class UsuarioNegocio {
    public UsuarioDAO usuarioDAO;
    public Usuario usuario;

    public UsuarioNegocio(Context context, Usuario usuario_){
        usuarioDAO = new UsuarioDAO(context,usuario_);
        usuario = usuario_;
    }

    public UsuarioNegocio(Context context){
        usuarioDAO = new UsuarioDAO(context);
    }

    public boolean retornarUsuario(String login, String senha){
        if(usuarioDAO.existeUsuario(login,senha) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public Usuario pegaUsuario(String login, String senha){
        return usuarioDAO.existeUsuario(login,senha);
    }

    public boolean retornarUsuarioLogin(Usuario usuario){
        String login = usuario.getLogin();
        Boolean retorno = usuarioDAO.buscarUsuarioPorLogin(login);
        return retorno;
    }

    public int pegarId(){
        int id = usuarioDAO.retornarId(usuario.getLogin());
        return id;
    }

    public int pegarId(String login){
        int id = usuarioDAO.retornarId(login);
        return id;
    }

    public void cadastro(Usuario usuario){
        usuarioDAO.salvarUsuario(usuario);
    }

}
