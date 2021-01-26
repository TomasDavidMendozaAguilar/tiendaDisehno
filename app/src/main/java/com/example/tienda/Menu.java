package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

      ImageView  c1 = (ImageView)findViewById(R.id.unoC);
      ImageView e1 = (ImageView) findViewById(R.id.unoE);
      ImageView m1 = (ImageView) findViewById(R.id.unoM);
      ImageView A1 = (ImageView) findViewById(R.id.unoA1);
        TextView u = (TextView)findViewById(R.id.cerrar);

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Menu.this,modificarActivity.class);
                startActivity(intent);

            }
        });
        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Menu.this,agregarActivity.class);
                startActivity(intent);
            }
        });


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Menu.this,ConcultarActivity.class);
                startActivity(intent);

            }
        });


        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences1.edit();
                preferences1.edit().remove("correo").commit();
                preferences1.edit().remove("contrasenna").commit();
                Intent intent = new Intent( Menu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Menu.this,eliminarActivity.class);
                startActivity(intent);

            }
        });

    }
}