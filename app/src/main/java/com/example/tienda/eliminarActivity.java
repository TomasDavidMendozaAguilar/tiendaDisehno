package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class eliminarActivity extends AppCompatActivity {
    private EditText  codi;
    Button eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        codi= (EditText)findViewById(R.id.codigo1111);
       eliminar = (Button)findViewById(R.id.Eliminar1111) ;

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper(eliminarActivity.this,"administracion",null,1);
                SQLiteDatabase BaseDeDatos = adm .getWritableDatabase();
                String codig = codi.getText().toString();


                if(!codig.isEmpty() ){
                    int cantidad = BaseDeDatos.delete("articulos","codigo="+codig,null);


                        BaseDeDatos.close();


                        if(cantidad==1) {
                            codi.setText("");
                            Toast.makeText(eliminarActivity.this, "Eliminado con exito", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(eliminarActivity.this, "No se encontro el producto", Toast.LENGTH_SHORT).show();
                        }



                }else{
                    Toast.makeText(eliminarActivity.this, "Debes llenar el campo código", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}