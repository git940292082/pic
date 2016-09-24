package com.example.tupian.dao;

import com.example.tupian.adapter.Pictures;

import android.content.ContentResolver;

public abstract class PictureFratory {
	public static IDao<Pictures> newPictures(ContentResolver cr){
		return new FiandMedia(cr);
	}
	
	
}
