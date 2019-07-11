package com.example.student.DAOandSQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyHelper extends SQLiteOpenHelper {
    //本來建構式繼承有四個參數，但factory用不到就直接設定null
    //資料庫名稱和版本則會直接設定final然後把這三個參數丟到super方法中
    //這樣mainactivity要建立MyHelper物件時，就只要丟context這個參數進來就可以
    static final String DB_NAME="student.sqlite";
    static final int VERSION=4;

    public MyHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override //如果系統中沒有這個資料庫，就會跑onCreate
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //先去SQLite Manager複製create語法，這邊有個技巧事先打好雙引號再貼上語法
        //這樣會自動把需要加上反斜線的內容都加好反斜線
        //在做版本更新時，除了onUpgrade要加sql語法，onCreate也要加，因為可能有用戶是沒有舊版就直接安裝新版的
        String createSQL="CREATE TABLE \"phone\" (\"id\" INTEGER PRIMARY KEY  NOT NULL ,\"name\" VARCHAR,\"tel\" VARCHAR,\"addr\" VARCHAR DEFAULT (null) , \"email\" VARCHAR, \"tel2\" VARCHAR)";
        //sqLiteDatabase是從參數帶入的SQLiteDatabase
        sqLiteDatabase.execSQL(createSQL);
    }

    @Override //如果系統中有這個資料庫且版本不同，就會跑onUpgrade
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        Log.d("verson","verson:"+oldversion);
        //因為new這個物件時會帶入版本參數，這邊就要做版本的判斷來決定要做甚麼
        if (oldversion != 4 )
        {
            String upgradeSQL = "ALTER TABLE \"main\".\"phone\" ADD COLUMN \"tel2\" VARCHAR";
            sqLiteDatabase.execSQL(upgradeSQL);
        }
    }
}
