package com.example.tupian;

import java.util.List;

import com.example.tupian.adapter.PictureAdapter;
import com.example.tupian.adapter.Pictures;
import com.example.tupian.dao.IDao;
import com.example.tupian.dao.MusicFile;
import com.example.tupian.dao.PictureFratory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity  implements OnItemClickListener{

	private GridView lv;
	public static  List<Pictures> pictures;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(GridView)findViewById(R.id.gridView1);
		IDao<Pictures> dao = PictureFratory.newPictures(getContentResolver());
		pictures = dao.data();
		PictureAdapter adapter=new PictureAdapter(pictures, this);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent intent=new Intent(MainActivity.this,PicActivity.class);
			intent.putExtra("id", position);
			startActivity(intent);
		
	}

}
