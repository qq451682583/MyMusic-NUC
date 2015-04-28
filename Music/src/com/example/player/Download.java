package com.example.player;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.DB.DownloadDAO;
import com.example.DB.Tb_download;

public class Download extends Activity{
	String[] strInfos = null;
	ListView downloadlist;
	TextView downloadtext;
	Button downloadback;
	private String MUSICPATH = "/sdcard";
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.download);
	        ExitApplication.getInstance().addActivity(this); 
	        
	        downloadlist = (ListView)findViewById(R.id.downloadview);
	        downloadtext = (TextView)findViewById(R.id.setdownloadnumber);
	        downloadback = (Button)findViewById(R.id.downloadtback);
	        
	        downloadback.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					finish();
				}
			});
	        
	        ArrayAdapter<String> arrayAdapter = null;// 创建ArrayAdapter对象
			// 以intType为条件进行判断
			
				
				DownloadDAO outaccountinfo = new DownloadDAO(Download.this);// 创建OutaccountDAO对象
				// 获取所有信息，并存储到List泛型集合中
				List<Tb_download> listoutinfos = outaccountinfo.getScrollData();
				strInfos = new String[listoutinfos.size()];// 设置字符串数组的长度
				int i = 0;// 定义一个开始标识
				for (Tb_download tb_download : listoutinfos) {// 遍历List泛型集合
					// 将相关信息存储到字符串数组的相应位置
					strInfos[i] = tb_download.getName();
					
					i++;// 标识加1
				}
				downloadtext.setText("下载完成("+i+")");
			
			// 使用字符串数组初始化ArrayAdapter对象
			arrayAdapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, strInfos);
			downloadlist.setAdapter(arrayAdapter);// 为ListView列表设置数据源
			downloadlist.setOnItemClickListener(new OnItemClickListener(){
				@Override
				@SuppressLint("SdCardPath") public void onItemClick(AdapterView<?>listView,View view,int position,long id){
					MainActivity.main.play(MUSICPATH+"/"+strInfos[position]+".mp3");
					MainActivity.main.AddLatestMusic();
					MainActivity.main.name.setText(strInfos[position]);
				}
			});   
	 }
}
