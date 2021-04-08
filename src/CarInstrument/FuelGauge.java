package CarInstrument;

// This class represents a Fuel Gauge
public class FuelGauge 
{
	private int fuel;
	
	// Constructor
	public FuelGauge(int f)
	{
		fuel = f;
	}
	
	// Copy constructor
	public FuelGauge(FuelGauge fg)
	{
		fuel = fg.fuel;
	}
	
	// Increment amount of fuel by 1
	public void incrementFuel()
	{
		fuel++;
	}
	
	// Increment amount of fuel by a number passed in
	public void incrementFuel(double g)
	{
		fuel += g;
	}
	
	// Decrement amount of fuel by 1
	public void decrementFuel()
	{
		fuel--;
	}
	
	// Decrement amount of fuel by a number passed in
	public void decrementFuel(double g)
	{
		fuel -= g;
	}
	
	// Getter fuel method
	public double getFuel()
	{
		return fuel;
	}
	
	// Report car's current amount of fuel
	public String toString()
	{
		return "The car has " + fuel + " gallons of fuel left.";
	}
}
