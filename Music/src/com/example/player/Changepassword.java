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
	EditText txtpwd,txtpwds,txtzhanghao;// ����EditText����
	Button btnSet,loginback;// ����һ��Button����
	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.changepassword);// ���ò����ļ�
		ExitApplication.getInstance().addActivity(this);

		txtpwd = (EditText) findViewById(R.id.txtPwd);// ��ȡ�����ı���
		txtpwds = (EditText)findViewById(R.id.txtPwds);
		txtzhanghao = (EditText) findViewById(R.id.txtNC);
		btnSet = (Button) findViewById(R.id.btnSetYes);// ��ȡ���ð�ť
		loginback = (Button)findViewById(R.id.loginback);

		btnSet.setOnClickListener(new OnClickListener() {// Ϊ���ð�ť��Ӽ����¼�
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO pwdDAO = new PwdDAO(Changepassword.this);// ����PwdDAO����				
				Tb_pwd tb_pwd = new Tb_pwd(txtzhanghao.getText().toString(),txtpwd.getText().toString());// ������������봴��Tb_pwd����
				if(txtpwd.getText().toString().isEmpty()||txtpwds.getText().toString().isEmpty()||txtzhanghao.getText().toString().isEmpty()){
					Toast.makeText(Changepassword.this, "������ע����Ϣ��", Toast.LENGTH_SHORT)
					.show();
				}else{
					if(txtpwd.getText().toString().equals(txtpwds.getText().toString())){
						if (pwdDAO.Check(txtzhanghao.getText().toString()).equals("none")) {// �ж����ݿ����Ƿ��Ѿ�����������
							pwdDAO.add(tb_pwd);// ����û�����
							Toast.makeText(Changepassword.this, "���û�ע��ɹ���", Toast.LENGTH_SHORT)
							.show();
							Intent intent = new Intent(Changepassword.this, Login.class);
							startActivity(intent);
							finish();
						}else
							Toast.makeText(Changepassword.this, "���û����Ѵ��ڣ�������ֱ�ӵ�¼��", Toast.LENGTH_SHORT)
							.show();		
					}else{
						Toast.makeText(Changepassword.this, "�����������벻һ�£����������룡", Toast.LENGTH_SHORT)
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
