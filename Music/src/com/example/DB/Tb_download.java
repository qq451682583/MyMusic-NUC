package com.example.DB;

public class Tb_download {
	private String name;// �����ַ�������ʾ�û�����


	public Tb_download()// Ĭ�Ϲ��캯��
	{
		super();
	}

	public Tb_download(String name)// �����вι��캯��
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
