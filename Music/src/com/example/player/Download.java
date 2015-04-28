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
	        
	        ArrayAdapter<String> arrayAdapter = null;// ����ArrayAdapter����
			// ��intTypeΪ���������ж�
			
				
				DownloadDAO outaccountinfo = new DownloadDAO(Download.this);// ����OutaccountDAO����
				// ��ȡ������Ϣ�����洢��List���ͼ�����
				List<Tb_download> listoutinfos = outaccountinfo.getScrollData();
				strInfos = new String[listoutinfos.size()];// �����ַ�������ĳ���
				int i = 0;// ����һ����ʼ��ʶ
				for (Tb_download tb_download : listoutinfos) {// ����List���ͼ���
					// �������Ϣ�洢���ַ����������Ӧλ��
					strInfos[i] = tb_download.getName();
					
					i++;// ��ʶ��1
				}
				downloadtext.setText("�������("+i+")");
			
			// ʹ���ַ��������ʼ��ArrayAdapter����
			arrayAdapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, strInfos);
			downloadlist.setAdapter(arrayAdapter);// ΪListView�б���������Դ
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
