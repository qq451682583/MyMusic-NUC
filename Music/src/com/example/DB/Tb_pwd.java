package com.example.DB;

public class Tb_pwd// �������ݱ�ʵ����
{
	private int id;
	private String name;// �����ַ�������ʾ�û�����
	private String password;

	public Tb_pwd()// Ĭ�Ϲ��캯��
	{
		super();
	}

	public Tb_pwd(String user_name,String password)// �����вι��캯��
	{
		super();
		this.id = id;
		this.name = user_name;
		this.password = password;// Ϊ���븳ֵ
		
	}
	public String getUser_name() {
		return name;
	}

	public void setUser_name(String name) {
		this.name = name;
	}
	public String getPassword()// ��������Ŀɶ�����
	{
		return password;
	}

	public void setPassword(String number)// ��������Ŀ�д����
	{
		this.password = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
