package com.example.player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class LocalMusic extends Activity{
	public ListView localmusicList; 
	public Button back;
	public TextView setmusicnumber;
	public static LocalMusic localmusic = null;

	//final MainActivity main = new MainActivity();
																													
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.localmusic);
        ExitApplication.getInstance().addActivity(this);
        
        localmusic = this;
        
        localmusicList = (ListView)findViewById(R.id.localmusicList);
        setmusicnumber = (TextView)findViewById(R.id.setmusicnumber);
        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
			
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
		//MainActivity.main.getFile("/sdcard/kugoumusic");
		setmusicnumber.setText("±æµÿ“Ù¿÷("+Integer.toString(MainActivity.main.musicnumber)+")");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MainActivity.main.audioList1);
		localmusicList = (ListView)findViewById(R.id.localmusicList);
		localmusicList.setAdapter(adapter);
		localmusicList.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?>listView,View view,int position,long id){
				MainActivity.main.currentItem = position; 
				MainActivity.main.play(MainActivity.main.audioList.get(MainActivity.main.currentItem));		
				MainActivity.main.AddLatestMusic();
			}
		});   
	}
}
