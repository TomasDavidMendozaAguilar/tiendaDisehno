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

public class modificarActivity extends AppCompatActivity {
    private EditText nom, codi,descri,numP,preci;
    Button modificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        codi= (EditText)findViewById(R.id.codigo0);
        nom= (EditText)findViewById(R.id.nombre0);
        preci= (EditText)findViewById(R.id.precio0);
        descri= (EditText)findViewById(R.id.descripcion0);
        numP= (EditText)findViewById(R.id.numeroP0);
        modificar = (Button)findViewById(R.id.modificar0) ;


        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper(modificarActivity.this,"administracion",null,1);
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

                    int cantidad = BaseDeDatos.update
                            ("articulos",registro,"codigo="+codig,null);
                    BaseDeDatos.close();

                    if(cantidad==1){
                        Toast.makeText(modificarActivity.this, "Actualizado", Toast.LENGTH_SHORT).show();

                        codi.setText("");
                        descri.setText("");
                        nom.setText("");
                        numP.setText("");
                        preci.setText("");
                    }else{
                        Toast.makeText(modificarActivity.this, "No se encontro codigo", Toast.LENGTH_SHORT).show();

                        descri.setText("");
                        nom.setText("");
                        numP.setText("");
                        preci.setText("");
                    }

                }else{
                    Toast.makeText(modificarActivity.this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}