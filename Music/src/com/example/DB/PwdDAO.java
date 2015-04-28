package com.example.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class PwdDAO {
	private DB_helper helper;// 创建DBOpenHelper对象
	private SQLiteDatabase db;// 创建SQLiteDatabase对象

	public PwdDAO(Context context)// 定义构造函数
	{
		helper = new DB_helper(context);// 初始化DBOpenHelper对象
	}

	/**
	 * 添加密码信息
	 * 
	 * @param tb_pwd
	 */
	public void add(Tb_pwd tb_pwd) {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		db.execSQL("insert into user (name,password) values (?,?)",
				new Object[] {tb_pwd.getUser_name(),tb_pwd.getPassword() });
	}

	/**
	 * 设置密码信息
	 * 
	 * @param tb_pwd
	 */
	
 
	/**
	 * 查找密码信息
	 * 
	 * @return
	 */
	
	
	public String find(String a,String b) {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		// 查找密码并存储到Cursor类中
		Cursor cur = db.rawQuery("select * from user", null);
		while (cur.moveToNext())// 遍历查找到的密码信息
		{
			// 将密码存储到Tb_pwd类中
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
		return "none";// 如果没有信息，则返回null
	}
//	public Tb_pwd find() {
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
//		// 查找密码并存储到Cursor类中
//		Cursor cursor = db.rawQuery("select id,user_name,password from tb_pwd where id = ?", null);
//		if (cursor.moveToNext())// 遍历查找到的密码信息
//		{
//			// 将密码存储到Tb_pwd类中
//			return new Tb_pwd(cursor.getInt(cursor
//					.getColumnIndex("id")),cursor.getString(cursor
//					.getColumnIndex("user_name")),cursor.getString(cursor
//					.getColumnIndex("password")));
//		}
//		return null;// 如果没有信息，则返回null
//	}
//	
//	public List<Tb_pwd> getScrollData(int start, int count) {
//		List<Tb_pwd> lisTb_pwd = new ArrayList<Tb_pwd>();// 创建集合对象
//		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
//		// 获取所有便签信息
//		Cursor cursor = db.rawQuery("select * from Tb_pwd limit ?,?",
//				new String[] { String.valueOf(start), String.valueOf(count) });
//		while (cursor.moveToNext())// 遍历所有的便签信息
//		{
//			// 将遍历到的便签信息添加到集合中
//			lisTb_pwd.add(new Tb_pwd(cursor.getInt(cursor
//					.getColumnIndex("id")),cursor.getString(cursor
//					.getColumnIndex("user_name")), cursor.getString(cursor
//					.getColumnIndex("password"))));
//		}
//		return lisTb_pwd;// 返回集合
//	}
//
	public String Check(String ss) {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		
		Cursor cur = db.rawQuery("select * from user",null);
		while (cur.moveToNext())// 遍历所有的便签信息
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
//		if (cursor.moveToNext())// 遍历查找到的密码信息
//		{
//			// 将密码存储到Tb_pwd类中
//			return aa = aa + cursor.getString(cursor
//					.getColumnIndex("name"));
//		}else
//		return aa;// 如果没有信息，则返回null
//		{
		
		//return cursor.toString();
//	}
//	return 
}
