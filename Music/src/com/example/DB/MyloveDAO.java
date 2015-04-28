package com.example.DB;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyloveDAO {
	private DB_helper helper;// 创建DBOpenHelper对象
	private SQLiteDatabase db;// 创建SQLiteDatabase对象

	public MyloveDAO(Context context)// 定义构造函数
	{
		helper = new DB_helper(context);// 初始化DBOpenHelper对象
	}

	/**
	 * 添加密码信息
	 * 
	 * @param tb_pwd
	 */
	public void add(Tb_mylove tb_mylove) {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		db.execSQL("insert into mylove (name) values (?)",
				new Object[] {tb_mylove.getName() });
	}
	
	public List<Tb_mylove> getScrollData() {
		List<Tb_mylove> lisTb_mylove = new ArrayList<Tb_mylove>();// 创建集合对象
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		// 获取所有便签信息
		Cursor cursor = db.rawQuery("select * from mylove",null);

		while (cursor.moveToNext())// 遍历所有的便签信息
		{
			// 将遍历到的便签信息添加到集合中
			lisTb_mylove.add(new Tb_mylove(cursor.getString(cursor
					.getColumnIndex("name"))));
		}
		return lisTb_mylove;// 返回集合
	}
	public String Check(String ss) {
		db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
		
		Cursor cur = db.rawQuery("select * from mylove",null);
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
}
