package com.example.tienda;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelperDos extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelperDos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table usuario(id integer primary key autoincrement not null,"+
                " correo text not null, contrasenna text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
   db.execSQL("create table usuario(id integer primary key autoincrement not null,"+
           " correo text not null, contrasenna text not null)");
    }
}
