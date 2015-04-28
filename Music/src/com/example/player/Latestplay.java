package com.example.player;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.DB.LatestplayDAO;
import com.example.DB.Tb_latest;


public class Latestplay extends Activity{
	public ListView latestList; 
	public Button latestback;
	public TextView latestnumber;
	private String MUSICPATH = "/sdcard";
	String[] strInfos = null;// 定义字符串数组，用来存储信息
																														
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.latestplay);
        ExitApplication.getInstance().addActivity(this);
        
        latestList = (ListView)findViewById(R.id.Latestplayview);
        latestnumber = (TextView)findViewById(R.id.setlatestnumber);
        latestback = (Button)findViewById(R.id.latestback);
        latestback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        bianli();
        }

	public void bianli() {
		// TODO Auto-generated method stub
		
		
		ArrayAdapter<String> arrayAdapter = null;// 创建ArrayAdapter对象
		// 以intType为条件进行判断
		
			
			LatestplayDAO outaccountinfo = new LatestplayDAO(Latestplay.this);// 创建OutaccountDAO对象
			// 获取所有信息，并存储到List泛型集合中
			List<Tb_latest> listoutinfos = outaccountinfo.getScrollData();
			strInfos = new String[listoutinfos.size()];// 设置字符串数组的长度
			int i = 0;// 定义一个开始标识
			for (Tb_latest tb_latest : listoutinfos) {// 遍历List泛型集合
				// 将相关信息存储到字符串数组的相应位置
				strInfos[i] = tb_latest.getName();
				i++;// 标识加1
			}
			latestnumber.setText("最近播放("+i+")");
		
		// 使用字符串数组初始化ArrayAdapter对象
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, strInfos);
		latestList.setAdapter(arrayAdapter);// 为ListView列表设置数据源
		
		latestList.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?>listView,View view,int position,long id){
				MainActivity.main.play(MUSICPATH+"/"+strInfos[position]+".mp3");
				Toast.makeText(Latestplay.this, strInfos[position], Toast.LENGTH_LONG).show();
			}
		});   
	}
}
