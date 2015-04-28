package com.example.player;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

import com.example.DB.DownloadDAO;
import com.example.DB.Tb_download;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
//import com.mingrisoft.R;


public class Search extends Activity {
	private Camera camera;
	private boolean isPreview = false;
	private Button back;
	private TextView text;
	private ProgressBar downProgressBar = null;
	public static String save_path = "/";
	private TextView downloadProgressPercentage = null;
	public Handler handler = null;
	ProgressBar downloadProgressbar = null;
	private LinearLayout lin;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.search);//设置布局文件
        ExitApplication.getInstance().addActivity(this);
        
        Toast.makeText(this, "此功能会消耗部分流量,请注意!", Toast.LENGTH_LONG).show();
        
        init();
	}


	private void init() {
		// TODO Auto-generated method stu b
		text = (TextView)findViewById(R.id.textname);
		WebView webview = (WebView)findViewById(R.id.websreach);
		lin = (LinearLayout)findViewById(R.id.xiazaibar);
        downProgressBar = (ProgressBar)findViewById(R.id.download_progressbar);
        downloadProgressPercentage = (TextView)findViewById(R.id.downloadProgress_percentage);
        lin.setVisibility(View.GONE);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.HELLO);
		String message1  = intent.getStringExtra(Setting.HELLOKITY);
		
			if(message.contains("artist"))
			{
				text.setText("歌手");
			}else if(message.contains("mv"))
			{
				text.setText("MV");
			}else if(message.contains("play"))
			{
				text.setText("乐库");
			}
			if(message1.contains("CaiRing"))
			{
				text.setText("彩铃");
			}else if(message1.contains("mobilering.kugou"))
			{
				text.setText("铃声");
			}else if(message1.contains("download.kugou"))
			{
				text.setText("收音机");
			}else if(message1.contains("fanxing.kugou"))
			{
				text.setText("K歌女神");
			}else if(message1.contains("yxtgg.37"))
			{
				text.setText("酷游榜");
			}else if(message1.contains("ring"))
			{
				text.setText("精品应用");
			}
			webview.loadUrl(message);
			webview.loadUrl(message1);
		
		webview.requestFocus();
		webview.setDownloadListener(new myDownloaderListener());
		webview.getSettings().setJavaScriptEnabled(true);	//设置JavaScript可用
		webview.setWebChromeClient(new WebChromeClient());	//处理JavaScript对话框
		webview.setWebViewClient(new WebViewClient());
		
		
		back = (Button)findViewById(R.id.Yuekuback);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.item1:

			Toast.makeText(this, "已是最新版本！", Toast.LENGTH_LONG).show();

		break;

		case R.id.item2:		

		break;
		
		case R.id.item3:

			ExitApplication.getInstance().exit();

		break;
		
		}
		return false;
		
	}
	
	private class myDownloaderListener implements DownloadListener {

		@Override
		public void onDownloadStart(String url, String userAgent, String arg2,
				String arg3, long arg4) {
			// if the SD card can't be written or read,then toast
			if (!Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				Toast.makeText(getApplicationContext(), "无SDcard!",
						Toast.LENGTH_SHORT).show();
				return;
			} else {
				DownLoaderTask download_task = new DownLoaderTask();
				download_task.execute(url);
				// Toast.makeText(getApplicationContext(), url,
				// Toast.LENGTH_SHORT)
				// .show();
			}
		}
	}
    
    private class DownLoaderTask extends AsyncTask<String, Integer, String> {
    	String fileName,ss,ss1;
    	
		public DownLoaderTask() {

		}

		@Override
		protected String doInBackground(String... params) {
			String url = params[0];
			// default fileName is the after the last '\'
			
			String fileName1 = url.substring(url.lastIndexOf("/") + 1);
			try {
				// convert the fileName into UTF-8 format
				fileName1 = URLDecoder.decode(fileName1, "UTF-8");
				String str11 = fileName1;
			     String[] strarray = str11.split(".mp3");
				 ss =  strarray[0]+".mp3";
				 ss1 = strarray[0];
				 Log.e("ss", ss);
				Log.e("file11111", fileName1);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// save-path ,will self-define later
			File directory = Environment.getExternalStorageDirectory();
			File file = new File(directory, fileName1);

			if (file.exists()) {
				Toast.makeText(getApplicationContext(), "文件已存在",
						Toast.LENGTH_SHORT).show();
				return fileName1;
			}
			// if this file doesn't exist

			// Toast.makeText(getApplicationContext(),
			// "start downloading...", Toast.LENGTH_SHORT).show();
			Log.e("file:", Environment.getExternalStorageDirectory().toString());
			
			
			
			try {
				Log.e("file", url);
				File path = new File(Environment.getExternalStorageDirectory().toString()
						+ save_path);
				if (!path.exists()) {
					path.mkdir();
				}
				DownloadFile(Environment.getExternalStorageDirectory().toString()
						+ save_path, url, ss);
				Log.e("file", "started downloaad");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Log.e("file", "not start downloaad"+e.toString());
			}
			return fileName1;

		}

		@Override
		protected void onCancelled() {
			// TODO Auto-generated method stub
			super.onCancelled();
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Log.e("result", result);
			if (result == null) {
				Toast.makeText(getApplicationContext(), "no connection",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "歌曲下载成功！"+ss,
						Toast.LENGTH_SHORT).show();
				
				DownloadDAO downloadDAO = new DownloadDAO(Search.this);
				 if(downloadDAO.Check(ss1).equals("none"))
				 {
					 Tb_download tb_download = new Tb_download(ss1);
					 downloadDAO.add(tb_download);
				 }

				downProgressBar.setVisibility(View.GONE);
				downloadProgressPercentage.setVisibility(View.GONE);
				lin.setVisibility(View.GONE);
			}
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected void onProgressUpdate(final Integer... progresses) {
			downProgressBar.setVisibility(View.VISIBLE);
			lin.setVisibility(View.VISIBLE);
			downloadProgressPercentage.setVisibility(View.VISIBLE);
			downProgressBar.setProgress(progresses[0]);
			downloadProgressPercentage.setText("正在下载"+progresses[0] + "%");
			// through handler to send progress
//			Message msg = handler.obtainMessage();
//			msg.arg1 = progresses[0];
//			handler.sendMessage(msg);
			super.onProgressUpdate(progresses);
		}

		// functions
		public void DownloadFile(String path, String url, String fileName)
				throws IOException {
			long total_length = 0;
			int downloadedSize = 0;
			URL load_url = new URL(url);
			URLConnection connection = load_url.openConnection();
			connection.connect();
			// create the stream
			InputStream inStream = connection.getInputStream();
			total_length = connection.getContentLength();
			Log.e("legnth:", total_length + "");
			// Toast.makeText(getApplicationContext(),
			// "start downloading...", Toast.LENGTH_SHORT).show();
			if (total_length <= 0) {
				throw new RuntimeException("can't get the file_length!");
			}
			if (inStream == null) {
				throw new RuntimeException("can't get the file_stream!");
			}
			// create the output file
			FileOutputStream outputStream = new FileOutputStream(path
					+ fileName);
			byte[] buffer = new byte[2048];
			int temp_length = 0;
			while ((temp_length = inStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, temp_length);
				downloadedSize += temp_length;
				int cur_progress = (int) ((downloadedSize / (float) total_length) * 100);
				Log.e("progress",
						(int) ((downloadedSize / (float) total_length) * 100)
								+ "%");
				// send the progress
				publishProgress(cur_progress);
			}

			try {
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
			}
		}
	}
}
	

