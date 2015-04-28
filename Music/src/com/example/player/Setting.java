package com.example.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


class MyAdapter extends BaseAdapter{ 
    //�����Ķ��� 
    private Context context; 
    //ͼƬ���� 
    private Integer[] imgs = { 
            R.drawable.baoliuliang, R.drawable.tinggeshiqu, R.drawable.saomiaohechuange,  
            R.drawable.dinsghituichu, R.drawable.yinxiao, R.drawable.shezhi,                
    }; 
    MyAdapter(Context context){ 
        this.context = context; 
    } 
    @Override
	public int getCount() { 
        return imgs.length; 
    } 

    @Override
	public Object getItem(int item) { 
        return item; 
    } 

    @Override
	public long getItemId(int id) { 
        return id; 
    } 
     
    //����View���� 
    @Override
	public View getView(int position, View convertView, ViewGroup parent) { 
         ImageView imageView; 
            if (convertView == null) { 
                imageView = new ImageView(context); 
                imageView.setLayoutParams(new GridView.LayoutParams(180,180));//����ImageView���󲼾� 
                imageView.setAdjustViewBounds(false);//���ñ߽���� 
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//���ÿ̶ȵ����� 
                imageView.setPadding(8, 8, 8, 8);//���ü�� 
            }  
            else { 
                imageView = (ImageView) convertView; 
            } 
            imageView.setImageResource(imgs[position]);//ΪImageView����ͼƬ��Դ 
            return imageView; 
    }	
} 

class MyAdapter1 extends BaseAdapter{ 
    //�����Ķ��� 
    private Context context; 
    //ͼƬ���� 
    private Integer[] imgs = { 
            R.drawable.cailing, R.drawable.lingsheng, R.drawable.kge,  
            R.drawable.shouyinji, R.drawable.yingyong, R.drawable.kuyou,                
    }; 
    MyAdapter1(Context context){ 
        this.context = context; 
    } 
    @Override
	public int getCount() { 
        return imgs.length; 
    } 

    @Override
	public Object getItem(int item) { 
        return item; 
    } 

    @Override
	public long getItemId(int id) { 
        return id; 
    } 
     
    //����View���� 
    @Override
	public View getView(int position, View convertView, ViewGroup parent) { 
         ImageView imageView; 
            if (convertView == null) { 
                imageView = new ImageView(context); 
                imageView.setLayoutParams(new GridView.LayoutParams(334, 126));//����ImageView���󲼾� 
                imageView.setAdjustViewBounds(false);//���ñ߽���� 
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//���ÿ̶ȵ����� 
                imageView.setPadding(0,0,0,0);//���ü�� 
            }  
            else { 
                imageView = (ImageView) convertView; 
            } 
            imageView.setImageResource(imgs[position]);//ΪImageView����ͼƬ��Դ 
            return imageView; 
    }	
} 


public class Setting extends Activity{
	private Button exit,back;
	public final static String HELLOKITY = "com.example.player.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting);// ���ò����ļ�
		ExitApplication.getInstance().addActivity(this);
		
		GridView gv = (GridView)findViewById(R.id.GridViewshow); 
		GridView gw = (GridView)findViewById(R.id.GridViewshow1);
        //ΪGridView���������� 
        gv.setAdapter(new MyAdapter(this)); 
        gw.setAdapter(new MyAdapter1(this));
        //ע������¼� 
        gv.setOnItemClickListener(new OnItemClickListener() 
        { 
            @Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            { 
            	switch (position) {

        		case 0:
        			Toast.makeText(Setting.this, "�����ڴ��˹��ܵĸ���", Toast.LENGTH_LONG).show();
        	        break;
        		case 1:
        			Toast.makeText(Setting.this, "�����ڴ��˹��ܵĸ���", Toast.LENGTH_LONG).show();
        	        break;
        		case 2:
        			Toast.makeText(Setting.this, "�����ڴ��˹��ܵĸ���", Toast.LENGTH_LONG).show();
        	        break;
        		case 3:
        			Intent intent = new Intent(Setting.this,Timeclose.class);
        			startActivity(intent);
        	        break;
        		case 4:
        			Toast.makeText(Setting.this, "�����ڴ��˹��ܵĸ���", Toast.LENGTH_LONG).show();
        	        break;
        		case 5:
        			Intent intent1 = new Intent(Setting.this,Setdetalis.class);
        			startActivity(intent1);
        	        break;
        		}
            } 
        }); 
        gw.setOnItemClickListener(new OnItemClickListener() 
        { 
            @Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            { 
            	switch (position) {

        		case 0:
        			Intent intent0 = new Intent(Setting.this,Search.class);
        			intent0.putExtra(HELLOKITY, "http://ring.kugou.com/CaiRing/");
        			startActivity(intent0);
        	        break;
        		case 1:	
        			Intent intent1 = new Intent(Setting.this,Search.class);
        			intent1.putExtra(HELLOKITY, "http://mobilering.kugou.com/");
        			startActivity(intent1);
        	        break;
        		case 2:
        			Intent intent2 = new Intent(Setting.this,Search.class);
        			intent2.putExtra(HELLOKITY, "http://download.kugou.com/radio.html");
        			startActivity(intent2);
        	        break;
        		case 3:
        			Intent intent3 = new Intent(Setting.this,Search.class);
        			intent3.putExtra(HELLOKITY, "http://fanxing.kugou.com/");
        			startActivity(intent3);
        	        break;
        		case 4:
        			Intent intent4 = new Intent(Setting.this,Search.class);
        			intent4.putExtra(HELLOKITY, "http://yxtgg.37.com/?uid=1126903");
        			startActivity(intent4);
        	        break;
        		case 5:
        			Intent intent5 = new Intent(Setting.this,Search.class);
        			intent5.putExtra(HELLOKITY, "http://apk.hiapk.com/");
        			startActivity(intent5);
        	        break;
        		} 
            } 
        }); 
		
		init();
		
	}
	private void init() {
		// TODO Auto-generated method stub
		exit = (Button)findViewById(R.id.exit);
		back = (Button)findViewById(R.id.settingback);
		
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
				ExitApplication.getInstance().exit();
			}
		});
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
