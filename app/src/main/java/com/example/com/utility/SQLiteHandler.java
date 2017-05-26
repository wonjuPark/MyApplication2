package com.example.com.utility;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 95016056 on 2017-05-26.
 */

public class SQLiteHandler {
    private DbManager manager;
    private SQLiteDatabase db;

    public SQLiteHandler(Context context){
        manager = new DbManager(context, "GPS.db", null, 1);
    }

    //open
    public static SQLiteHandler open(Context context) {
        return new SQLiteHandler(context);
    }
    //close
    public void close() {
        db.close();
    }

    public Cursor select(String query) {
        db = manager.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        return c;
    }//end select

}
