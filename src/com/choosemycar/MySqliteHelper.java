package com.choosemycar;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class MySqliteHelper extends SQLiteOpenHelper
{

	private static final String DATABASE_NAME = "cars.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "myCarsList";
	private static final String COLUMN_NAME = "name";
	private static final String COLUMN_MAKE = "make";
	private static final String COLUMN_PRICE = "price";
	private static final String COLUMN_CLASS = "class";
	private static final String COLUMN_IMAGE = "imageUrl";
	private static final String COLUMN_TOP_SPEED = "topSpeed";
	private static final String COLUMN_FUELCONS = "fuelCons";
	private static final String COLUMN_TORQUE = "torque";
	private static final String COLUMN_POWER = "power";
	private static final String COLUMN_LENGTH = "length";
	private static final String COLUMN_WIDTH = "width";
	private static final String COLUMN_HEIGHT = "height";
	private static final String COLUMN_WEIGHT = "weight";
	private static final String TABLE_CREATE = "create table " + TABLE_NAME
			+ "(" + COLUMN_NAME + " VARCHAR(80) ," + COLUMN_MAKE
			+ " VARCHAR(20) ," + COLUMN_CLASS + " VARCHAR(20) ," + COLUMN_PRICE
			+ " INT(10) ," + COLUMN_TOP_SPEED +" VARCHAR(20) ," + COLUMN_FUELCONS +" VARCHAR(20) ," 
			+ COLUMN_POWER + " VARCHAR(20) ," + COLUMN_TORQUE + " VARCHAR(20) ," + COLUMN_LENGTH + " VARCHAR(20) ," 
			+ COLUMN_WIDTH + " VARCHAR(20) ," + COLUMN_HEIGHT + " VARCHAR(20) ," + COLUMN_WEIGHT + " VARCHAR(20) ," 
			+ COLUMN_IMAGE + " VARCHAR(500));";

	public MySqliteHelper(Context c)
	{

		super(c, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public MySqliteHelper(Context context, String name, CursorFactory factory,
			int version)
	{
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(TABLE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		Log.w(MySqliteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);

	}

	public void addCar(Car car)
	{

		SQLiteDatabase datbase = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(COLUMN_NAME, car.getName());
		contentValues.put(COLUMN_MAKE, car.getMake());
		contentValues.put(COLUMN_CLASS, car.getClassOfCar());
		contentValues.put(COLUMN_PRICE, car.getPrice());
		contentValues.put(COLUMN_FUELCONS, car.getfuelCons());
		contentValues.put(COLUMN_TOP_SPEED, car.gettopSpeed());
		contentValues.put(COLUMN_TORQUE, car.gettorque());
		contentValues.put(COLUMN_POWER, car.getpower());
		contentValues.put(COLUMN_LENGTH, car.getlength());
		contentValues.put(COLUMN_WIDTH, car.getwidth());
		contentValues.put(COLUMN_HEIGHT, car.getheight());
		contentValues.put(COLUMN_WEIGHT, car.getweight());
		contentValues.put(COLUMN_IMAGE, car.getUrl());
		datbase.insert(TABLE_NAME, null, contentValues);

		datbase.close();

	}

	public List<Car> getCarsBAsedonMake(String make)
	{
		List<Car> filteredCars = new ArrayList<Car>();
		String getColumnQuery = "SELECT * "+ " FROM " + TABLE_NAME
				+ " WHERE " + COLUMN_MAKE + "=" + make;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(getColumnQuery, null);
		if (cursor.moveToFirst()) {
			do {

				Car filteredCar = new Car(cursor.getString(0),
						cursor.getString(1), cursor.getString(2),
						cursor.getFloat(3), cursor.getString(4),cursor.getString(5),cursor.getString(6)
						,cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12));
				filteredCars.add(filteredCar);

			} while (cursor.moveToNext());

		}
		cursor.close();
		return filteredCars;

	}
	
	
	public List<Car> getCarsBAsedonClass(String classOfCar)
	{
		List<Car> filteredCars = new ArrayList<Car>();
		String getColumnQuery = "SELECT * "+ " FROM " + TABLE_NAME
				+ " WHERE " + COLUMN_CLASS + "=" + classOfCar;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(getColumnQuery, null);
		if (cursor.moveToFirst()) {
			do {

				Car filteredCar = new Car(cursor.getString(0),
						cursor.getString(1), cursor.getString(2),
						cursor.getFloat(3), cursor.getString(4),cursor.getString(5),cursor.getString(6)
						,cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12));
				filteredCars.add(filteredCar);

			} while (cursor.moveToNext());

		}
		cursor.close();
		return filteredCars;

	}
	
	public List<Car> getCarsBAsedonPrice(float startRange, float endRange)
	{
		List<Car> filteredCars = new ArrayList<Car>();
		String getColumnQuery = "SELECT * "+ " FROM " + TABLE_NAME
				+ " WHERE " + COLUMN_PRICE + " between " + startRange +" and " + endRange;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(getColumnQuery, null);
		if (cursor.moveToFirst()) {
			do {

				Car filteredCar = new Car(cursor.getString(0),
						cursor.getString(1), cursor.getString(2),
						cursor.getFloat(3), cursor.getString(4),cursor.getString(5),cursor.getString(6)
						,cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12));
				filteredCars.add(filteredCar);

			} while (cursor.moveToNext());

		}
		cursor.close();
		return filteredCars;

	}
	
	public List<Car> getAllCars()
	{
		List<Car> filteredCars = new ArrayList<Car>();
		String getColumnQuery = "SELECT * FROM " + TABLE_NAME;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(getColumnQuery, null);
		if (cursor.moveToFirst()) {
			do {

				Car filteredCar = new Car(cursor.getString(0),
						cursor.getString(1), cursor.getString(2),
						cursor.getFloat(3), cursor.getString(4),cursor.getString(5),cursor.getString(6)
						,cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12));
				filteredCars.add(filteredCar);

			} while (cursor.moveToNext());

		}
		cursor.close();
		return filteredCars;

	}

	public List<Car> getCars(String make,String classOfCar,float startRange, float endRange)
	{
		List<Car> filteredCars = new ArrayList<Car>();
		String getColumnQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_MAKE + "='" + make + "' and " + COLUMN_CLASS + "='" + classOfCar+ "' and "+ COLUMN_PRICE + " between " + startRange +" and " + endRange;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(getColumnQuery, null);
		if (cursor.moveToFirst()) {
			do {

				Car filteredCar = new Car(cursor.getString(0),
						cursor.getString(1), cursor.getString(2),
						cursor.getFloat(3), cursor.getString(4),cursor.getString(5),cursor.getString(6)
						,cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12));
				filteredCars.add(filteredCar);

			} while (cursor.moveToNext());

		}
		cursor.close();
		return filteredCars;

	}
}
