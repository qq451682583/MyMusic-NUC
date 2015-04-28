package com.example.player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.DB.LatestplayDAO;
import com.example.DB.MyloveDAO;
import com.example.DB.Tb_latest;
import com.example.DB.Tb_mylove;


public class MainActivity extends Activity {
	public MediaPlayer player = new MediaPlayer();
	public List<String> audioList = new ArrayList<String>();
	public List<String> audioList1 = new ArrayList<String>();
	public int currentItem = 0;
	private Button pause;
	private SeekBar seekBar;
	private TextView currenttime1,alltime1,number;
	public TextView name;
	Button take,back;
	ListView listview;
	public static MainActivity main = null;
	private String MUSICPATH = "/sdcard";
	public int musicnumber = 0;
	private Button geshou,mygedan,mylove,mv,gengduo,aixin,btnlatestplay,xiazaiguanli;
	public Button textlogin;
	public final static String HELLO = "com.example.player.MESSAGE";
	private int t = 0;//用于记录登录状态
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ExitApplication.getInstance().addActivity(this);            
        //init();
//        sound();  
        
        
        
        main = this;
        doit();    
       
    }



	private void doit() {
		// TODO Auto-generated method stub
		take = (Button)findViewById(R.id.Yueku);
		back = (Button)findViewById(R.id.back);
		geshou = (Button)findViewById(R.id.btnGeshou);
		mygedan = (Button)findViewById(R.id.btnMylist);
		mylove = (Button)findViewById(R.id.butMylove);
		mv = (Button)findViewById(R.id.btnMv);
		gengduo = (Button)findViewById(R.id.btnGengduo);
		textlogin = (Button)findViewById(R.id.textlogin111);
		btnlatestplay = (Button)findViewById(R.id.btnLatestplay);
		xiazaiguanli = (Button)findViewById(R.id.btnXiazaiguanli);
		name = (TextView)findViewById(R.id.nametext);
		
		aixin = (Button)findViewById(R.id.aixin);
		aixin.setEnabled(false);
		
		
		take.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,Search.class);
				intent.putExtra(HELLO, "http://play.baidu.com/");
				startActivity(intent);
				//overridePendingTransition(R.layout.activity_main, R.layout.search);
			} 
		});
		
		geshou.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,Search.class);
				intent.putExtra(HELLO, "http://music.baidu.com/artist");
				startActivity(intent);
			}
		});
		
		xiazaiguanli.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,Download.class);
//				intent.putExtra(HELLO, "http://music.baidu.com/artist");
				startActivity(intent);
			}
		});
		
		mv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,Search.class);
				intent.putExtra(HELLO, "http://music.baidu.com/mv");
				startActivity(intent);
			}
		});
		
		gengduo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(MainActivity.this,Setting.class);
				startActivity(in);
			}
		});
		
		mygedan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(MainActivity.this,LocalMusic.class);
				startActivity(in);
			}
		});
		
		mylove.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(textlogin.getText().equals("登录")){
					Intent in = new Intent(MainActivity.this,Login.class);
					startActivity(in);
					t = 1;
				}else{
				Intent in = new Intent(MainActivity.this,MyloveMusic.class);
				startActivity(in);
				}
			}
		});
		
		aixin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(textlogin.getText().equals("登录")){
					Intent in = new Intent(MainActivity.this,Login.class);
					startActivity(in);
					t = 1;
				}else{
				 MyloveDAO myloveDAO = new MyloveDAO(MainActivity.this);
				 String str11 = audioList.get(currentItem).toString();
			     String[] strarray = str11.split("/");
				 String ss =  strarray[strarray.length-1];
				 String[] strarray1 = ss.split(".mp3");
				 String ss1 = strarray1[0];
				 if(myloveDAO.Check(ss1).equals("none"))
				 {
					 Tb_mylove tb_mylove = new Tb_mylove(ss1);
					 myloveDAO.add(tb_mylove);
					 
					 Toast.makeText(MainActivity.this, "收藏成功！", Toast.LENGTH_SHORT)
					.show();
				 }
				 else{
					 Toast.makeText(MainActivity.this, "此歌曲已收藏！", Toast.LENGTH_SHORT)
						.show();
				 }	
				}
			}
		});
		
		textlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(textlogin.getText().equals("登录")){
					Intent in = new Intent(MainActivity.this,Login.class);
					startActivity(in);
					t = 1;
				}else{
					Intent intent = new Intent();
					intent.setClass(MainActivity.this,Mypage.class);
					intent.putExtra(HELLO, textlogin.getText());
					startActivity(intent);
				}			
			}
		});
		
		btnlatestplay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(MainActivity.this,Latestplay.class);
				startActivity(in);
			}
		});

	}

	/*private void sound() {
		// TODO Auto-generated method stub
		final AudioManager am = (AudioManager)MainActivity.this.getSystemService(Context.AUDIO_SERVICE);
		MainActivity.this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		SeekBar seekbar2 = (SeekBar)findViewById(R.id.seekyinliang);
		seekbar2.setMax(am.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
		final int progress1 = am.getStreamVolume(AudioManager.STREAM_MUSIC);
		seekbar2.setProgress(progress1);
		
		seekbar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int progress1, boolean arg2) {
				// TODO Auto-generated method stub
				am.setStreamVolume(AudioManager.STREAM_MUSIC, progress1, AudioManager.FLAG_PLAY_SOUND);
			}
		});
	}

*/
	private void init() { 	
		// TODO Auto-generated method stub
    	
    	currenttime1 = (TextView)findViewById(R.id.currenttime);
    	alltime1 = (TextView)findViewById(R.id.alltime);
    	seekBar = (SeekBar)findViewById(R.id.jindubar);
     	//Button play = (Button)findViewById(R.id.play);
     	//Button stop = (Button)findViewById(R.id.stop);
    	
     	final Button pause = (Button)findViewById(R.id.pause);
     	Button nextone = (Button)findViewById(R.id.nextone);
     	Button preone = (Button)findViewById(R.id.preone);
     	pause.setBackgroundResource(R.drawable.pause1);
     	audioList();
     	
     	player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer arg0) {
				// TODO Auto-generated method stub
				nextMusic();
				AddLatestMusic();
			}
		});
     	
     	seekBar.setMax(100);
     	seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generonStopTrackingTouchated method stub
				player.start();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				if(player.isPlaying()){
					player.pause();
				}
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				if(seekBar.isPressed()){
					player.seekTo(seekBar.getProgress()*player.getDuration()/seekBar.getMax());
				}
			}
		});
     	
     	
     	
     	preone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				preMusic();
				pause.setBackgroundResource(R.drawable.pause1);
				AddLatestMusic();
			}
		});
     	
     	pause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(player.isPlaying()){
					player.pause();
					((Button)v).setBackgroundResource(R.drawable.play1);
				}else{
					player.start();
					((Button)v).setBackgroundResource(R.drawable.pause1);
				}
			}
		});
     	

     	nextone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				nextMusic();
				AddLatestMusic();
				pause.setBackgroundResource(R.drawable.pause1);
			}
		});
     	this.updatesb.run();    	
	}
    
    public Runnable updatesb = new Runnable(){
		@Override
		public void run() {
			// TODO Auto-generated method stub
			SetSongTime();
			SetSeekBar();
			seekBar.postDelayed(updatesb,1000);
		}   	
    };
    
    public void AddLatestMusic(){
    	LatestplayDAO latestDAO = new LatestplayDAO(MainActivity.this);
		String str11 = audioList.get(currentItem).toString();
	     String[] strarray = str11.split("/");
		 String ss =  strarray[strarray.length-1];
		 String[] strarray1 = ss.split(".mp3");
		 String ss1 = strarray1[0];
		 if(latestDAO.Check(ss1).equals("none"))
		 {
			 Tb_latest tb_latest = new Tb_latest(ss1);
			 latestDAO.add(tb_latest);
		 }	 
    }
    
    public void SetSongTime(){
		 String str1,str2,str3,str4,str5;
		 int Current_fen = player.getCurrentPosition()/1000/60;
		 int Current_miao = player.getCurrentPosition()/1000%60;
		 int fen = player.getDuration()/1000/60;
		 int miao = player.getDuration()/1000%60;
		 
		 if(Current_fen<10){
			 str1 = "0" + Current_fen;
		 }else{
			 str1 = Current_fen + "";
		 }
		  
		 if(Current_miao < 10){
			 str2 = "0" + Current_miao;
		 }else{
			 str2 = Current_miao + "";
		 }
		 
		 if(fen < 10){
			 str3 = "0" + fen;
		 }else{
			 str3 = fen + "";
		 }
		 
		 if(miao < 10){
			 str4 = "0" + miao; 
		 }else{
			 str4 = miao + "";
		 }
		 
		 
		 number = (TextView)findViewById(R.id.number);
		 name.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,LocalMusic.class);
				startActivity(intent);
			}
		});
		 name.setMovementMethod(new ScrollingMovementMethod());
			
		 String str11 = audioList.get(currentItem).toString();
	     String[] strarray = str11.split("/");
		 String strq =  strarray[strarray.length-1];
		 String[] strarray1 = strq.split(".mp3");
		 str5 = strarray1[0];
		 
		 if(player.isPlaying()){
			 currenttime1.setText(str1 + ":" + str2);
			 alltime1.setText(str3 + ":" + str4);
			 name.setText(str5);
		 }else{
			 currenttime1.setText("00:00");
			 alltime1.setText("00:00");
			 name.setText("音乐你的生活！");
		 }
		 
		 number.setText(Integer.toString(currentItem)+"/"+Integer.toString(musicnumber));
	 }    
    
    public void audioList() {
		// TODO Auto-generated method stub
		getFile(MUSICPATH);
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,main.audioList);
//		localmusicList = (ListView)findViewById(R.id.localmusicList);
//		localmusicList.setAdapter(adapter);
//		localmusicList.setOnItemClickListener(new OnItemClickListener(){
//			public void onItemClick(AdapterView<?>listView,View view,int position,long id){
//				main.currentItem = position;
//				main.play(main.audioList.get(main.currentItem));
//			}
//		});
	}

    void getFile(String string) {
		// TODO Auto-generated method stub
//    	musicnumber = 0;
		File files = new File(string);
		File[] file = files.listFiles();
		try{
			for(File f:file){
				if(f.isDirectory()){
					getFile(f.getAbsolutePath());
				}else{
					if(isAudioFile(f.getPath())){
						//Toast.makeText(this, "正在扫描："+f.getPath(), 1).show();
						audioList.add(f.getPath());
						String str11 = f.getPath();
					     String[] strarray = str11.split("/");
						 String ss =  strarray[strarray.length-1];
						 String[] strarray1 = ss.split(".mp3");
						 String ss1 = strarray1[0];
						 audioList1.add(ss1);
						musicnumber++;
					}
				}
			}
//			Toast.makeText(this, "扫描完毕！共扫描到"+Integer.toString(musicnumber)+"首歌曲！", 1).show();
		}catch(Exception e){
			e.printStackTrace(); 
		}
	}

	private static String[] imageFormatSet = new String[]{"mp3","wav"};
    private static boolean isAudioFile(String path){
    	for(String format:imageFormatSet){
    		if(path.contains(format)){
    			return true;
    		}
    	}
    	return false;
    }
    
    void play(String path){
    	try{
    		if(player.isPlaying()){
    			player.stop();
    		}
    		player.reset();
    		player.setDataSource(path);
    		player.prepare();
    		player.start();
    		pause.setBackgroundResource(R.drawable.play1);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	 
	 void nextMusic(){
		 if(++currentItem>=audioList.size()){
			 currentItem = 0;
		 }
		 play(audioList.get(currentItem));
	 }
	 
	 void preMusic(){
		 if(--currentItem >= 0){
			 if(currentItem >= audioList.size()){
				 currentItem = 0;
			 }
		 }else{
			 currentItem = audioList.size()-1;
		 }
		 play(audioList.get(currentItem));
	 }
    
	 @Override
	protected void onDestroy(){
		 if(player.isPlaying()){
			 player.stop();
		 }
		 player.release();
		 super.onDestroy();
	 }
	 
	 public void SetSeekBar(){
		 int position = player.getCurrentPosition();
		 int mpMax = player.getDuration();
		 int sbMax = seekBar.getMax();
		 
		seekBar.setProgress(position*sbMax/mpMax);
	 }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maintop, menu);
           
        return true;
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.item1:
			init();
	        //sound(); 
	        aixin.setEnabled(true);
	        AddLatestMusic();
	        Toast.makeText(this, "扫描完毕！共扫描到"+Integer.toString(musicnumber)+"首歌曲！", 1).show();
	        break;

		case R.id.item2:
			Toast.makeText(this, "已是最新版本！", Toast.LENGTH_LONG).show();
		break;

		case R.id.item3:

		break;
		
		case R.id.item4:
			ExitApplication.getInstance().exit();
		break;
		
		}
		return false;
		
	}
    
}
