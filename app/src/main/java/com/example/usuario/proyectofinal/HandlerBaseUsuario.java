package com.example.usuario.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Usuario on 13/06/2017.
 */

public class HandlerBaseUsuario extends SQLiteOpenHelper {

    //Versión de la base de datos
    private static final int version =1;
    //Nombre de la base de datos
    private static final String nombre = "DBusuarios";
    //Nombre de la tabla de casos
    private static final String tabla1 = "USUARIO";
    private static SQLiteDatabase.CursorFactory factory = null;

    //Nombres de las columnas
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "u_nombre";
    private static final String KEY_MAIL ="u_email";
    private static final String KEY_PASSWORD ="u_password";
    private static final String KEY_GENDER ="u_gender";

    public HandlerBaseUsuario(Context context){
        super(context, nombre, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(this.getClass().toString(),"Creando la base de datos");
        db.execSQL( "CREATE TABLE USUARIO(" +
                " _id INTEGER AUTOINCREMENT PRIMARY KEY," +
                " u_nombre TEXT NOT NULL, " +
                " u_email TEXT, " +
                " u_password TEXT," +
                " u_gender TEXT)" );
        Log.i(this.getClass().toString(),"tabla casos creada");
        Log.i(this.getClass().toString(), "Datos iniciales HIPOTECA insertados");
        Log.i(this.getClass().toString(), "Base de datos creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USUARIO");
        onCreate(db);
    }

    public void adduSUARIO(Usuario user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEY_ID,user.getIdUsuario());
        values.put(KEY_NAME,user.getNombre());
        values.put(KEY_MAIL,user.getEmail());
        values.put(KEY_PASSWORD,user.getPassword());
        values.put(KEY_GENDER,user.getGender());
        db.insert("USUARIO",null,values);
        db.close();
    }

    public Usuario busquporNombre(String nombre){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.query(tabla1, new
                String[]{KEY_ID,KEY_NAME,KEY_MAIL,KEY_PASSWORD,KEY_GENDER}, KEY_NAME+"=?", new
                String[]{String.valueOf(nombre)},null,null,null,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Usuario user = new Usuario(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4));
        return user;
    }
}
