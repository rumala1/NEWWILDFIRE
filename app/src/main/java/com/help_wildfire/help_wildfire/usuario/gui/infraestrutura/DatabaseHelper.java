package com.help_wildfire.help_wildfire.usuario.gui.infraestrutura;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "tasks";
    private static final int VERSAO = 1;

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    public String getNome(){
        return BANCO_DADOS;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tabela de usuarios
        db.execSQL("CREATE TABLE Usuarios ( _id INTEGER PRIMARY KEY, "
                + "nome TEXT, login TEXT, senha TEXT, email TEXT)");
        //Associações
        db.execSQL("CREATE TABLE Perfis ( id INTEGER PRIMARY KEY, "
                + "usuario TEXT, perfil TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public static class Usuarios {
        public static final String TABELA = "usuarios";
        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String LOGIN = "login";
        public static final String SENHA = "senha";
        public static final String EMAIL = "email";
        public static final String[] COLUNAS = new String[]{
                _ID, NOME, LOGIN, SENHA, EMAIL
        };
    }

    public static class Perfis {
        public static final String TABELA_PERFIS = "perfis";
        public static final String ID = "id";
        public static final String ID_USUARIO = "usuario";
        public static final String ID_PERFIL = "perfil";
        public static final String[] COLUNAS_PERFIS = new String[]{
                ID, ID_USUARIO, ID_PERFIL,
        };
    }
}
