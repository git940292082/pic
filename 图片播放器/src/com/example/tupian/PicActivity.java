package com.example.tupian;


import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;

public class PicActivity extends Activity implements OnClickListener{

	private Button btNext;
	private Button btPrevius;
	private boolean isView=true;
	private int position;
	private Button btAuto;
	private ImageSwitcher imgs;
	private PictureThread thread;
	private int downx;
	private Animation leftIn;
	private Animation leftOut;
	private Animation rightIn;
	private Animation rightOut;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pic);
		Intent intent=getIntent();
		btPrevius=(Button)findViewById(R.id.previouse);
		btNext=(Button)findViewById(R.id.next);
		btAuto=(Button)findViewById(R.id.auto);
		imgs=(ImageSwitcher)findViewById(R.id.imgs);
		imgs.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView img = new ImageView(getApplicationContext());
				LayoutParams lp=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
				img.setLayoutParams(lp);
				img.setScaleType(ScaleType.CENTER_INSIDE);
				return img;
			}
		});
		btPrevius.setOnClickListener(this);
		btNext.setOnClickListener(this);
		//		img.setOnClickListener(this);
		btAuto.setOnClickListener(this);
		position=intent.getIntExtra("id", 0);
		show();
		leftIn=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_in);
		leftOut=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_out);
		rightIn=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
		rightOut=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_out);

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pic, menu);
		return true;
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.next:
			next();
			break;
		case R.id.previouse:
			previous();
			break;
		case R.id.imageView1:
			if(isView){
				btNext.setVisibility(View.VISIBLE);
				btPrevius.setVisibility(View.VISIBLE);
				btAuto.setVisibility(View.VISIBLE);
				isView=false;
			}else{
				btNext.setVisibility(View.GONE);
				btPrevius.setVisibility(View.GONE);
				btAuto.setVisibility(View.GONE);
				isView=true;
			}
			break;
		case R.id.auto:
			btAuto.setText("Í£Ö¹²¥·Å");
			btNext.setVisibility(View.GONE);
			btPrevius.setVisibility(View.GONE);
			btAuto.setVisibility(View.GONE);
			isView=true;

		}
	}

	void show(){

		thread=new PictureThread(imgs);
		thread.execute(position);
	}
	void next(){
		imgs.setInAnimation(rightIn);
		imgs.setOutAnimation(leftOut);
		position++;
		if(position==MainActivity.pictures.size()){
			position=0;
		}
		show();
	}
	void previous(){
		imgs.setInAnimation(leftIn);
		imgs.setOutAnimation(rightOut);
		position--;
		if(position<0){
			position=MainActivity.pictures.size()-1;
		}
		show();
	}
	public class PictureThread extends AsyncTask<Integer,Bitmap,Bitmap> {
		private ImageSwitcher imgs;
		public PictureThread(ImageSwitcher imgs) {
			super();
			this.imgs = imgs;
		}

		@Override
		protected Bitmap doInBackground(Integer... position) {
			return BitmapFactory.decodeFile(MainActivity.pictures.get(position[0]).getPath()) ;

		}

		@TargetApi(Build.VERSION_CODES.HONEYCOMB)
		@Override
		protected void onPostExecute(Bitmap result) {
			Drawable drawable=new BitmapDrawable(getResources(),result);
			imgs.setImageDrawable(drawable);;
		}
	}
	@SuppressLint("NewApi")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			downx = (int) event.getX();
			
			Log.i("123", event.getX()+"");
			break;
		case MotionEvent.ACTION_UP:
			if(downx-event.getX()>500){
				imgs.setX(0);
				next();
			}
			if(downx-event.getX()<-500){
				imgs.setX(0);
				previous();
			}

			Log.i("123", downx-event.getX()+"");
			break;
		case MotionEvent.ACTION_MOVE:
			imgs.setX(event.getX()-downx);
		}

		return super.onTouchEvent(event);
	}
}