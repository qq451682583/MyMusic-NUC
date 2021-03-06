package com.example.player;

import java.util.List;

import com.example.DB.MyloveDAO;
import com.example.DB.Tb_mylove;

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
import android.widget.AdapterView.OnItemClickListener;

public class MyloveMusic extends Activity{
	public ListView myloveList; 
	public Button myloveback;
	public TextView mylovenumber;
	String[] strInfos = null;
	private String MUSICPATH = "/sdcard";
																													
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mylove);
        ExitApplication.getInstance().addActivity(this);
        
        myloveList = (ListView)findViewById(R.id.myloveList);
        mylovenumber = (TextView)findViewById(R.id.setmylovenumber);
        myloveback = (Button)findViewById(R.id.myloveback);
        myloveback.setOnClickListener(new OnClickListener() {
			
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
		  
		// 定义字符串数组，用来存储信息
		ArrayAdapter<String> arrayAdapter = null;// 创建ArrayAdapter对象
		// 以intType为条件进行判断
		
			
			MyloveDAO outaccountinfo = new MyloveDAO(MyloveMusic.this);// 创建OutaccountDAO对象
			// 获取所有信息，并存储到List泛型集合中
			List<Tb_mylove> listoutinfos = outaccountinfo.getScrollData();
			strInfos = new String[listoutinfos.size()];// 设置字符串数组的长度
			int i = 0;// 定义一个开始标识
			for (Tb_mylove tb_malove : listoutinfos) {// 遍历List泛型集合
				// 将相关信息存储到字符串数组的相应位置
				strInfos[i] = tb_malove.getName();		
				i++;// 标识加1
			}
			mylovenumber.setText("我喜欢("+i+")");
		
		// 使用字符串数组初始化ArrayAdapter对象
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, strInfos);
		myloveList.setAdapter(arrayAdapter);// 为ListView列表设置数据源
		myloveList.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?>listView,View view,int position,long id){
				MainActivity.main.play(MUSICPATH+"/"+strInfos[position]+".mp3");
				MainActivity.main.AddLatestMusic();
			}
		});   
	}
}
