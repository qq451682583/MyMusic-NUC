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
	String[] strInfos = null;// �����ַ������飬�����洢��Ϣ
																														
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
		
		
		ArrayAdapter<String> arrayAdapter = null;// ����ArrayAdapter����
		// ��intTypeΪ���������ж�
		
			
			LatestplayDAO outaccountinfo = new LatestplayDAO(Latestplay.this);// ����OutaccountDAO����
			// ��ȡ������Ϣ�����洢��List���ͼ�����
			List<Tb_latest> listoutinfos = outaccountinfo.getScrollData();
			strInfos = new String[listoutinfos.size()];// �����ַ�������ĳ���
			int i = 0;// ����һ����ʼ��ʶ
			for (Tb_latest tb_latest : listoutinfos) {// ����List���ͼ���
				// �������Ϣ�洢���ַ����������Ӧλ��
				strInfos[i] = tb_latest.getName();
				i++;// ��ʶ��1
			}
			latestnumber.setText("�������("+i+")");
		
		// ʹ���ַ��������ʼ��ArrayAdapter����
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, strInfos);
		latestList.setAdapter(arrayAdapter);// ΪListView�б���������Դ
		
		latestList.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?>listView,View view,int position,long id){
				MainActivity.main.play(MUSICPATH+"/"+strInfos[position]+".mp3");
				Toast.makeText(Latestplay.this, strInfos[position], Toast.LENGTH_LONG).show();
			}
		});   
	}
}
