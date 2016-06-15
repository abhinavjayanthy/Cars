package com.choosemycar;

import java.util.List;

import com.choosemycar.Car;
import com.choosemycar.MySqliteHelper;
import com.choosemycar.R;
import com.choosemycar.adapters.CarsListAdapter;
import com.choosemycar.utils.imageloader.ImageLoader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class ActivityAllCarsList extends Activity {
	private List<Car> mlist;
	private ListView mlistview;
	private ImageLoader mImageLoader;
	private CarsListAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_cars_list);
		MySqliteHelper helper = new MySqliteHelper(getApplicationContext());
		mImageLoader = getImageLoader();
		mlist = helper.getAllCars();
		mlistview = (ListView) findViewById(R.id.carsList);
		mAdapter = new CarsListAdapter(getApplicationContext(), mlist, mImageLoader);
		mlistview.setAdapter(mAdapter);
	}
	public ImageLoader getImageLoader() {
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(getApplicationContext());
		}
		return this.mImageLoader;
	}

}
