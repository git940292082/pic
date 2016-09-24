package com.example.tupian.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MyAdapter<T>  extends BaseAdapter{
	private List<T> data;
	private Context context;
	private LayoutInflater inflater;
	
	public MyAdapter(List<T> data, Context context) {
		super();
		setContext(context);
		setData(data);
		inflater=LayoutInflater.from(this.context);
	}
	
	/**
	 * @return the data
	 */
	protected List<T> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	private void setData(List<T> data) {
		if(data==null){
			data=new ArrayList<T>();
		}
		this.data = data;
	}

	/**
	 * @return the inflater
	 */
	protected LayoutInflater getInflater() {
		return inflater;
	}



	/**
	 * @param context the context to set
	 */
	private void setContext(Context context) {
		if(context==null){
			throw new IllegalArgumentException("参数不能为空");
		}else{
			this.context = context;
		}
	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
