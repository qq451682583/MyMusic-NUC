package com.example.DB;

public class Tb_mylove {
	private String name;// 定义字符串，表示用户密码


	public Tb_mylove()// 默认构造函数
	{
		super();
	}

	public Tb_mylove(String name)// 定义有参构造函数
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
