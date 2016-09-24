package com.example.tupian.adapter;

import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.tupian.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PictureAdapter extends MyAdapter<Pictures>{
	private PictureThread cache;
	ImageView [] imageView;
	private Map<View,PictureThread> mapCache=new HashMap<View, PictureAdapter.PictureThread>();
	public PictureAdapter(List<Pictures> data, Context context) {
		super(data, context);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HolderView holederView=new HolderView();
		if(convertView==null){
			convertView=getInflater().inflate(R.layout.list_picture, null);

			holederView.img=(ImageView) convertView.findViewById(R.id.imageView1);

			holederView.tv=(TextView)convertView.findViewById(R.id.textView1);

			convertView.setTag(holederView);
		}else{
			holederView=(HolderView) convertView.getTag();
		}
		cache=mapCache.get(convertView);
		if(cache!=null){
			cache.cancel(true);
		}

		cache=new PictureThread(holederView.img);
		cache.execute(position);
		mapCache.put(convertView, cache);
		return convertView;
	}
	public class HolderView{
		ImageView img;
		TextView tv;
	}

	public class PictureThread extends AsyncTask<Integer,Bitmap,Bitmap> {
		private int min;
		private static final int max=100;
		private ImageView img;

		public PictureThread(ImageView img) {
			super();
			this.img = img;
		}
		@Override
		protected Bitmap doInBackground(Integer... position) {
			// TODO Auto-generated method stub
			Bitmap bm = null;
			if(getData().get(position[0]).getBitmap()==null){
				int width=getData().get(position[0]).getWidth();
				int height=getData().get(position[0]).getHeight();
				if(width>max&&height>max){
					if(width>height){
						min=width/max;
					}else{
						min=height/max;
					}
				} 
				Options opts=new Options();
				opts.inSampleSize=min;
				bm=BitmapFactory.decodeFile(getData().get(position[0]).getPath(), opts);
				ObjectOutputStream out;
				getData().get(position[0]).setBitmap(bm);
			}else{
					bm=getData().get(position[0]).getBitmap();
			}
			return bm;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			img.setImageBitmap(result);
		}
	}
}
