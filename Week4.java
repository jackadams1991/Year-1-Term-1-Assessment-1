// Programmer: Jack Adams S0201412
// File: Week4.java
// Date: August 7 2018
// Purpose: COIT11222 assignment one, question four T2-18
// Take in customer information and calculates total rental cost based on number of days enter.
// Also includes calculation of hire car statistics


import java.util.Scanner; //Import of scanner

public class Week4
{
	public static void main(String[] args)
	{
		String customerName; //Variable for customer's name
		String licenseNo; //Variable for customer's drivers license number
		int numRentalDays; // Variable for number of days the car was hired for
		double rentalTotal; //Variable for the total rental amount
		int count; //Variable for 'for' loop control variable
		int daysUnderFour = 0; //Variable for statistics section to display number of days hired under 4 days
		int daysBetweenFourAndSeven = 0; //Variable for statistics section to display number of days hired between 4 & 7 days
		int daysOverSeven = 0; //Variable for statistics section to display number of days hired over 7 days
		double avgRentalDays = 0; //Variable to hold the average amount of days a car is hired for
		double totalRentalReceived = 0; //Variable to hold the total amount of money received for car hires

		final int N = 3; //Set constant for the number times the 'for' loop is to check against
		final double COST_MAX_3_DAYS = 34.50D; //Set constant for the 1 - 3 days rental amount
		final double COST_MAX_7_DAYS = 30.50D; //Set constant for the 4 - 7 days rental amount
		final double COST_OVER_7_DAYS = 22.50D; //Set constant for more than 7 days rental amount
		final int DAY_LIMIT_1 = 3; //Set constant for day limit up to 3
		final int DAY_LIMIT_2 = 7; //Set constant for day limit up to 7


		Scanner inText = new Scanner(System.in); //Declaring scanner for text input
		Scanner inNumber = new Scanner(System.in); //Declaring scanner for number input

		System.out.println("\t\t\tWelcome to XYZ Car Hire Booking System"); //Printing of company name

		for(count = 0; count < N; ++count) //for loop start
		{
			System.out.print("\nEnter the customer name: "); //Allowing user to enter name
			customerName = inText.nextLine();

			System.out.print("Enter the license number: "); //Allowing user to enter license number
			licenseNo = inText.nextLine();

			System.out.print("Enter the number of days hired by " + customerName + ": "); //Allowing user to enter number of rental days
			numRentalDays = inNumber.nextInt();


			//Comparing entered number of days to calculate correct rental total
			if(numRentalDays <= DAY_LIMIT_1 && numRentalDays > 0)
			{
				rentalTotal = numRentalDays * COST_MAX_3_DAYS;
				daysUnderFour = ++daysUnderFour;
				//If number of days entered falls between 1 - 3, COST_MAX_3_DAYS is used to calculate total.
			}
			else
			if(numRentalDays > DAY_LIMIT_1 && numRentalDays <= DAY_LIMIT_2)
			{
				rentalTotal = ((DAY_LIMIT_1 * COST_MAX_3_DAYS) + (numRentalDays - DAY_LIMIT_1) * COST_MAX_7_DAYS);
				daysBetweenFourAndSeven = ++daysBetweenFourAndSeven;
				//If number of days entered falls between 4 - 7, then the first 3 days is calculated at the COST_MAX_3_DAYS
				//the remaining number of days are calulated at COST_MAX_7_DAYS
			}
			else
			if(numRentalDays > 7)
			{
				rentalTotal = ((DAY_LIMIT_1 * COST_MAX_3_DAYS) + ((DAY_LIMIT_2 - DAY_LIMIT_1) * COST_MAX_7_DAYS)
				+ (numRentalDays - DAY_LIMIT_2) * COST_OVER_7_DAYS);
				daysOverSeven = ++daysOverSeven;
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

			totalRentalReceived = totalRentalReceived + rentalTotal;
			//Calculating the total amount of hire money received then assigning value to 'totalRentalReceived' variable
			avgRentalDays = avgRentalDays + numRentalDays;
			//Calculating the average amount of hire days and assigning to 'avgRentalDays' variable

		} //End of 'for' loop

		//Printing of statistical information of car hire
		System.out.println("\n\t\t\t      Statisics of Hire Activities");
		System.out.println("\t\t\t-----------------------------------------");
		System.out.println("\t\t\tNumber of days hired less than 4 days: " + daysUnderFour);
		System.out.println("\t\t\tNumber of days hired between 4 & 7 days: " + daysBetweenFourAndSeven);
		System.out.println("\t\t\tNumber of days hired greater than 7 days: " + daysOverSeven);
		System.out.print("\n\t\t\tThe average days hired is ");
		System.out.printf("%.2f", (avgRentalDays / N));
		System.out.print(" days");
		System.out.print("\n\t\t\tThe total rental received is ");
		System.out.printf("$%.2f", totalRentalReceived);
		System.out.println("");
	}
}