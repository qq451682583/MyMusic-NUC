package com.example.DB;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LatestplayDAO {
	private DB_helper helper;// ����DBOpenHelper����
	private SQLiteDatabase db;// ����SQLiteDatabase����

	public LatestplayDAO(Context context)// ���幹�캯��
	{
		helper = new DB_helper(context);// ��ʼ��DBOpenHelper����
	}

	/**
	 * ���������Ϣ
	 * 
	 * @param tb_pwd
	 */
	public void add(Tb_latest tb_latest) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		db.execSQL("insert into latest (name) values (?)",
				new Object[] {tb_latest.getName() });
	}
	
	public List<Tb_latest> getScrollData() {
		List<Tb_latest> lisTb_latest = new ArrayList<Tb_latest>();// �������϶���
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ��ȡ���б�ǩ��Ϣ
		Cursor cursor = db.rawQuery("select * from latest",null);

		while (cursor.moveToNext())// �������еı�ǩ��Ϣ
		{
			// ���������ı�ǩ��Ϣ��ӵ�������
			lisTb_latest.add(new Tb_latest(cursor.getString(cursor
					.getColumnIndex("name"))));
		}
		return lisTb_latest;// ���ؼ���
	}
	public String Check(String ss) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		
		Cursor cur = db.rawQuery("select * from latest",null);
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
