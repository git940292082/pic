package com.example.tupian;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPageActivity extends Activity {

	private int Position;
	private PageAdapter adapter;
	private ViewPager viewPage;
	private List<View> list=new ArrayList<View>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_page);
		viewPage=(ViewPager)findViewById(R.id.viewpage);
		
		View page = getLayoutInflater().inflate(R.layout.viewpage, null);
		View page2 = getLayoutInflater().inflate(R.layout.viewpage2, null);
		list.add(page);
		list.add(page2);
		Intent in=getIntent();
		Position = in.getIntExtra("id", 0);
		adapter=new PageAdapter();
		viewPage.setAdapter(adapter);

	}

	public class PageAdapter extends PagerAdapter{
		private ImageView img;
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			View view =list.get(position);
			container.removeView(view);
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			View view=list.get(position);
			img=(ImageView) view.findViewById(R.id.imageView1);
			
			if(position==1){
				Position++;
			}else{
				Position--;
			}
			Bitmap bm=BitmapFactory.decodeFile(MainActivity.pictures.get(Position).getPath());
			img.setImageBitmap(bm);
			container.addView(view);
			return view;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}

	}
}
