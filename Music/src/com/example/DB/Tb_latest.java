package com.example.DB;

public class Tb_latest {
	private String name;// �����ַ�������ʾ�û�����


	public Tb_latest()// Ĭ�Ϲ��캯��
	{
		super();
	}

	public Tb_latest(String name)// �����вι��캯��
	{
		super();
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
