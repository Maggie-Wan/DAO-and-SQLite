package com.example.student.DAOandSQLite;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by student on 2017/10/18.
 */

public class Test1 {
    //一定要加@Test，說明是在測試
    @Test
    public void myTest()
    {
        //assert如果是false，就會中斷
        //assertEquals，當兩個參數的值相等就代表測試成功
        assertEquals(10, MyMath.add(3,7));
    }

}
