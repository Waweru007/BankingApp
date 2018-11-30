package com.example.root.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Db extends SQLiteOpenHelper {

    Context context;
    String TAG="MY_DB_OPS";

    public Db(Context context) {
        super(context, "bank.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE IF NOT EXISTS accounts(id INTEGER PRIMARY KEY, name TEXT NOT NULL, acc_num TEXT NOT NULL, balance REAL NOT NULL)";
    db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql= "DROP TABLE IF EXISTS accounts";
        db.execSQL(sql);


    }

    public void insert (String name, String number, double balance){
        ContentValues values= new ContentValues();
        values.put("name", name);
        values.put("acc_num", number);
        values.put("balance", balance);
        getWritableDatabase().insert("accounts", null, values);
    }


    public void update (int id, String name, double balance){
        ContentValues values= new ContentValues();
        values.put("name", name);
        values.put("balance", balance);
        getWritableDatabase().update("accounts", values, "id=" +id, null);
    }

    public int count_records(){
        String sql=("select COUNT(name) from accounts");
        Cursor c = getReadableDatabase().rawQuery(sql,null);

        if (c.moveToFirst()){
            return c.getInt(0);
        }

        return 0;
    }

    public void fetch (){
        String sql=("select * from accounts");
        Cursor c = getReadableDatabase().rawQuery(sql,null);
        while (c.moveToNext()){
            Log.d(TAG, "" + c.getInt(0));
            Log.d(TAG, "" + c.getString(1));
            Log.d(TAG, "" + c.getString(2));
            Log.d(TAG, "" + c.getString(3));
            Log.d(TAG, "-------------------------------------");
        }


        ///a fxn to delete(getWritable database,1 record, all records


    }

    public Account fetchAccount (String acc_no){
        String sql=("select * from accounts where acc_num ='" + acc_no+"'");
        Cursor c = getReadableDatabase().rawQuery(sql,null);

        Account x=new Account();
        while (c.moveToNext()){

            x.setId(c.getInt(0));
            x.setName(c.getString(1));
            x.setBalance(c.getDouble(3));
            x.setAccNo(c.getString(2));

            Log.d(TAG, "" + c.getInt(0));
            Log.d(TAG, "" + c.getString(1));
            Log.d(TAG, "" + c.getString(2));
            Log.d(TAG, "" + c.getString(3));
            Log.d(TAG, "-------------------------------------");

        }

        return x;


        ///a fxn to delete(getWritable database,1 record, all records


    }


    public void delete1 (String acc_num) {
        int x=getWritableDatabase().delete("accounts","acc_num='"+acc_num+"'", null);
        Log.d(TAG, "delete1: "+x);
  }

  public void deleteAll (){
      int x=  getWritableDatabase().delete("accounts","1", null);
      Log.d(TAG, "delete1: "+x);
  }

}
