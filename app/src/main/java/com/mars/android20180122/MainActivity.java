package com.mars.android20180122;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new 寫好的資料庫建立class
        MyHelper myHelper = new MyHelper(MainActivity.this);
        //建立一個可寫入的資料庫
        SQLiteDatabase db = myHelper.getWritableDatabase();
    }
}
