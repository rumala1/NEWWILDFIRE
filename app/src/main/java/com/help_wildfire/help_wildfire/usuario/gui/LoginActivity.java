package com.help_wildfire.help_wildfire.usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.help_wildfire.help_wildfire.R;
import com.help_wildfire.help_wildfire.usuario.gui.CadastroActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void cadastrar(View view){
        Intent intent = new Intent();
        intent.setClass(this, CadastroActivity.class);
        startActivity(intent);
        finish();
    }
}
