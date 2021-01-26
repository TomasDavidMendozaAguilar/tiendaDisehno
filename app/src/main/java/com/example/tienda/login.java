package com.example.tienda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button iniciarSesion;
    TextView registro,olvidar;
    private EditText  contra,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        iniciarSesion = (Button) findViewById(R.id.ini1);
        registro = (TextView) findViewById(R.id.newUserRegistro);

        contra = (EditText)findViewById(R.id.pas1);
        correo = (EditText)findViewById(R.id.co1);

        SharedPreferences preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);


        if(preferences1.contains("correo")&&preferences1.contains("contrasenna")){
            Intent intent = new Intent( login.this,Menu.class);
            startActivity(intent);
            finish();
        }


       try {
            Bundle extra = getIntent().getExtras();
          final String  c = extra.getString("correo");
           final String  cp = extra.getString("contrasenna");


            if (!c.isEmpty() && !cp.isEmpty()) {
                correo.setText(c);
                contra.setText(cp);

            }

        }catch (Exception e){

        }


        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contra111 = contra.getText().toString();
                String corre111 = correo.getText().toString();

                if(contra111.length() !=0 && corre111.length() !=0){

                        try {
                            Bundle extra = getIntent().getExtras();
                            final String  c = extra.getString("correo");
                            final String  cp = extra.getString("contrasenna");
                            String contra11 = contra.getText().toString();
                            String corre11 = correo.getText().toString();



                            if(corre11.equals(c) && contra11.equals(cp) ) {

                                SharedPreferences preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences1.edit();
                                String contra1 = contra.getText().toString();
                                String corre1 = correo.getText().toString();
                                editor.putString("correo", corre1);
                                editor.putString("contrasenna", contra1);
                                editor.commit();

                                Intent intent = new Intent(login.this, Menu.class);
                                startActivity(intent);
                                finish();


                            } else {
                                Toast.makeText(login.this, "Debes registrarte", Toast.LENGTH_SHORT).show();

                            }



                        }catch (Exception e){

                        }






                }else{
                    Toast.makeText(login.this, "Llenar los campos", Toast.LENGTH_SHORT).show();


                }




            }
        });



        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( login.this,RegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


}