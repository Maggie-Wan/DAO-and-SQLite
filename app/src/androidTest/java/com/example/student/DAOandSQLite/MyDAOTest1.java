package com.example.student.DAOandSQLite;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

//一定要加@RunWith,代表測試
@RunWith(AndroidJUnit4.class)
public class MyDAOTest1 {
    @Test
    public void AddandGetTest(){
        //取得context就可以建立phoneDAODBImpl物件
        Context appContext = InstrumentationRegistry.getTargetContext();
        phoneDAODBImpl dao = new phoneDAODBImpl(appContext);
        phone p = new phone();
        p.name = "BBB";
        p.tel = "123";
        p.addr = "aabb";
        dao.addOne(p);
        phone p1 = dao.getOne(1);
        assertEquals("BBB",p1.name);
    }
    @Test
    public void clearAndAddOneDataAndGetTest()
    {
        Context appContext = InstrumentationRegistry.getTargetContext();
        phoneDAODBImpl dao = new phoneDAODBImpl(appContext);
        phone p = new phone();
        p.name = "BBB";
        p.tel = "123";
        p.addr = "aabb";
        //清除資料後再新增一筆測試，確保資料庫正確
        dao.clearAll();
        dao.addOne(p);
        //取得資料庫的資料放到陣列中
        phone pArray[] = dao.getList();
        //取得第一筆資料中的name來測試
        assertEquals("BBB", pArray[0].name);

    }


    //測試刪除
    @Test
    public void testDelete1(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        phoneDAODBImpl dao = new phoneDAODBImpl(appContext);
        phone p1=new phone("ccc","333","123456");
        phone p2=new phone("ddd","444","123456");
        dao.clearAll();
        dao.addOne(p1);
        dao.addOne(p2);
        phone pArray[]=dao.getList();
        //因為前面new c1時沒有給id，所以這邊設定id給c1
        p1.id=pArray[0].id;
        dao.delete(p1);
        phone pArray2[]=dao.getList();
        assertEquals("ddd",pArray2[0].name);
    }

    //測試更新
    @Test
    public void testUpdate(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        phoneDAODBImpl dao = new phoneDAODBImpl(appContext);
        phone p1=new phone("ccc","333","123456");

        dao.clearAll();
        dao.addOne(p1);
        phone parray[]=dao.getList();
        p1.id=parray[0].id;
        p1.name="fff";
        dao.update(p1);
        phone parray2[]=dao.getList();
        assertEquals("fff", parray2[0].name);
    }
}

