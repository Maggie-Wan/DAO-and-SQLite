package com.example.student.DAOandSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

//名稱取名為phoneDAO在DB上的實作(可以套用到雲端、檔案....)
public class phoneDAODBImpl implements phoneDAO {
    SQLiteDatabase db;
    MyHelper helper;

    //因為在建立db時要取得mainactivity，所以要加一個建構是在new的時候可以把mainactivity傳進來
    public phoneDAODBImpl(Context context) {
        helper=new MyHelper(context);
        db=helper.getWritableDatabase();
    }
    //刪除
    @Override
    public void clearAll()
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        //刪除的語法要用delete from phone，把整個table刪掉
        db.execSQL("delete from phone");
        db.close();
    }

    @Override
    public phone[] getList() {
        SQLiteDatabase db = helper.getWritableDatabase();
        //建一個phone型別的arraylist
        ArrayList<phone> mylist = new ArrayList();
        //這邊因為要取全部的資料所以不要用where
        Cursor c = db.query("phone", new String[] {"id","name","tel","addr"}, null, null, null, null, null);
        if (c.moveToFirst())
        {
            do {
                phone p = new phone();
                p.id = c.getInt(0);
                p.name = c.getString(1);
                p.tel = c.getString(2);
                p.addr = c.getString(3);
                //把p的資料加到mylist中
                mylist.add(p);
            }while(c.moveToNext());
        }
        //把arraylist轉成array，而且要把這個和mylist資料長度一樣的array轉成phone型別
        phone rValue[] = mylist.toArray(new phone[mylist.size()]);
        return rValue;
    }

    @Override
    public void addOne(phone p) {
        db=helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //寫入時，每個欄位資料都去對應phone 物件的各個field
        cv.put("name",p.name);
        cv.put("tel",p.tel);
        cv.put("addr",p.addr);
        cv.put("email",p.email);
        cv.put("tel2",p.tel2);
        db.insert("phone", null, cv);
        db.close();
    }

    @Override
    public phone getOne(int id) {
        //要再取得一次database，因為如果先做addOne會把db關閉，這邊要再取得一次
        db=helper.getWritableDatabase();
        phone p=new  phone();
        //因為會帶入一個int id的參數，這邊第三第四個參數也要設定，先在第三個參數設定要如何篩選資料
        // 第四個參數是把丟進來的int id轉成字串陣列的第一筆資料再丟給id(參數3)去篩選，這樣就會找到那一筆id的資料
        Cursor c = db.query("phone",new String[] {"id","name","tel","addr","email","tel2"}, "id=?", new String[] {String.valueOf(id)}, null, null, null);
        c.moveToFirst();
        //設定在讀取時，phone class的每個field會去抓哪個欄位的資料
        p.id=c.getInt(0);
        p.name = c.getString(1);
        p.tel = c.getString(2);
        p.addr = c.getString(3);
        p.email=c.getString(4);
        p.tel2=c.getString(5);
        db.close();
        return p;
    }

    @Override
    public void delete(phone p) {
        SQLiteDatabase db=helper.getWritableDatabase();
//第二個參數是where clause，第三個參數是指定要刪除的那筆資料id
        db.delete("phone","id=?",new String[] {String.valueOf(p.id)});
        db.close();
    }

    @Override
    public void update(phone p) {
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",p.name);
        cv.put("tel",p.tel);
        cv.put("addr",p.addr);
        cv.put("email",p.email);
        cv.put("tel2",p.tel2);
// 第二個參數要更新的資料
//第三個參數是要用甚麼篩選，第四個參數是要更新哪一筆資料
        db.update("phone",cv,"id=?",new String[] {String.valueOf(p.id)});
        db.close();
    }
}
