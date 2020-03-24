// Programmer: Jack Adams S0201412
// File: Week2.java
// Date: July 16 2018
// Purpose: COIT11222 assignment one, question two T2-18
// Take in customer information and calculate rental rate based on number of days


import java.util.Scanner; //Import of scanner

public class Week2
{
	public static void main(String[] args)
	{
		String customerName; //Variable for customer's name
		String licenseNo; //Variable for customer's drivers license number
		int numRentalDays; // Variable for number of days the car was hired for
		double rentalTotal; //Variable for the total rental amount
		final double RENTAL_COST = 34.50D; //Set constant for the daily rental amount


		Scanner inText = new Scanner(System.in); //Declaring scanner for text input
		Scanner inNumber = new Scanner(System.in); //Declaring scanner for number input

		System.out.print("Enter the customer name: "); //Allowing user to enter name
		customerName = inText.nextLine();

		System.out.print("Enter the license number: "); //Allowing user to enter license number
		licenseNo = inText.nextLine();

		System.out.print("Enter the number of days hired by " + customerName + ": "); //Allowing user to enter number of rental days
		numRentalDays = inNumber.nextInt();

		rentalTotal = numRentalDays * RENTAL_COST;
		//Assigning the total of the number of rental days entered by the user multiplied by the set rental rate to the rentalTotal variable

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