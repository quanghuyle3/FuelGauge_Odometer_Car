package CarInstrument;

import java.util.Scanner;

/**
 * This program demonstrates a Fuel Gauge object and Odometer object of a car
 * @author qle
 *
 */

public class CarDemo {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int num;
		
		// Initialize a FuelGauge object and Odometer object
		System.out.println("What is the amount of fuel gallons in your car now? (Max: 15gallons) ");
		num = input.nextInt();
		FuelGauge fg = new FuelGauge(num);
		System.out.println("What is the current mileage of your car? ");
		num = input.nextInt();
		Odometer odo = new Odometer(num);
		
		int goMile = 0; // mile accumulator for decreasing amount of fuel
		int driverAnswer = 0;
		// Flags to mark if the computer has asked driver to fuel gas
		boolean check10 = false;
		boolean check5 = false;
		boolean check3 = false;
		boolean check1 = false;
		
		while (fg.getFuel() > 0)
		{
			odo.incrementMileage();
			goMile++;
			
			// Decrement the amount of fuel by 1 for every 24 miles go
			if (goMile == 24)
			{
				fg.decrementFuel();
				goMile = 0;
			}
			
			
			// Present what the car has left
			System.out.println("\n" + fg);
			System.out.println(odo);
			
			
			// Check in with the driver if he need to fuel gas when it has little fuel
			if ((fg.getFuel() == 10 && !check10))
			{
				driverAnswer = checkinDriver(fg, odo);
				check10 = true;
			}
			else if ((fg.getFuel() == 5 && !check5))
			{
				driverAnswer = checkinDriver(fg, odo);
				check5 = true;
			}
			else if ((fg.getFuel() == 3 && !check3))
			{
				driverAnswer = checkinDriver(fg, odo);
				check3 = true;
			}
			else if ((fg.getFuel() == 1 && !check1))
			{
				driverAnswer = checkinDriver(fg, odo);
				check1 = true;
			}
			
			// Once the driver fuel more gas, allow computer to ask the driver again at those original marks
			if (driverAnswer == 1)
			{
				check10 = false;
				check5 = false;
				check3 = false;
				check1 = false;
			}
				
			
			// Sleep a bit
			try
			{
			    Thread.sleep(300);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
		}

	}
	
	/**
	 * This method check-in the driver if he/she need to fuel more gas
	 * @param f The FuelGauge object of car
	 * @param o The Odometer object of car
	 * @return The answer of driver
	 */
	public static int checkinDriver(FuelGauge f, Odometer o)
	{
		System.out.print("\nDo you want to: "
				+ "\n1. Fuel more gas "
				+ "\n2. Continue driving (I fuel later)"
				+ "\n- ");
		
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		// Input validation
		while (!(num == 1 || num == 2))
		{
			System.out.println("Invalid selection. Enter again:");
			num = input.nextInt();
		}

		// Get the gallons
		if (num == 1)
		{
			// Wait a bit for the driver to pump gas in
			try
			{
			    Thread.sleep(3000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			
			System.out.println("How many gallons did you fuel? ");
			num = input.nextInt();
			// Increment the number of gallons of gas has fueled
			f.incrementFuel(num);
			
			return 1;
		}
		else
			return 2;
	}
}
