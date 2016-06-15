package com.choosemycar;

public class Car
{
	private String mName;
	private String mMake;
	private String mClass;
	private float mPrice;
	private String mUrl;
	private String mtopSpeed,mfuelCons,mtorque,mpower,mlength,mwidth,mheight,mweight;
	public Car(String name, String make, String classOfCar, float price,String topSpeed,String fuelCons,String torque,String power,String length,String width,String height,String weight,String url)
	{
		this.mName = name;
		this.mMake = make;
		this.mClass = classOfCar;
		this.mPrice = price;
		this.mUrl = url;
		this.mfuelCons = fuelCons;
		this.mtopSpeed = topSpeed;
		this.mtorque = torque;
		this.mpower = power;
		this.mlength = length;
		this.mwidth = width;
		this.mheight = height;
		this.mweight = weight;

	}

	public String getName()
	{

		return mName;

	}

	public String getMake()
	{

		return mMake;

	}

	public float getPrice()
	{

		return mPrice;

	}

	public String getClassOfCar()
	{

		return mClass;

	}
	public String getfuelCons()
	{

		return mfuelCons;

	}

	public String getUrl()
	{

		return mUrl;

	}
	public String gettopSpeed()
	{
		return mtopSpeed;
	}
	public String gettorque()
	{
		return mtorque;
	}
	public String getlength()
	{
		return mlength;
	}
	public String getpower()
	{
		return mpower;
	}
	public String getwidth()
	{
		return mwidth;
	}
	public String getheight()
	{
		return mheight;
	}
	public String getweight()
	{
		return mweight;
	}

	public void setName(String Name)
	{

		this.mName = Name;

	}

	public void setMake(String Make)
	{

		this.mMake = Make;

	}

	public void setClassOfCar(String classOfCar)
	{

		this.mClass = classOfCar;

	}

	public void setPrice(float Price)
	{

		this.mPrice = Price;

	}

	public void setUrl(String Url)
	{

		this.mUrl = Url;

	}
	public void settopSpeeed(String topSpeed)
	{
		this.mtopSpeed = topSpeed;
	}
	public void settorque(String torque)
	{
		this.mtorque = torque;
	}
	public void setpower(String power)
	{
		this.mpower = power;
	}
	public void setlength(String length)
	{
		this.mlength = length;
	}
	public void setwidth(String width)
	{
		this.mwidth = width;
	}
	public void setheight(String height)
	{
		this.mheight = height;
	}
	public void setweight(String weight)
	{
		this.mweight = weight;
	}
	public void setfuelCons(String fuelCons)
	{
		this.mfuelCons = fuelCons;
	}

}
