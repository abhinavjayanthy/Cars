package com.choosemycar;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityFilterCars extends Activity {
	private Spinner mPriceRangeSpinner;
	private Spinner mMakeSpinner;
	private Spinner mClassSpinner;
	private ArrayAdapter<String> mAdapter;
	private String[] mPriceValues;
	private String[] mMakeValues;
	private String[] mClassValues;
	private Button mGetCars;
	private String mSelectedPrice;
	private String[] priceRange = null;
	private float mStartRange;
	private float mEndRange;
	private String mSelectedMAke;
	private String mSelectedClass;
	private Button mGetAllCarsButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_choose_price_range);
		init();
		MySqliteHelper helper= new MySqliteHelper(this);
		helper.addCar(new Car("Acura ILX","Acura","Luxury",1500000,"138 mph","35  mpg","150 bhp @6500rpm","140 lb/ft @ 4300rpm","179.1 in","70.6 in ","55.6  in","2955 lbs","http://www.blogcdn.com/www.autoblog.com/media/2013/05/001-2014-acura-ilx628opt.jpg"));
		helper.addCar(new Car("Acura MDX","Acura","Sports Utility",2000000,"140 mph","28  mpg","290 @ 6200","267 @ 4500","193.6  in","77.2 in","67.6  in","4025 lbs","http://upload.wikimedia.org/wikipedia/commons/b/bc/07-Acura-MDX.jpg"));
		helper.addCar(new Car("Audi R8","Audi","Coupe",3000000,"197 mph","21 mpg","518 bhp @8000rpm","391 lb/ft @6500rpm","174.6 in","76 in","49.3 in","3571 lbs","http://www.supercarworld.com/images/fullpics/430g.jpg"));
		helper.addCar(new Car("Audi TT","Audi","Copue",1500000,"150 mph","31  mpg","225 bhp @5900rpm","206 lb/ft @2200rpm","159 in","70 in","53 in","3219 lbs","http://www.supercarworld.com/images/fullpics/133d.jpg"));
		helper.addCar(new Car("BMW M5","BMW","Sedan", 6000000,"155 mph","19 mpg","507 bhp @7750rpm","384 lb/ft @6100rpm","191.1 in","72.7 in","57.8 in","4034 lbs","http://www.supercarworld.com/images/fullpics/270c.jpg"));
		helper.addCar(new Car("BMW Z4","BMW","Convertable", 2600000,"155 mph","31 mpg","231 bhp @5900rpm","221 lb/ft @3500rpm","161.1 in","70.1 in","51.1 in","2844 lbs","http://www.supercarworld.com/images/fullpics/218.jpg"));
		helper.addCar(new Car("Bugatti Veyron","Bugatti","Super",3500000,"254 mph","12 mpg","1001 bhp @6000rpm","922 lb/ft @2200rpm","175.7 in","78.7 in","47.4 in","4162 lbs","http://www.supercarworld.com/images/fullpics/180.jpg"));
		helper.addCar(new Car("Bugatti EB110","Bugatti","Super",2000000,"218 mph","20 mpg","611 bhp @8250rpm","480 lb/ft @3600rpm","171.6 in","76.4 in","43.9 in","3452 lbs","http://www.supercarworld.com/images/fullpics/050e.jpg"));
		helper.addCar(new Car("Ferrari 612 Scaglietti","Ferrari","Super",6000000,"196 mph","14 mpg","540 bhp @7200rpm","434 lb/ft @5200rpm","193 in","77 in","52.9 in","4101 lbs","http://www.supercarworld.com/images/fullpics/261c.jpg"));
		helper.addCar(new Car("Ferrari Enzo","Ferrari","Super",6000000,"219 mph","14 mpg","650 bhp @7800rpm","485 lb/ft @5500rpm","185.1 in","80.1 in","45.2 in","3009 lbs", "http://www.supercarworld.com/images/fullpics/175f.jpg"));
		helper.addCar(new Car("Ford GT","Ford","Coupe",3000000,"210 mph","14 mpg","550 bhp @6500rpm","500 lb/ft @3750rpm","181.6 in","76.8 in","43.5 in","3494 lbs ", "http://www.supercarworld.com/images/fullpics/195j.jpg"));
		helper.addCar(new Car("Ford Mustang Shelby GT500","Ford","Coupe",6000000,"170 mph","14 mpg","500 bhp @6000rpm","480 lb/ft @4500rpm","187.6 in","73.9 in","55.4 in","3920 lbs", "http://www.supercarworld.com/images/fullpics/332e.jpg"));
		helper.addCar(new Car("Honda NSX","Honda","Coupe",3000000,"171 mph","23 mpg","276 bhp @7300rpm","224 lb/ft @5300rpm","173 in","71 in","46 in","2910 lbs", "http://www.supercarworld.com/images/fullpics/004c.jpg"));
		helper.addCar(new Car("Honda S2000","Honda","Convertible",3000000,"150 mph","29 mpg","237 bhp @8300rpm","153 lb/ft @7500rpm","163 in","69 in","51 in","2778 lbs", "http://www.supercarworld.com/images/fullpics/072d.jpg"));
		helper.addCar(new Car("Lamborghini Gallardo","Lamborghini","Coupe",6000000,"192 mph","15 mpg","493 bhp @7800rpm","376 lb/ft @4500rpm","169.3 in","70 in","45.9 in","3350 lbs", "http://www.supercarworld.com/images/fullpics/230u.jpg"));
		helper.addCar(new Car("Lamborghini Gallardo","Lamborghini","Convertable",6000000,"192 mph","15 mpg","493 bhp @7800rpm","376 lb/ft @4500rpm","169.3 in","70 in","45.9 in","3350 lbs", "http://www.supercarworld.com/images/fullpics/230u.jpg"));
		helper.addCar(new Car("Lamborghini Reventon","Lamborghini","Coupe",6000000,"211 mph","15 mpg","650 bhp @8000rpm","487 lb/ft @6000rpm","185 in","81 in","44.7 in","3671 lbs", "http://www.supercarworld.com/images/fullpics/448.jpg"));
		helper.addCar(new Car("Lamborghini Reventon","Lamborghini","Convertable",6000000,"211 mph","15 mpg","650 bhp @8000rpm","487 lb/ft @6000rpm","185 in","81 in","44.7 in","3671 lbs", "http://www.supercarworld.com/images/fullpics/448.jpg"));
		helper.addCar(new Car("Porsche Cayman S","Porsche","Copue",6000000,"171 mph","27 mpg","291 bhp @6250rpm","251 lb/ft @4400rpm","170.9 in","70.9 in","51.5 in","2954 lbs", "http://www.supercarworld.com/images/fullpics/296d.jpg"));
		helper.addCar(new Car("Porsche Cayman S","Porsche","Convertable",6000000,"171 mph","27 mpg","291 bhp @6250rpm","251 lb/ft @4400rpm","170.9 in","70.9 in","51.5 in","2954 lbs", "http://www.supercarworld.com/images/fullpics/296d.jpg"));
		helper.addCar(new Car("Porsche Carrera GT","Porsche","Super",6000000,"206 mph","16 mpg","604 bhp @8000rpm","435 lb/ft @5750rpm","181.5 in","75.6 in","45.7 in","3042 lbs", "http://www.supercarworld.com/images/fullpics/014.jpg"));	
	}
	
	public void init() {
		initViews();
		initListeners();
		initObjects();

	}

	public void initViews() {
		mGetCars = (Button) findViewById(R.id.get_button);
		mPriceRangeSpinner = (Spinner) findViewById(R.id.price_range);
		mMakeSpinner = (Spinner) findViewById(R.id.make_spinner);
		mClassSpinner = (Spinner)findViewById(R.id.class_spinner);
		mGetAllCarsButton = (Button) findViewById(R.id.ViewAll);
		

	}

	public void initObjects(){
		mPriceValues = getResources().getStringArray(
				R.array.price_range);
		mMakeValues = getResources().getStringArray(
				R.array.make_of_cars);
		mClassValues =getResources().getStringArray(
				R.array.class_of_cars);
		
		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, mPriceValues);
		mPriceRangeSpinner.setAdapter(mAdapter);

		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, mMakeValues);
		mMakeSpinner.setAdapter(mAdapter);

		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, mClassValues);
		mClassSpinner.setAdapter(mAdapter);
	}
	public void initListeners() {

		mGetCars.setOnClickListener(mListener);
		mGetAllCarsButton.setOnClickListener(mListener);
		mPriceRangeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(position!=0){
				mSelectedPrice=mPriceRangeSpinner.getSelectedItem().toString();
				priceRange=	mSelectedPrice.split(" to ", 2);
				Log.d("selected is ", ""+priceRange[0] + " " + priceRange[1]);
				mStartRange=Float.parseFloat(priceRange[0]);
				mEndRange=Float.parseFloat(priceRange[1]);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
mMakeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
	if(position!=0){
		mSelectedMAke=parent.getSelectedItem().toString();
	}
	else{
		Toast.makeText(getApplicationContext(), "Please Select a Make", Toast.LENGTH_SHORT).show();
	}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
});
	

mClassSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		
			mSelectedClass=parent.getSelectedItem().toString();
			//Toast.makeText(getApplicationContext(), " Selected " + mSelectedClass, Toast.LENGTH_SHORT).show();
			
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
});
	}
		
	public OnClickListener mListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.get_button:
				Bundle bundle = new Bundle();
				bundle.putString("selectedMake", mSelectedMAke);
				bundle.putString("selectedClass", mSelectedClass);
				bundle.putFloat("startRange", mStartRange);
				bundle.putFloat("endRange",mEndRange);
				
				Intent i= new Intent(getApplicationContext(), ActivityCarsList.class);
				i.putExtra("values", bundle);
			startActivity(i);

				break;
			case R.id.ViewAll:
				Intent newIntent = new Intent(getApplicationContext(),ActivityAllCarsList.class);
			startActivity(newIntent);
				break;
			default:
				break;
			}

		}
	};
}
