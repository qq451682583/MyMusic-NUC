package com.example.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Mypage extends Activity{
	TextView zhanghao,youxiang,shouji;
	Button tuichudenglu,mypageback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mypage);
        ExitApplication.getInstance().addActivity(this);
        
        zhanghao = (TextView)findViewById(R.id.mypagezhanghao);
        //shouji = (TextView)findViewById(R.id.mypageshouji);
        //youxiang = (TextView)findViewById(R.id.mypageyouxiang);
        
        tuichudenglu = (Button)findViewById(R.id.tuichudenglu);
        mypageback = (Button)findViewById(R.id.mypageback);
        
        Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.HELLO);
        
        //shouji.setText("手机：13227293721");
       // youxiang.setText("邮箱：792075058@qq.com");
        zhanghao.setText("当前账号："+message);
        
        mypageback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        tuichudenglu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				MainActivity.main.textlogin.setText("登录");
				finish();
			}
		});
	}
}
