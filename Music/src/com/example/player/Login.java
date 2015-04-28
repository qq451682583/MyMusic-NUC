package com.example.player;

import com.example.DB.PwdDAO;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



@SuppressLint("NewApi") public class Login extends Activity {
	EditText zhanghao,password;// 创建EditText对象
	Button btnlogin, btnzhuce,back;// 创建两个Button对象
	public final static String HELLOWORLD = "com.example.player.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);// 设置布局文件
		ExitApplication.getInstance().addActivity(this);

		zhanghao = (EditText) findViewById(R.id.usertext);// 获取账号文本框
		password = (EditText) findViewById(R.id.passwordtext);//获取密码文本框
		btnlogin = (Button) findViewById(R.id.btnLogin);// 获取登录按钮
		btnzhuce = (Button) findViewById(R.id.btnZhuce);// 获取注册按钮
		back = (Button)findViewById(R.id.loginback);

		btnlogin.setOnClickListener(new OnClickListener() {// 为登录按钮设置监听事件
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO pwdDAO = new PwdDAO(Login.this);// 创建PwdDAO对象
				// 判断是否有密码及是否输入了密码
			    if (password.getText().toString().isEmpty()||zhanghao.getText().toString().isEmpty()) {
			    	Toast.makeText(Login.this, "账号或密码不能为空！",
							Toast.LENGTH_SHORT).show();
				} else {
					 //判断输入的密码是否与数据库中的密码一致
					if (pwdDAO.find(zhanghao.getText().toString(), password.getText().toString()).equals("YES")) {
						Toast.makeText(Login.this, "登录成功！",
								Toast.LENGTH_SHORT).show();
						MainActivity.main.textlogin.setText(zhanghao.getText().toString());
						finish();
						
					} else {
						 //弹出信息提示
						Toast.makeText(Login.this, "用户名或密码错误！",
								Toast.LENGTH_SHORT).show();
					}
					password.setText("");// 清空密码文本框
					zhanghao.setText("");//清空账号文本框
				}			
			}
		});
		
		btnzhuce.setOnClickListener(new OnClickListener() {// 为登录按钮设置监听事件
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, Changepassword.class);// 创建Intent对象
				startActivity(intent);// 启动注册页面
				finish();
			}
		});

		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
