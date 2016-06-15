package com.choosemycar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.choosemycar.utils.imageloader.ImageLoader;

public class CarDetailsActivity extends Activity
{
	private TextView mName;
	private TextView mPrice;
	private ImageView mCarImage;
	private ImageLoader imageLoader;
	private TextView mtopSpeed;
	private TextView mfuelCons;
	private TextView mtorque;
	private TextView mpower;
	private TextView mlength;
	private TextView mwidth;
	private TextView mheight;
	private TextView mweight;//add next here too

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);

		Bundle b = this.getIntent().getExtras();
		String name = b.getString("name");
		float price = b.getFloat("price");
		String priceText = Float.toString(price);
		String url = b.getString("url");
		String topSpeed = b.getString("topSpeed");
		String fuelCons = b.getString("fuelCons");
		String torque = b.getString("torque");
		String power = b.getString("power");
		String length = b.getString("length");
		String width = b.getString("width");
		String height = b.getString("height");
		String weight = b.getString("weight");//add next here
		setContentView(R.layout.view_car_details);
		mName = (TextView) findViewById(R.id.name);
		mPrice = (TextView) findViewById(R.id.price);
		mtopSpeed = (TextView) findViewById(R.id.topspeed);
		mfuelCons = (TextView) findViewById(R.id.fuelCons);
		mtorque = (TextView) findViewById(R.id.torque);
		mpower = (TextView) findViewById(R.id.power);
		mlength = (TextView) findViewById(R.id.length);
		mwidth = (TextView) findViewById(R.id.width);
		mheight = (TextView) findViewById(R.id.height);
		mweight = (TextView) findViewById(R.id.weight);//add next herreeeee
		mCarImage = (ImageView) findViewById(R.id.selected_car);
		imageLoader = getImageLoader();
		imageLoader.bind(mCarImage, url);
		mName.setText(name);
		mPrice.setText(priceText);
		mtopSpeed.setText(topSpeed);
		mfuelCons.setText(fuelCons);
		mtorque.setText(torque);
		mpower.setText(power);
		mlength.setText(length);
		mwidth.setText(width);
		mheight.setText(height);
		mweight.setText(weight);//add nexxxxtttt here
		
	}

	public ImageLoader getImageLoader()
	{
		if (imageLoader == null) {
			imageLoader = new ImageLoader(this);
		}
		return this.imageLoader;
	}
}
