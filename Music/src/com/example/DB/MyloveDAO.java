package com.example.DB;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyloveDAO {
	private DB_helper helper;// ����DBOpenHelper����
	private SQLiteDatabase db;// ����SQLiteDatabase����

	public MyloveDAO(Context context)// ���幹�캯��
	{
		helper = new DB_helper(context);// ��ʼ��DBOpenHelper����
	}

	/**
	 * ���������Ϣ
	 * 
	 * @param tb_pwd
	 */
	public void add(Tb_mylove tb_mylove) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		db.execSQL("insert into mylove (name) values (?)",
				new Object[] {tb_mylove.getName() });
	}
	
	public List<Tb_mylove> getScrollData() {
		List<Tb_mylove> lisTb_mylove = new ArrayList<Tb_mylove>();// �������϶���
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ��ȡ���б�ǩ��Ϣ
		Cursor cursor = db.rawQuery("select * from mylove",null);

		while (cursor.moveToNext())// �������еı�ǩ��Ϣ
		{
			// ���������ı�ǩ��Ϣ��ӵ�������
			lisTb_mylove.add(new Tb_mylove(cursor.getString(cursor
					.getColumnIndex("name"))));
		}
		return lisTb_mylove;// ���ؼ���
	}
	public String Check(String ss) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		
		Cursor cur = db.rawQuery("select * from mylove",null);
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
}
