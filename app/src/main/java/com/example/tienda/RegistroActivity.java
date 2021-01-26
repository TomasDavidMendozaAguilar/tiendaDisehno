package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
     TextView InicioLogin2;
    private EditText nom, contra,correo;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        InicioLogin2 = (TextView)findViewById(R.id.InicioLogin);
        nom = (EditText)findViewById(R.id.nombre01);
        contra = (EditText)findViewById(R.id.contrasenna01);
        correo = (EditText)findViewById(R.id.correo01);
        agregar = (Button)findViewById(R.id.RegistroUsu);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre1 = nom.getText().toString();
                String correo1 = correo.getText().toString();
                String contrasenha = contra.getText().toString();



                if(nombre1.length() != 0 && correo1.length() != 0 && contrasenha.length() != 0){
                    Intent intent = new Intent( RegistroActivity.this,login.class);

                    intent.putExtra("correo",correo1);
                    intent.putExtra("contrasenna",contrasenha);
                    startActivity(intent);
                    finish();



                    Toast.makeText(RegistroActivity.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();




                }else{
                    Toast.makeText(RegistroActivity.this, "Llenar todos los campos", Toast.LENGTH_SHORT).show();


                }





            }
        });

        InicioLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( RegistroActivity.this,login.class);
                startActivity(intent);
                finish();

            }
        });
    }
}