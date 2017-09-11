package com.help_wildfire.help_wildfire.usuario.gui.dominio;

public class Usuario {
    private int _id;
    private String nome;
    private String login;
    private String senha;
    private String email;

    public Usuario(){};

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public Usuario( String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id, String nome, String login, String senha){
        this._id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id, String nome, String login, String senha, String email){
        this._id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
