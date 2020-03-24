// Programmer: Jack Adams S0201412
// File: Week3.java
// Date: July 26 2018
// Purpose: COIT11222 assignment one, question three T2-18
// Take in customer information and calculates total rental cost based on number of days enter.


import java.util.Scanner; //Import of scanner

public class Week3
{
	public static void main(String[] args)
	{
		String customerName; //Variable for customer's name
		String licenseNo; //Variable for customer's drivers license number
		int numRentalDays; // Variable for number of days the car was hired for
		double rentalTotal; //Variable for the total rental amount
		final double COST_MAX_3_DAYS = 34.50D; //Set constant for the 1 - 3 days rental amount
		final double COST_MAX_7_DAYS = 30.50D; //Set constant for the 4 - 7 days rental amount
		final double COST_OVER_7_DAYS = 22.50D; //Set constant for more than 7 days rental amount
		final int DAY_LIMIT_1 = 3; //Set constant for day limit up to 3
		final int DAY_LIMIT_2 = 7; //Set constant for day limit up to 7


		Scanner inText = new Scanner(System.in); //Declaring scanner for text input
		Scanner inNumber = new Scanner(System.in); //Declaring scanner for number input

		System.out.print("Enter the customer name: "); //Allowing user to enter name
		customerName = inText.nextLine();

		System.out.print("Enter the license number: "); //Allowing user to enter license number
		licenseNo = inText.nextLine();

		System.out.print("Enter the number of days hired by " + customerName + ": "); //Allowing user to enter number of rental days
		numRentalDays = inNumber.nextInt();


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


		System.out.println("");
		System.out.println("\t\t\t   Summary of Hire");
		System.out.println("\t\t\t---------------------");
		System.out.println("\t\t\tCustomer: " + customerName);
		System.out.println("\t\t\tLicense No.: " + licenseNo);
		System.out.println("\t\t\tNumber of days: " + numRentalDays);
		System.out.print("\t\t\tThe Rental is ");
		System.out.printf("$%.2f", rentalTotal);
		System.out.println("");
		//Program displays summary information of customers rental including customer name and license number
	}
}