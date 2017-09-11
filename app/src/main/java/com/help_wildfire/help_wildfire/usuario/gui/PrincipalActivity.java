package com.help_wildfire.help_wildfire.usuario.gui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.help_wildfire.help_wildfire.R;
import com.help_wildfire.help_wildfire.usuario.gui.dominio.Usuario;

public class PrincipalActivity extends AppCompatActivity {
    private static final String MANTER_CONECTADO = "manter_conectado";
    private static final String PREFERENCE_NAME = "LoginActivityPreferences";
    private Usuario usuario = new Usuario() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void onBackPressed(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor     = sharedPreferences.edit();
        editor.putBoolean(MANTER_CONECTADO, false);
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        editor.clear();
        editor.commit();
        startActivity(intent);
        finish();
    }
}
