package com.example.DB;

public class Tb_pwd// 密码数据表实体类
{
	private int id;
	private String name;// 定义字符串，表示用户密码
	private String password;

	public Tb_pwd()// 默认构造函数
	{
		super();
	}

	public Tb_pwd(String user_name,String password)// 定义有参构造函数
	{
		super();
		this.id = id;
		this.name = user_name;
		this.password = password;// 为密码赋值
		
	}
	public String getUser_name() {
		return name;
	}

	public void setUser_name(String name) {
		this.name = name;
	}
	public String getPassword()// 定义密码的可读属性
	{
		return password;
	}

	public void setPassword(String number)// 定义密码的可写属性
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
