package com.example.DB;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DownloadDAO {
	private DB_helper helper;// ����DBOpenHelper����
	private SQLiteDatabase db;// ����SQLiteDatabase����

	public DownloadDAO(Context context)// ���幹�캯��
	{
		helper = new DB_helper(context);// ��ʼ��DBOpenHelper����
	}

	/**
	 * ���������Ϣ
	 * 
	 * @param tb_pwd
	 */
	public void add(Tb_download tb_download) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		db.execSQL("insert into download (name) values (?)",
				new Object[] {tb_download.getName() });
	}
	
	public List<Tb_download> getScrollData() {
		List<Tb_download> lisTb_download = new ArrayList<Tb_download>();// �������϶���
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ��ȡ���б�ǩ��Ϣ
		Cursor cursor = db.rawQuery("select * from download",null);

		while (cursor.moveToNext())// �������еı�ǩ��Ϣ
		{
			// ���������ı�ǩ��Ϣ��ӵ�������
			lisTb_download.add(new Tb_download(cursor.getString(cursor
					.getColumnIndex("name"))));
		}
		return lisTb_download;// ���ؼ���
	}
	public String Check(String ss) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		
		Cursor cur = db.rawQuery("select * from download",null);
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
