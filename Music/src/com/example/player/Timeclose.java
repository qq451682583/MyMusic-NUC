package com.example.player;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Timeclose extends Activity{
	Timer timer = new Timer();
	Switch dingshiswitch; 
	LinearLayout shijiancao;
	SeekBar dingshibar;
	private int currenttime = 0;//保存当前时间
	TextView daojishitext;
	private final String TAG="AAA";
	Button back;
	int i = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.timeclose);// 设置布局文件
		ExitApplication.getInstance().addActivity(this);
		
		
		dingshiswitch = (Switch)findViewById(R.id.dingshiswitch);
		shijiancao = (LinearLayout)findViewById(R.id.shijiancao);
		dingshibar = (SeekBar)findViewById(R.id.dingshiBar);
		daojishitext = (TextView)findViewById(R.id.daojishitext);
		back = (Button)findViewById(R.id.timecloseback);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		dingshiswitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {  
                    shijiancao.setVisibility(View.VISIBLE);
                } else {  
                    shijiancao.setVisibility(View.GONE);
                    daojishitext.setText("倒计时 :30:00");
                }  
			}
		});
		
		dingshibar.setMax(115);
		dingshibar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			//拖动中
		    @Override
		    public void onProgressChanged(SeekBar seekBar, int progress,
		            boolean fromUser) {
		    	currenttime = (progress+5)*60;	  
		    	Log.i(TAG,"--"+currenttime+"--"+progress);
		    	
		    	timer.scheduleAtFixedRate(new TimerTask()  
		        {  	  
		            @Override  
		            public void run()  
		            {  
		                // TODO Auto-generated method stub  
		                Message message = new Message();  
		                message.what = 1;  
		                handler.sendMessage(message);  		            	
		            } 	  
		        }, 1000, 1000);  		    	
		    }
		    //开始拖动
		    @Override
		    public void onStartTrackingTouch(SeekBar seekBar) {
		    	Toast.makeText(Timeclose.this, "22       "+currenttime, Toast.LENGTH_LONG).show();
		         
		    }
		    //结束拖动
		    @Override
		    public void onStopTrackingTouch(SeekBar seekBar) {
		    	Toast.makeText(Timeclose.this, "33        "+currenttime, Toast.LENGTH_LONG).show();
		         
		    }
		});
		//timer.schedule(task, 10000); 
	}
	
	 
		  
	       
//	    Handler handler = new Handler(){   
//	  
//	        public void handleMessage(Message msg) {   
//	            switch (msg.what) {       
//	            case 1:       
//	            	ExitApplication.getInstance().exit();  
//	                break;       
//	            }       
//	            super.handleMessage(msg);   
//	        }   
//	           
//	    };   
	  	  
    private Handler handler = new Handler()  
    {  
    	
        @Override  
        public void handleMessage(Message msg)  
        {  
            // TODO Auto-generated method stub  
        	i++;
            super.handleMessage(msg);  
            int msgId = msg.what;
            Log.i("SSSSS","--aaaaaaaa-"+currenttime+"--");
            switch (msgId)  
            {  
            case 1:  
            	int hour,miniute,second;
		    	hour = currenttime/3600;
		    	miniute = currenttime/60%60;
		    	second = currenttime%60;
		    	if(miniute<10)
		    	{
		    		if(second<10)
		    		{
		    			daojishitext.setText("倒计时 "+hour+":0"+miniute+":0"+second);
		    		}else
		    		{
		    			daojishitext.setText("倒计时 "+hour+":0"+miniute+":"+second);
		    		}
		    	}else{
		    		if(second<10)
		    		{
		    			daojishitext.setText("倒计时 "+hour+":"+miniute+":0"+second);
		    		}else
		    		{
		    			daojishitext.setText("倒计时 "+hour+":"+miniute+":"+second);
		    		}
		    	}
		    	currenttime = currenttime - 1;
                break;  
            default:  
                break;  
            }  
        }  
    };  
  
    /** Called when the activity is first created. */   
    @Override  
    protected void onDestroy()  
    {  
        // TODO Auto-generated method stub  
        super.onDestroy();  
        timer.cancel();  
    }    
}
