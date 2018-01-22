package com.mars.android20180122;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Student on 2018/1/22.
 */
/*
***primary key 的名字設定為 _id，不然好像會 error
然後再經由程式進行存取，SQLite 是經由 Android 幫你建立的
所以要繼承 SQLiteOpenHelper 然後來建立一個資料表
1.首先建立一個 class 叫做 DBHelper 然後繼承 SQLiteOpenHelper

*/
public class MyHelper extends SQLiteOpenHelper {
    //先定義資料庫名稱與版本
    final static String DB_NAME = "student.sqlite";
    final static int VERSION = 1;
    public MyHelper(Context context) {
        /*
        super(context, name, factory, version);
        super 關鍵字指的是目前這個 class 的上一層，也就是 SQLiteOpenHelper
        我們把剛剛定義的變數(資料庫名稱與版本)傳給 name 與 version於是就變成
         */
        super(context, DB_NAME, null, VERSION);
    }
    //其中覆寫的 onCreate 指的是如果 Android 載入時找不到生成的資料庫檔案，就會觸發 onCreate
    //再來我們就分別在 onCreate 與 onUpgrade 放入SQL的命令
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE \"students\" ( `_id` INTEGER, `name` TEXT, `score` INTEGER, PRIMARY KEY(`_id`) )");
    }

    //如果使用者有資料庫的話會跑這個方法
    //onUpgrade 則是如果資料庫結構有改變了就會觸發 onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        /*
        例子
        final String SQL = "DROP TABLE " + _TableName;
        db.execSQL(SQL);
         */
    }
}
