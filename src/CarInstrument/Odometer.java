package CarInstrument;

// This class represents an Odometer
public class Odometer 
{
	private int mileage;
	
	// Constructor
	public Odometer(int m)
	{
		mileage = m;
	}
	
	// Copy constructor 
	public Odometer(Odometer od)
	{
		mileage = od.mileage;
	}
	
	// Increment the mileage by 1
	public void incrementMileage()
	{
		mileage++;
		if (mileage == 999999)
			mileage = 0;
	}
	
	// Getter mileage method
	public double getMileage()
	{
		return mileage;
	}
	
	// toString: report car's current mileage
	public String toString()
	{
		return "Car's current mileage: " + mileage;
	}

}
