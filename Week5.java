// Programmer: Jack Adams S0201412
// File: Week5.java
// Date: August 14 2018
// Purpose: COIT11222 assignment one, question five T2-18
// Take in customer information and calculates total rental cost based on number of days enter.
// GUI I/O used for program, includes a welcome message and a dialog box for the maximum and minimum hire information

import javax.swing.JOptionPane; //import of the GUI

public class Week5
{
	public static void main(String[] args)
	{
		String customerName; //Variable for customer's name
		String licenseNo; //Variable for customer's drivers license number
		int numRentalDays; // Variable for number of days the car was hired for
		double totalRentalReceived = 0; //Variable to hold the total amount of money received for car hires
		int count; //Variable for 'for' loop control variable
		double maxiRentalTotal = 0; //Variable to hold the maximum rental total for the customers
		double minRentalTotal = 1_000_000; //Variable to hold the minimum rental total for the customers
		String maxiRentalTotalCustName = ""; //Variable to hold the customer's name for the maximum rental total
		String minRentalTotalCustName = ""; //Variable to hold the customer's name for the minimum rental total

		final int N = 3; //Set constant for the number times the 'for' loop is to check against


		JOptionPane.showMessageDialog(null, "Welcome to XYZ Car Hire Booking System"); //Welcome message dialog box

		for(count = 0; count < N; ++count) //For loop that runs for the constant N
		{
			customerName = JOptionPane.showInputDialog(null, "Please enter the customer's name"); //Allows user to enter customer name
			licenseNo = JOptionPane.showInputDialog(null, "Please enter the license number"); //Allows user to enter customer license number
			numRentalDays = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter " + customerName + "'s number of days hired")); //Allows user to enter number of rental days, parsed to an int type
			totalRentalReceived = calculateHireRental(numRentalDays);


			JOptionPane.showMessageDialog(null, "-----Summary of Hire-----"
			+ String.format("\nCustomer Name: %s\nLicense Number: %s\nNumber of days: %d\nThe rental is $%.2f", customerName, licenseNo, numRentalDays, totalRentalReceived));
			//Summary of hire dialog box

			if(totalRentalReceived > maxiRentalTotal) //If loop to check and assign the maximum rental total and customer name
			{
				maxiRentalTotal = totalRentalReceived;
				maxiRentalTotalCustName = customerName;
			}

			if(totalRentalReceived <= minRentalTotal) //If loop to check and assign the minimum rental total and customer name
			{
				minRentalTotal = totalRentalReceived;
				minRentalTotalCustName = customerName;
			}
		}

		JOptionPane.showMessageDialog(null, String.format("The maximum rental is $%.2f, booking from the customer %s\n The minimum rental is $%.2f, booking from the customer %s",
		maxiRentalTotal, maxiRentalTotalCustName, minRentalTotal, minRentalTotalCustName));
		//Maximum and minimum rental information dialog box
	}

	private static double calculateHireRental(int numRentalDays) //Method
	{
		double rentalTotal = 0; //Variable for the total rental amount
		int num; //Variable used for loop control variable

		final double COST_MAX_3_DAYS = 34.50D; //Set constant for the 1 - 3 days rental amount
		final double COST_MAX_7_DAYS = 30.50D; //Set constant for the 4 - 7 days rental amount
		final double COST_OVER_7_DAYS = 22.50D; //Set constant for more than 7 days rental amount
		final int DAY_LIMIT_1 = 3; //Set constant for day limit up to 3
		final int DAY_LIMIT_2 = 7; //Set constant for day limit up to 7

		for(num = 0; num < 99; num++) //for loop start
		{
			//Comparing entered number of days to calculate correct rental total
			if(numRentalDays <= DAY_LIMIT_1 && numRentalDays > 0)
			{
				rentalTotal = numRentalDays * COST_MAX_3_DAYS;
				//If number of days entered falls between 1 - 3, COST_MAX_3_DAYS is used to calculate total.
			}
			else
			if(numRentalDays > DAY_LIMIT_1 && numRentalDays <= DAY_LIMIT_2)
			{
				rentalTotal = ((DAY_LIMIT_1 * COST_MAX_3_DAYS) + (numRentalDays - DAY_LIMIT_1) * COST_MAX_7_DAYS);
				//If number of days entered falls between 4 - 7, then the first 3 days is calculated at the COST_MAX_3_DAYS
				//the remaining number of days are calulated at COST_MAX_7_DAYS
			}
			else
			if(numRentalDays > 7)
			{
				rentalTotal = ((DAY_LIMIT_1 * COST_MAX_3_DAYS) + ((DAY_LIMIT_2 - DAY_LIMIT_1) * COST_MAX_7_DAYS)
				+ (numRentalDays - DAY_LIMIT_2) * COST_OVER_7_DAYS);
				//If total number of days entered above 7, then the first 3 days are calculated at COST_MAX_3_DAYS, the next 4 calculated at COST_MAX_7_DAYS
				//the remaining number of days are calulated at COST_OVER_7_DAYS
			}
			else
			{
				rentalTotal = 0;
				//If an invalid number of days is entered, the program returns zero.
			}
		}
		return rentalTotal;
	}
}