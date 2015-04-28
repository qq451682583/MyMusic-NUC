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
		  
		// �����ַ������飬�����洢��Ϣ
		ArrayAdapter<String> arrayAdapter = null;// ����ArrayAdapter����
		// ��intTypeΪ���������ж�
		
			
			MyloveDAO outaccountinfo = new MyloveDAO(MyloveMusic.this);// ����OutaccountDAO����
			// ��ȡ������Ϣ�����洢��List���ͼ�����
			List<Tb_mylove> listoutinfos = outaccountinfo.getScrollData();
			strInfos = new String[listoutinfos.size()];// �����ַ�������ĳ���
			int i = 0;// ����һ����ʼ��ʶ
			for (Tb_mylove tb_malove : listoutinfos) {// ����List���ͼ���
				// �������Ϣ�洢���ַ����������Ӧλ��
				strInfos[i] = tb_malove.getName();		
				i++;// ��ʶ��1
			}
			mylovenumber.setText("��ϲ��("+i+")");
		
		// ʹ���ַ��������ʼ��ArrayAdapter����
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, strInfos);
		myloveList.setAdapter(arrayAdapter);// ΪListView�б���������Դ
		myloveList.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?>listView,View view,int position,long id){
				MainActivity.main.play(MUSICPATH+"/"+strInfos[position]+".mp3");
				MainActivity.main.AddLatestMusic();
			}
		});   
	}
}
