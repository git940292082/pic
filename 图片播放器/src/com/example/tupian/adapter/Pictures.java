package com.example.tupian.adapter;

import android.graphics.Bitmap;

public class Pictures {
	private String Path;
	private String Title;
	private int Width;
	private int Height;
	private Bitmap bitmap;


	/**
	 * @return the bitmap
	 */
	public Bitmap getBitmap() {
		return bitmap;
	}
	/**
	 * @param bitmap the bitmap to set
	 */
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return Path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		Path = path;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return Width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		Width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return Height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		Height = height;
	}


}
