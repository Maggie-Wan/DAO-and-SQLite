package com.example.student.DAOandSQLite;

//建一個物件用來存放資料庫的資料

public class phone {
    static int id;
    static String name;
    static  String tel;
    static String addr;
    static String email;
    static String tel2;

    //為了不影響前面程式，要多寫幾個建構式(因為之前程式new物件的時候不用放參數)
    public phone() {
    }

    //為了方便處理資料，加寫建構式，三個參數是用來新增物件用
    public phone(String name, String tel, String addr) {
        this.name = name;
        this.tel = tel;
        this.addr = addr;
    }

    //四個參數是用來讀取資料用
    public phone(int id, String name, String tel, String addr) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.addr = addr;
    }

}
