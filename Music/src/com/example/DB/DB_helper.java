package com.example.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB_helper extends SQLiteOpenHelper {
	private static final int VERSION = 1;// 定义数据库版本号
	//public final static String TABLE_NAME = "student_info";// 定义数据库名
	public static final String DBNAME = "login3.db";// 定义数据库名
	String TBNAME = "user";
	String ID = "id";
	String NAME = "name";
	String PASSWORD = "password";
	String sql1 = "CREATE TABLE " + TBNAME +"("+
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
			NAME + " TEXT ," +
			PASSWORD + " TEXT);" ;
	String sql2 = "CREATE TABLE mylove("+
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
			NAME + " TEXT);" ;
	String sql3 = "CREATE TABLE latest("+
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
			NAME + " TEXT);" ;
	String sql4 = "CREATE TABLE download("+
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
			NAME + " TEXT);" ;


	public DB_helper(Context context){// 定义构造函数
	
		super(context, DBNAME, null, 2);// 重写基类的构造函数
	}

	@Override
	public void onCreate(SQLiteDatabase db){// 创建数据库	
		Log.i("GOOD", "成功创建密码表");
			db.execSQL(sql1);//本句所有表操作都加上.
			db.execSQL(sql2);//本句所有表操作都加上.
			db.execSQL(sql3);//本句所有表操作都加上.
			db.execSQL(sql4);//本句所有表操作都加上.
			Log.i("GOOD1111", "成功创建密码表eerr");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)// 覆写基类的onUpgrade方法，以便数据库版本更新
	{
		db.execSQL("DROP TABLE IF EXISTS " +
				TBNAME);
		db.execSQL(sql1);
		db.execSQL(sql2);
		db.execSQL(sql3);
		db.execSQL(sql4);
		Log.i("GOOwwwwwD", "成功创建密码表ttyyy");
		
	}
	
	
}
