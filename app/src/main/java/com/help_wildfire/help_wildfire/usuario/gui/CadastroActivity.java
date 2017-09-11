package com.help_wildfire.help_wildfire.usuario.gui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.help_wildfire.help_wildfire.R;
import com.help_wildfire.help_wildfire.usuario.gui.dao.UsuarioDAO;
import com.help_wildfire.help_wildfire.usuario.gui.dominio.Usuario;
import com.help_wildfire.help_wildfire.usuario.gui.negocio.UsuarioNegocio;
import com.help_wildfire.help_wildfire.usuario.gui.util.Mensagem;

public class CadastroActivity extends AppCompatActivity {
    private EditText edtNome, edtLogin, edtSenha, edtEmail;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private int idusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        edtNome = (EditText) findViewById(R.id.usuario_edtNome);
        edtLogin = (EditText) findViewById(R.id.usuario_edtLogin);
        edtSenha = (EditText) findViewById(R.id.usuario_edtSenha);
        edtEmail = (EditText) findViewById(R.id.usuario_edtEmail);
    }

    public void salvar(View view) {

        boolean validacao = true;
        String nome = edtNome.getText().toString();
        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();
        String email = edtEmail.getText().toString();

        if (nome == null || nome.equals("")) {
            validacao = false;
            edtNome.setError(getString(R.string.campo_obrigatorio));
        }
        if (login == null || login.equals("")) {
            validacao = false;
            edtLogin.setError(getString(R.string.campo_obrigatorio));
        }
        if (senha == null || senha.equals("") || senha.length() < 6) {
            validacao = false;
            edtSenha.setError(getString(R.string.campo_obrigatorio));
        }
        if (email == null || email.equals("") || senha.length() < 6) {
            validacao = false;
            edtEmail.setError(getString(R.string.campo_obrigatorio));
        }
        if (validacao) {
            usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setSenha(senha);
            usuario.setEmail(email);
            fazerCadastro(nome, login, senha, email);
        }
    }

    public void fazerCadastro(String nome,String login,String senha, String email){
        Context context = getApplicationContext();
        Usuario usuario = new Usuario(nome,login,senha);
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio(context,usuario);

        if((usuarioNegocio.retornarUsuarioLogin(usuario))){
            usuarioNegocio.cadastro(usuario);
            Mensagem.Msg(this, getString(R.string.mensagem_cadastro));
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        else{
            Mensagem.Msg(this, getString(R.string.mensagem_erro));
        }
    }

    public void onBackPressed(){
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void cancelar(View view){
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
