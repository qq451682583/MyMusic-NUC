package com.example.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class PwdDAO {
	private DB_helper helper;// ����DBOpenHelper����
	private SQLiteDatabase db;// ����SQLiteDatabase����

	public PwdDAO(Context context)// ���幹�캯��
	{
		helper = new DB_helper(context);// ��ʼ��DBOpenHelper����
	}

	/**
	 * ���������Ϣ
	 * 
	 * @param tb_pwd
	 */
	public void add(Tb_pwd tb_pwd) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		db.execSQL("insert into user (name,password) values (?,?)",
				new Object[] {tb_pwd.getUser_name(),tb_pwd.getPassword() });
	}

	/**
	 * ����������Ϣ
	 * 
	 * @param tb_pwd
	 */
	
 
	/**
	 * ����������Ϣ
	 * 
	 * @return
	 */
	
	
	public String find(String a,String b) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// �������벢�洢��Cursor����
		Cursor cur = db.rawQuery("select * from user", null);
		while (cur.moveToNext())// �������ҵ���������Ϣ
		{
			// ������洢��Tb_pwd����
			if(cur != null){
				if(cur.getCount() == 0)
				{
					return "none";
				}else
				{		
						if(a.equals(cur.getString(1))&&b.equals(cur.getString(2)))
						{
							return "YES";
						}else
						{
							return "none";
						}
				}
			}
		}
		return "none";// ���û����Ϣ���򷵻�null
	}
//	public Tb_pwd find() {
//		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
//		// �������벢�洢��Cursor����
//		Cursor cursor = db.rawQuery("select id,user_name,password from tb_pwd where id = ?", null);
//		if (cursor.moveToNext())// �������ҵ���������Ϣ
//		{
//			// ������洢��Tb_pwd����
//			return new Tb_pwd(cursor.getInt(cursor
//					.getColumnIndex("id")),cursor.getString(cursor
//					.getColumnIndex("user_name")),cursor.getString(cursor
//					.getColumnIndex("password")));
//		}
//		return null;// ���û����Ϣ���򷵻�null
//	}
//	
//	public List<Tb_pwd> getScrollData(int start, int count) {
//		List<Tb_pwd> lisTb_pwd = new ArrayList<Tb_pwd>();// �������϶���
//		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
//		// ��ȡ���б�ǩ��Ϣ
//		Cursor cursor = db.rawQuery("select * from Tb_pwd limit ?,?",
//				new String[] { String.valueOf(start), String.valueOf(count) });
//		while (cursor.moveToNext())// �������еı�ǩ��Ϣ
//		{
//			// ���������ı�ǩ��Ϣ��ӵ�������
//			lisTb_pwd.add(new Tb_pwd(cursor.getInt(cursor
//					.getColumnIndex("id")),cursor.getString(cursor
//					.getColumnIndex("user_name")), cursor.getString(cursor
//					.getColumnIndex("password"))));
//		}
//		return lisTb_pwd;// ���ؼ���
//	}
//
	public String Check(String ss) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		
		Cursor cur = db.rawQuery("select * from user",null);
		while (cur.moveToNext())// �������еı�ǩ��Ϣ
		{
			if(cur != null){
				if(cur.getCount() == 0)
				{
					return "none";
				}else
				{		
						if(ss.equals(cur.getString(1)))
						{
							return "exist";
						}
				}
			}
			}
		return "none";
	}
//		String[] tt = new String[]{"id","name","number"};
//		Cursor cur = db.query("student_info", tt,null,null,null,null,"id desc");
//		Cursor cursor = db.rawQuery("select name from student_info", null);
//		if (cursor.moveToNext())// �������ҵ���������Ϣ
//		{
//			// ������洢��Tb_pwd����
//			return aa = aa + cursor.getString(cursor
//					.getColumnIndex("name"));
//		}else
//		return aa;// ���û����Ϣ���򷵻�null
//		{
		
		//return cursor.toString();
//	}
//	return 
}
