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
	EditText zhanghao,password;// ����EditText����
	Button btnlogin, btnzhuce,back;// ��������Button����
	public final static String HELLOWORLD = "com.example.player.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);// ���ò����ļ�
		ExitApplication.getInstance().addActivity(this);

		zhanghao = (EditText) findViewById(R.id.usertext);// ��ȡ�˺��ı���
		password = (EditText) findViewById(R.id.passwordtext);//��ȡ�����ı���
		btnlogin = (Button) findViewById(R.id.btnLogin);// ��ȡ��¼��ť
		btnzhuce = (Button) findViewById(R.id.btnZhuce);// ��ȡע�ᰴť
		back = (Button)findViewById(R.id.loginback);

		btnlogin.setOnClickListener(new OnClickListener() {// Ϊ��¼��ť���ü����¼�
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO pwdDAO = new PwdDAO(Login.this);// ����PwdDAO����
				// �ж��Ƿ������뼰�Ƿ�����������
			    if (password.getText().toString().isEmpty()||zhanghao.getText().toString().isEmpty()) {
			    	Toast.makeText(Login.this, "�˺Ż����벻��Ϊ�գ�",
							Toast.LENGTH_SHORT).show();
				} else {
					 //�ж�����������Ƿ������ݿ��е�����һ��
					if (pwdDAO.find(zhanghao.getText().toString(), password.getText().toString()).equals("YES")) {
						Toast.makeText(Login.this, "��¼�ɹ���",
								Toast.LENGTH_SHORT).show();
						MainActivity.main.textlogin.setText(zhanghao.getText().toString());
						finish();
						
					} else {
						 //������Ϣ��ʾ
						Toast.makeText(Login.this, "�û������������",
								Toast.LENGTH_SHORT).show();
					}
					password.setText("");// ��������ı���
					zhanghao.setText("");//����˺��ı���
				}			
			}
		});
		
		btnzhuce.setOnClickListener(new OnClickListener() {// Ϊ��¼��ť���ü����¼�
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, Changepassword.class);// ����Intent����
				startActivity(intent);// ����ע��ҳ��
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
