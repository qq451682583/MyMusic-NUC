package com.example.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Setdetalis extends Activity{
	TextView geiwohaoping,banbengengxing,guanyu;
	Button back;
	ToggleButton bt1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.setdetails);
        ExitApplication.getInstance().addActivity(this);
        
        geiwohaoping = (TextView)findViewById(R.id.geiwohaoping);
        banbengengxing = (TextView)findViewById(R.id.jianchagengxin);
        guanyu = (TextView)findViewById(R.id.setguanyu);
        bt1 = (ToggleButton)findViewById(R.id.settings_set_javascript_toggle_btn);
        back = (Button)findViewById(R.id.setdetailsback);
        
        geiwohaoping.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(Setdetalis.this, "感谢您,我们会更加努力！O(∩_∩)O",1000).show();
			}
		});
        banbengengxing.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(Setdetalis.this, "已是最新版本！",1000).show();
			}
		});
        guanyu.setOnClickListener(new OnClickListener() {
	
        	@Override
			public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		Intent in = new Intent(Setdetalis.this,About.class);
        		startActivity(in);
        	}
        });
        
        bt1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){  
					SplashActivity.spl.state = 0;
	            }else{  
	            	SplashActivity.spl.state = 0;
	            }  
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
