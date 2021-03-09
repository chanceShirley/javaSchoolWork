// @author Chance Shirley
// I pledge my word of honor that I have abided
// by the CSN Academic Integrity Policy while completing
// this assignment.
// @file ChanceShirleycit130_pa7.java
// @version 2021-03-08
// @brief This program asks the user for the number of dealers
// they wish to enter and then gathers dealer names and sales
// from the user before calculating commission percentages,
// total sales, and average sales and displaying them. 
// @note Time taken to develop, write, test and debug
// solution - 3 hours

import java.util.Formatter;
import java.util.Scanner;

public class ChanceShirleycit130_pa7 {
    
    // Main program
    public static void main(String[] args) {
        
        // For formatting output
        Formatter f = new Formatter();

        // Call getDealers method
        int numberOfDealers = getNumDealers();

        // Create object to hold both arrays created in getDealerInfo
        Object[] dealerData = getDealerInfo(numberOfDealers);

        // Separating out the arrays from the dealerData object
        String[] dealerNames = (String[])dealerData[0];
        Double[] dealerSales = (Double[])dealerData[1];

        // Creating the Comissions array
        Double[] dealerComms = calculateCommission(dealerSales);

        // Calculating the Total sales
        Double finalTotal = calculateSales(dealerSales);

        // Creating space for output
        System.out.println();

        // Outputting Data in Tabular format
        f.format("%-15s %-15s %-15s\n", "Dealers", "Sales", "Commission");
        f.format("------------------------------------------\n");
        for (int i = 0; i < numberOfDealers; i++) {
            f.format("%-15s $%-15.2f $%-15.2f\n", dealerNames[i], dealerSales[i], dealerComms[i]);
        }
        System.out.println(f);

        // Creating some extra space
        System.out.println();

        // Total, Average, and Commissions output
        System.out.printf("Total Sales: $%.2f\n", finalTotal);
        System.out.printf("Average Total of Sales: $%.2f\n", (calculateAvg(dealerSales, finalTotal)));
        System.out.printf("Total in Commissions: $%.2f", calculateComms(dealerComms));

    }


    //getNumDealers
	//return: The number of dealers
	//paramters: none
    public static int getNumDealers() {
        
        Scanner input = new Scanner(System.in);

        int numDealers;

        // Get the number of dealers
        System.out.println("How many dealers would you like to enter (1-20)?");
        numDealers = input.nextInt();

        // Prevent the user from entering less than 1 or more than 20
        while (numDealers < 1 || numDealers > 20) {
            System.out.println("Invalid input.");
            System.out.println("How many dealers would you like to enter (1-20)?");
            numDealers = input.nextInt();
        }

        return numDealers;

    }

    //getDealerInfo
	//return: Object with arrays for names and sales
	//paramters: numDealers
    public static Object[] getDealerInfo(int numDealers) {
        
        Scanner input = new Scanner(System.in);

        // Creating an object to hold both arrays
        Object[] arrayObjects = new Object[2];

        // Creating arrays for Dealer names and sales data
        String dealerNames[];
        dealerNames = new String [numDealers];
        Double dealerSales[];
        dealerSales = new Double [numDealers];

        // Assigning the Names and Sales arrays to the object
        arrayObjects [0] = dealerNames;
        arrayObjects [1] = dealerSales;

        // Get Name and sales data for each dealer
        for (int i = 0; i < numDealers; i++) {
            System.out.println("Please enter name of dealer " + (i+1) + ":");
            dealerNames[i] = input.nextLine();
            System.out.println("Please enter sales of dealer " + (i+1) + ":");
            dealerSales[i] = input.nextDouble();
            input.nextLine();
        }

        return arrayObjects;

    }

    //calculateCommission
	//return: Array filled with dealer commissions
	//paramters: Array of dealer sales
    public static Double[] calculateCommission(Double dealerSales[]) {

        int numDealers = dealerSales.length;
        Double dealerCommissions[];
        dealerCommissions = new Double [numDealers];

        // For each item in Dealer Sales array calculate the commission percentage
        for (int i = 0; i < numDealers; i++) {

            if (dealerSales[i] > 0 && dealerSales[i] < 5000) {
                dealerCommissions[i] = (dealerSales[i] * .10);
            } else if (dealerSales[i] > 5000 && dealerSales[i] < 15000) {
                dealerCommissions[i] = (dealerSales[i] * .15);
            } else if (dealerSales[i] > 15000) {
                dealerCommissions[i] = (dealerSales[i] * .20);
            }

        }

        return dealerCommissions;

    }

    //calculateSales
	//return: Total sales from all dealers
	//paramters: Array of dealer sales
    public static Double calculateSales(Double dealerSales[]) {

        Double totalSales = 0.0;

        // Loop to increment the total sales amount
        for (int i = 0; i < dealerSales.length; i++) {
            totalSales += dealerSales[i];
        };
        
        return totalSales;

    }

    //AverageSales
	//return: Total average of sales from all dealers
	//paramters: Array of dealer sales, total
    public static Double calculateAvg(Double dealerSales[], Double finalSales) {

        Double avgSales = 0.0;

        // Calculating average sales
        avgSales = (finalSales / dealerSales.length);
        
        return avgSales;

    }

    //calculateComms
	//return: Total commissions from all dealers
	//paramters: Array of dealer commissions
    public static Double calculateComms(Double dealerComms[]) {

        Double totalComms = 0.0;

        // Loop to increment the total commisions amount
        for (int i = 0; i < dealerComms.length; i++) {
            totalComms += dealerComms[i];
        };
        
        return totalComms;

    }

    

}
