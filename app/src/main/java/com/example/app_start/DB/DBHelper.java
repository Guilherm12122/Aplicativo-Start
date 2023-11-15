package com.example.app_start.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Start.db";

    public DBHelper(Context context) {
        super(context, "Start.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table validacao(id_usuario integer primary key autoincrement, nome_usuario TEXT, senha TEXT)");
        MyDB.execSQL("create table funcionario( id_funcionario integer primary key autoincrement, nome text, cargo text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS validacao");
        MyDB.execSQL("DROP TABLE IF EXISTS funcionario");
    }


    public Boolean insertData(String nome_usuario, String senha, String cargo){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        ContentValues contentValues1 = new ContentValues();
        ContentValues contentValues2 = new ContentValues();


        contentValues1.put("nome_usuario", nome_usuario);
        contentValues1.put("senha", senha);

        contentValues2.put("nome", nome_usuario);
        contentValues2.put("cargo", cargo);

        long result1 = MyDB.insert("validacao", null, contentValues1);
        long result2 = MyDB.insert("funcionario", null, contentValues2);


        if (result1 == -1 || result2 == -1){
            return false;
        } else{
            return true;
        }
    }

    public Boolean checkUserName(String nome){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("select * from validacao where nome_usuario = ?", new String[] {nome});

        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }


    public Boolean checkUser(String nome, String senha){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("select * from validacao where nome_usuario = ? and senha = ?", new String[] {nome, senha});

        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }

    }
}
