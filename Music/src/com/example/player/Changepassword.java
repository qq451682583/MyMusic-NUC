package com.example.player;



import com.example.DB.PwdDAO;
import com.example.DB.Tb_pwd;



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

public class Changepassword extends Activity {
	EditText txtpwd,txtpwds,txtzhanghao;// 创建EditText对象
	Button btnSet,loginback;// 创建一个Button对象
	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.changepassword);// 设置布局文件
		ExitApplication.getInstance().addActivity(this);

		txtpwd = (EditText) findViewById(R.id.txtPwd);// 获取密码文本框
		txtpwds = (EditText)findViewById(R.id.txtPwds);
		txtzhanghao = (EditText) findViewById(R.id.txtNC);
		btnSet = (Button) findViewById(R.id.btnSetYes);// 获取设置按钮
		loginback = (Button)findViewById(R.id.loginback);

		btnSet.setOnClickListener(new OnClickListener() {// 为设置按钮添加监听事件
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO pwdDAO = new PwdDAO(Changepassword.this);// 创建PwdDAO对象				
				Tb_pwd tb_pwd = new Tb_pwd(txtzhanghao.getText().toString(),txtpwd.getText().toString());// 根据输入的密码创建Tb_pwd对象
				if(txtpwd.getText().toString().isEmpty()||txtpwds.getText().toString().isEmpty()||txtzhanghao.getText().toString().isEmpty()){
					Toast.makeText(Changepassword.this, "请完整注册信息！", Toast.LENGTH_SHORT)
					.show();
				}else{
					if(txtpwd.getText().toString().equals(txtpwds.getText().toString())){
						if (pwdDAO.Check(txtzhanghao.getText().toString()).equals("none")) {// 判断数据库中是否已经设置了密码
							pwdDAO.add(tb_pwd);// 添加用户密码
							Toast.makeText(Changepassword.this, "新用户注册成功！", Toast.LENGTH_SHORT)
							.show();
							Intent intent = new Intent(Changepassword.this, Login.class);
							startActivity(intent);
							finish();
						}else
							Toast.makeText(Changepassword.this, "该用户名已存在！您可以直接登录！", Toast.LENGTH_SHORT)
							.show();		
					}else{
						Toast.makeText(Changepassword.this, "两次密码输入不一致，请重新输入！", Toast.LENGTH_SHORT)
						.show();	
						txtpwd.setText("");
						txtpwds.setText("");
					}
				}				
				}
				
		});
		
		loginback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
