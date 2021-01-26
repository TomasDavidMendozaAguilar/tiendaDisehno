package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class agregarActivity extends AppCompatActivity {
private EditText nom, codi,descri,numP,preci;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        codi= (EditText)findViewById(R.id.codigo11);
        nom= (EditText)findViewById(R.id.nombre11);
        preci= (EditText)findViewById(R.id.precio11);
        descri= (EditText)findViewById(R.id.descripcion11);
        numP= (EditText)findViewById(R.id.numeroP11);
        agregar = (Button)findViewById(R.id.Agregar11) ;




        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper(agregarActivity.this,"administracion",null,1);
                SQLiteDatabase BaseDeDatos = adm .getWritableDatabase();
                String codig = codi.getText().toString();
                String descricio = descri.getText().toString();
                String nomb = nom.getText().toString();
                String numpiez = numP.getText().toString();
                String precioo= preci.getText().toString();


                if(!codig.isEmpty() && !descricio.isEmpty() && !nomb.isEmpty() && !numpiez.isEmpty()
                && !precioo.isEmpty()){
                    ContentValues registro = new ContentValues();
                    registro.put("codigo",codig);
                    registro.put("nombre",nomb);
                    registro.put("precio",precioo);
                    registro.put("descripcion",descricio);
                    registro.put("numeroP",numpiez);

                    BaseDeDatos.insert("articulos",null,registro);
                    BaseDeDatos.close();


                   codi.setText("");
                    descri.setText("");
                    nom.setText("");
                    numP.setText("");
                    preci.setText("");
                    Toast.makeText(agregarActivity.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(agregarActivity.this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
           }
        });
    }

}