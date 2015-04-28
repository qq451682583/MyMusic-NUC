package com.example.DB;

public class Tb_latest {
	private String name;// 定义字符串，表示用户密码


	public Tb_latest()// 默认构造函数
	{
		super();
	}

	public Tb_latest(String name)// 定义有参构造函数
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
