package com.choosemycar;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.choosemycar.adapters.CarsListAdapter;
import com.choosemycar.utils.imageloader.ImageLoader;

public class ActivityCarsList extends Activity {
	ImageView splashimage;
	private RelativeLayout mLayout;
	private ListView mList;
	private CarsListAdapter mAdapter;
	private ImageLoader mImageLoader;
	private String[] mImagesArray;
	private List<Car> mCarsList;
	private String mMake;
	private String mClass;
	private Float mStartRange;
	private Float mEndRange;
	private TextView noCars;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_cars_list);
		splashimage = (ImageView)findViewById(R.id.splash);
		Bundle bundle = getIntent().getBundleExtra("values");
		if (bundle != null) {
			mMake = bundle.getString("selectedMake");
			mClass = bundle.getString("selectedClass");
			mStartRange = bundle.getFloat("startRange");
			mEndRange = bundle.getFloat("endRange");

		} else {

		}

	
		mImageLoader = getImageLoader();
		mList = (ListView) findViewById(R.id.carsList);
		noCars = (TextView) findViewById(R.id.text);

		MySqliteHelper helper = new MySqliteHelper(this);
		mCarsList = helper.getCars(mMake, mClass, mStartRange, mEndRange);
		
		if (mCarsList.isEmpty()) {
			noCars.setVisibility(View.VISIBLE);
Log.d("list is empty : ", "" + mCarsList.isEmpty());
		}

		else {
			mAdapter = new CarsListAdapter(this, mCarsList, mImageLoader);
			mList.setAdapter(mAdapter);

		}
		
	}

	public ImageLoader getImageLoader() {
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(getApplicationContext());
		}
		return this.mImageLoader;
	}

}
