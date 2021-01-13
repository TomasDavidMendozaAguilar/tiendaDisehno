package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class login extends AppCompatActivity {
    MaterialButton iniciarSesion;
    TextView registro,olvidar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciarSesion = (MaterialButton) findViewById(R.id.iniciarSesion);
        registro = (TextView) findViewById(R.id.newUserRegistro);
        olvidar = (TextView) findViewById(R.id.olvidasteContrasena);


        olvidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( login.this,RecuperacionActivity.class);
                startActivity(intent);

            }
        });




        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( login.this,Menu.class);
                startActivity(intent);

            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( login.this,RegistroActivity.class);
                startActivity(intent);
            }
        });


    }
}