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
//    @Test
//    public void clearAndAddOneDataAndGetTest()
//    {
//        Context appContext = InstrumentationRegistry.getTargetContext();
//        phoneDAODBImpl dao = new phoneDAODBImpl(appContext);
//        phone p = new phone();
//        p.name = "BBB";
//        p.tel = "123";
//        p.addr = "aabb";
//        //清除資料後再新增一筆測試，確保資料庫正確
//        dao.clearAll();
//        dao.addOne(p);
//        //取得資料庫的資料放到陣列中
//        phone pArray[] = dao.getList();
//        //取得第一筆資料中的name來測試
//        assertEquals("BBB", pArray[0].name);
//
//    }
}

