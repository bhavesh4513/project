package com.example.bam.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class datatbasehandler extends SQLiteOpenHelper {
    public static final int database_version=1;
    public static final String DataBase_name="ParentData.db";
    public static final String Table_name="Parent";
    public static final String Username="Username";
    public static final String Password="Password";
    public static final String Email_id="Email";
    public static final String col_phone="Phone";



    public datatbasehandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DataBase_name, factory, database_version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        String table_query = "CREATE TABLE " + Table_name + "(" +
               Username + " TEXT NOT NULL, " +
                Password + " TEXT  NOT NULL," + Email_id + " TEXT NOT NULL , " + col_phone + " TEXT NOT NULL "+
                ");";
        db.execSQL(table_query);

    }
    public void RegisterUser(Data data)
    {
        ContentValues vs = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        vs.put(Username, data.getUsername());
        vs.put(Password, data.getPassword());
        vs.put(Email_id,data.getEmail());
        vs.put(col_phone,data.getPhone_no());
        db.insert(Table_name, null, vs);
        db.close();
        Log.d("register","inserted data");
    }

    public String Ser(String u,String p)
    {
        SQLiteDatabase db = getWritableDatabase();
        String a,b;
        b="record not found";

        String q="SELECT * FROM " + Table_name ;
        Cursor cursor = db.rawQuery(q, null);
        if(cursor.moveToFirst())
        {
            do {
                //username stored in the cursor is checked with the passed Username
                a=cursor.getString(cursor.getColumnIndex(col_phone));

                if(a.equals(u))
                {
                    b=cursor.getString(cursor.getColumnIndex(Password));
                    break;
                }


            }
            while(cursor.moveToNext());

        }

        //password is returned of user that matched
        return b;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String t= " DROP TABLE IF EXISTS "  +  Table_name;
        db.execSQL(t);
        onCreate(db);
    }
}
