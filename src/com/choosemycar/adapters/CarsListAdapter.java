package com.choosemycar.adapters;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.choosemycar.Car;
import com.choosemycar.CarDetailsActivity;
import com.choosemycar.R;
import com.choosemycar.utils.imageloader.ImageLoader;

public class CarsListAdapter extends BaseAdapter
{
	private Context mContext;
	private ImageLoader imageLoader;
	private List<Car> mList;

	public CarsListAdapter(Context context, ImageLoader imageLoader)
	{

		this.mContext = context;
		this.imageLoader = imageLoader;
	}

	public CarsListAdapter(Context context, List<Car> list,
			ImageLoader imageLoader)
	{

		this.mList = list;
		this.mContext = context;
		this.imageLoader = imageLoader;
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		final String name;
		final float price;
		final String url;
		final String topSpeed;
		final String fuelCons;
		final String power;
		final String torque;
		final String length;
		final String width;
		final String height;
		final String weight;//add hereee
		View rowView = convertView;
		ViewHolder mViewHolder = null;
		if (rowView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.view_list_row, null);
			mViewHolder = new ViewHolder();
			mViewHolder.mImage = (ImageView) rowView
					.findViewById(R.id.list_image);
			mViewHolder.mText = (TextView) rowView.findViewById(R.id.car_name);
			mViewHolder.mText.setText(mList.get(position).getName());
			mViewHolder.mText.setTextColor(Color.parseColor("#FFFFFF"));
			mViewHolder.mText.setGravity(Gravity.CENTER_VERTICAL);
			name = mList.get(position).getName();
			price = mList.get(position).getPrice();
			topSpeed = mList.get(position).gettopSpeed();
			fuelCons = mList.get(position).getfuelCons();
			torque = mList.get(position).gettorque();
			power = mList.get(position).getpower();
			length = mList.get(position).getlength();
			width = mList.get(position).getwidth();
			height = mList.get(position).getheight();
			weight = mList.get(position).getweight();
			url=mList.get(position).getUrl();
			imageLoader.bind(mViewHolder.mImage, mList.get(position).getUrl());
			mViewHolder.mText.setOnClickListener(new OnClickListener()
			{

				public void onClick(View v)
				{
					Bundle bundle = new Bundle();
					bundle.putString("name", name);
					bundle.putFloat("price", price);
					bundle.putString("url", url);
					bundle.putString("topSpeed", topSpeed);
					bundle.putString("fuelCons", fuelCons);
					bundle.putString("torque", torque);
					bundle.putString("power",power);
					bundle.putString("length", length);
					bundle.putString("width", width);
					bundle.putString("height", height);
					bundle.putString("weight", weight);//add here
					
					Intent i = new Intent(mContext, CarDetailsActivity.class);
					i.putExtras(bundle);
					i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(i);
				}
			});

		}
		return rowView;

	}

	public class ViewHolder
	{

		public ImageView mImage;
		public TextView mText;

	}

}
