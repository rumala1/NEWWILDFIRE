package com.help_wildfire.help_wildfire.usuario.gui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.help_wildfire.help_wildfire.R;
import com.help_wildfire.help_wildfire.usuario.gui.dominio.Usuario;
import com.help_wildfire.help_wildfire.usuario.gui.negocio.UsuarioNegocio;
import com.help_wildfire.help_wildfire.usuario.gui.util.Mensagem;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsuario, edtSenha;
    private UsuarioNegocio usuarioNegocio;
    private CheckBox ckbConectado;
    String MANTER_CONECTADO = "manter_conectado";
    String PREFERENCE_NAME = "LoginActivityPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsuario   = (EditText) findViewById(R.id.login_edtUsuario);
        edtSenha     = (EditText) findViewById(R.id.login_edtSenha);
        ckbConectado = (CheckBox) findViewById(R.id.login_ckbConectado);
        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        boolean conectado             = preferences.getBoolean(MANTER_CONECTADO, false);
        if (conectado){
            ChamarMainActivity();
        }
    }

    public void entrar(View view){
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        boolean validacao = true;
        if(usuario == null || usuario.equals("")){
            validacao = false;
            edtUsuario.setError(getString(R.string.login_valUsuario));
        }
        if(senha== null || senha.equals("")) {
            validacao = false;
            edtSenha.setError(getString(R.string.login_valSenha));
        }
        if(validacao) {
            Usuario user = new Usuario(usuario, senha);
            Context context = getApplicationContext();
            usuarioNegocio = new UsuarioNegocio(context, user);
            if (usuarioNegocio.retornarUsuario(usuario, senha)) {
                if(ckbConectado.isChecked()){
                    SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor     = sharedPreferences.edit();
                    editor.putBoolean(MANTER_CONECTADO, true);
                    editor.putString("LOGIN",usuario);
                    editor.putString("SENHA",senha);
                    ChamarMainActivity();
                    editor.commit();
                }
                else{
                    SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor     = sharedPreferences.edit();
                    editor.putString("LOGIN",usuario);
                    editor.putString("SENHA",senha);
                    ChamarMainActivity();
                    editor.commit();
                }
            } else {
                Mensagem.Msg(this, getString(R.string.msg_login_incorreto));
            }
        }
    }

    public void cadastrar(View view){
        Intent intent = new Intent();
        intent.setClass(this, CadastroActivity.class);
        startActivity(intent);
        finish();
    }

    private void ChamarMainActivity(){
        startActivity(new Intent(this, MapsActivity.class));
        finish();
    }
}
