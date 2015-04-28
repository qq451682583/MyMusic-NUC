package com.example.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB_helper extends SQLiteOpenHelper {
	private static final int VERSION = 1;// �������ݿ�汾��
	//public final static String TABLE_NAME = "student_info";// �������ݿ���
	public static final String DBNAME = "login3.db";// �������ݿ���
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


	public DB_helper(Context context){// ���幹�캯��
	
		super(context, DBNAME, null, 2);// ��д����Ĺ��캯��
	}

	@Override
	public void onCreate(SQLiteDatabase db){// �������ݿ�	
		Log.i("GOOD", "�ɹ����������");
			db.execSQL(sql1);//�������б����������.
			db.execSQL(sql2);//�������б����������.
			db.execSQL(sql3);//�������б����������.
			db.execSQL(sql4);//�������б����������.
			Log.i("GOOD1111", "�ɹ����������eerr");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)// ��д�����onUpgrade�������Ա����ݿ�汾����
	{
		db.execSQL("DROP TABLE IF EXISTS " +
				TBNAME);
		db.execSQL(sql1);
		db.execSQL(sql2);
		db.execSQL(sql3);
		db.execSQL(sql4);
		Log.i("GOOwwwwwD", "�ɹ����������ttyyy");
		
	}
	
	
}
