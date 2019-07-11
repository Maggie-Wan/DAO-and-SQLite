package com.example.student.DAOandSQLite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        phone p=new  phone();
        p.name="kent";
        p.tel="12345678";
        p.tel2="87654321";
        p.addr="abceddddd";
        p.email="test2@eamil";
        phoneDAODBImpl pi=new phoneDAODBImpl(MainActivity.this);
        pi.addOne(p);
        phone p1=pi.getOne(1);

        Log.d("p1","p1"+p1.addr+","+p1.name+","+p1.tel);
    }
  
}

