package com.example.com.myapplication;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ListMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.com.utility.DbManager;
import com.example.com.utility.MeunList;
import com.example.com.utility.SQLiteHandler;

/**
 * Created by 95016056 on 2017-05-24.
 */

public class SettingActivity extends AppCompatActivity {


    private ArrayList<String> arrayMenu = new ArrayList<String>();
    DbManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_main);
        manager = new DbManager(this, "GPS.db", null, 1);
        setArrayMenu();

        ListView listMenu = (ListView) this.findViewById(R.id.menulist);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayMenu);
        listMenu.setAdapter(adapter);

        listMenu.setOnItemClickListener(listener);

    }

    /* 메뉴 클릭 이벤트 */
    OnItemClickListener listener= new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // 메뉴 선택별 Popup 메뉴 변경
            switch(position){
                case 0:
                    setNavigation();
                    break;
                case 1:
                    setApiKey();
                    break;
                default:
                    Toast.makeText(SettingActivity.this, arrayMenu.get(position), Toast.LENGTH_SHORT).show();
            }
        }
    };


    /* 네비 선택 */
    private void setNavigation(){
        String items[] = {};
        int i = 0;
        SQLiteDatabase db = manager.getWritableDatabase();
        Cursor cs = db.rawQuery("SELECT NO, NAME FROM TEST1", null);

        try{
            items = new String[cs.getCount()];
            while(cs.moveToNext()){
                items[i++] = cs.getString(1);
            }
        }catch(SQLiteException ex){
            ex.printStackTrace();
        }finally {
            cs.close();
            db.close();
        }

        AlertDialog.Builder ab = new AlertDialog.Builder(SettingActivity.this);
        ab.setTitle("네비선택");
        ab.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton){
            }
        }).setPositiveButton("선택", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton){
                //Toast.makeText(SettingActivity.this, String.valueOf(dialog.), Toast.LENGTH_LONG).show();
            }

        }).setNegativeButton("취소",  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        ab.show();
    }

    /* 네비 API  Key 등록 */
    private void setApiKey(){
        AlertDialog.Builder ab = new AlertDialog.Builder(SettingActivity.this);
        ab.setTitle("API Key 등록");
        ab.setMessage("XXXXX");

        final EditText et = new EditText(SettingActivity.this);
        ab.setView(et);
        ab.setPositiveButton("등록", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton){
                //Toast.makeText(SettingActivity.this, String.valueOf(dialog.), Toast.LENGTH_LONG).show();
            }

        }).setNegativeButton("취소",  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });

        ab.show();
    }

    /* 메뉴 항목 생성 */
    private void setArrayMenu(){
        SQLiteDatabase db = manager.getWritableDatabase();
        Cursor cs = db.rawQuery("SELECT NO, NAME FROM TEST", null);
        try {
            while (cs.moveToNext()) {
                arrayMenu.add(cs.getString(1));
            }
        }catch(SQLiteException ex){
            ex.printStackTrace();
        }finally {
            cs.close();
            db.close();
        }

    }
}

