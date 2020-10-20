package com.example.basededatos;
//Importamos la clase necesaria para hacer la BD
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//Usamos POO . nos aparece error cdo ponemos el extends porque debemos sobreescribir los metodos onCreate y onUpgrade; y tambien debemos agregar el constructor (con 4 parametros - context, name, factory y version.)
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) { //Despues del SQLiteDatabase se le puede cambiar el nombre de la BD
    //Creamos la tabla donde vamos a guardar nuestros productos
        BaseDeDatos.execSQL("create table articulos(codigo int primary key, descripcion String, precio real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
