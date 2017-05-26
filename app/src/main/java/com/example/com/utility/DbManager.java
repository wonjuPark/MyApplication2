package com.example.com.utility;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by 95016056 on 2017-05-26.
 */

public class DbManager  extends SQLiteOpenHelper {
    private Context context;
    //private SQLiteDatabase sqliteDB = null;


    public DbManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE TEST(NO INTEGER, NAME TEXT)");
        db.execSQL("CREATE TABLE TEST1(NO INTEGER, NAME TEXT, USEYN INTEGER)");

        db.execSQL("INSERT INTO TEST (NO, NAME)  VALUES (1, '내비선택');");
        db.execSQL("INSERT INTO TEST (NO, NAME) VALUES (2, 'API Key 세팅');");

        db.execSQL("INSERT INTO TEST1 (NO, NAME, USEYN) VALUES (1, 'T MAP', 1);");
        db.execSQL("INSERT INTO TEST1 (NO, NAME, USEYN) VALUES (2, 'KAKAO NAVI', 0);");
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "버전이 올라갔습니다.", Toast.LENGTH_SHORT).show();
    }

}
