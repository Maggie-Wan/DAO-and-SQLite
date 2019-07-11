package com.example.student.DAOandSQLite;

//先用一個DAO定義資料庫有哪些操作(interface),再實作填寫真正的操作內容
//這邊用ADD和GET練習
public interface phoneDAO {
    public void  addOne(phone p);
    public phone getOne(int id);
    public void clearAll();
    public phone[] getList();
}
