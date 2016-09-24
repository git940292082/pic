package com.example.tupian.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.tupian.adapter.Pictures;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;


public class FiandMedia implements IDao<Pictures> {
	ContentResolver cr;
	private Pictures picture;
	public FiandMedia(ContentResolver cr) {
		super();
		this.cr = cr;
	}
	
	@Override
	public List<Pictures> data() {
		// TODO Auto-generated method stub
		List<Pictures> picures=new ArrayList<Pictures>();
		Uri uri=MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
		String[] projection={"_data","title","width","height"};
		Cursor csdb = cr.query(uri, projection, null, null, null);
		if(csdb.moveToFirst()){
			do{
				picture=new Pictures();
				picture.setPath(csdb.getString(0));
				picture.setTitle(csdb.getString(1));
				picture.setWidth(csdb.getInt(2));
				picture.setHeight(csdb.getInt(3));
				picures.add(picture);
			}while(csdb.moveToNext());
		}
		return picures;
	}

}
