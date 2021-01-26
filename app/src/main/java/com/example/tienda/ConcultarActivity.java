package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConcultarActivity extends AppCompatActivity {
    private EditText nom, codi,descri,numP,preci;
    Button consu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concultar);

        codi= (EditText)findViewById(R.id.codigo111);
        nom= (EditText)findViewById(R.id.nombre111);
        preci= (EditText)findViewById(R.id.precio111);
        descri= (EditText)findViewById(R.id.descripcion111);
        numP= (EditText)findViewById(R.id.numeroP111);
        consu = (Button)findViewById(R.id.Agregar111) ;


        consu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper
                        (ConcultarActivity.this,"administracion",null,1);
                SQLiteDatabase BaseDeDatos = adm .getWritableDatabase();
                String codig = codi.getText().toString();


                if(!codig.isEmpty() ){
                    Cursor fila = BaseDeDatos.rawQuery
                         ("select nombre, precio, descripcion, numeroP from articulos where codigo ="+codig,null);
                    if(fila.moveToFirst()){
                        nom.setText(fila.getString(0));
                        preci.setText(fila.getString(1));
                        descri.setText(fila.getString(2));
                        numP.setText(fila.getString(3));
                        BaseDeDatos.close();
                    }else{
                        Toast.makeText(ConcultarActivity.this, "El producto no existe", Toast.LENGTH_SHORT).show();
                        BaseDeDatos.close();
                    }
                }else{
                    Toast.makeText(ConcultarActivity.this, "Debes llenar el campo código", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}