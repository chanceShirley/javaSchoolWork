// @author Chance Shirley
// I pledge my word of honor that I have abided
// by the CSN Academic Integrity Policy while completing
// this assignment.
// @file ChanceShirleycit130_pa6.java
// @version 2021-02-22
// @brief This program presents the user with a menu and 3 choices.
// The first choice is a body fat calculator that askes for the user's
// gender before asking gender specific questions and calculating gender
// specific body fat percentage. The second menu option calculates future
// investment value based on initial investment, rate and time. The third
// menu option exits the program.
// @note Time taken to develop, write, test and debug
// solution - 3 hours

import java.util.Scanner;

public class ChanceShirleycit130_pa6 {

    public static void main(String[] args) {
        // Call the main menu
        menu();
    }

    //menu
	//return: n/a
	//paramters: n/a
    public static void menu() {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("1. Calculate Body fat percentage");
        System.out.println("2. Calculate future value of investment");
        System.out.println("3. Exit program");

        choice = input.nextInt();
        while (choice != 3) {
            if (choice == 1) { // Body fat calculator

                // Get gender for BF calculator
                input.nextLine();
                System.out.println("Please enter the gender (male or female):");
                String gender = input.nextLine();

                // Display body fat calculation
                System.out.printf("Body Fat percentage = %.2f", getBFT(gender));
                System.out.println();

            }
            else if (choice == 2) { // Investment Calculator

                // User inputs for investment calculator
                System.out.println("Enter the investment amount:");
                double investedAmount = input.nextDouble();

                System.out.println("Enter the yearly rate:");
                double yearlyInterestRate = input.nextDouble();

                System.out.println("Enter number of years to calculate the future value:");
                int numberOfYears = input.nextInt();

                // Display future value
                System.out.printf("Future Value = $%.2f", getFV(investedAmount, yearlyInterestRate, numberOfYears));
                System.out.println();

            } else {

               System.out.println("Invalid selection - try again!");

            }

            //present the menu again to the user
            System.out.println("1. Calculate Body fat percentage");
            System.out.println("2. Calculate future value of investment");
            System.out.println("3. Exit program");
            choice = input.nextInt();  //read the choice for the next menu item

        }

    }

    //getBFT
	//return: Body fat percentage
	//paramters: 
        // gender: user entered male or female
    public static double getBFT(String gender) {

        Scanner input = new Scanner(System.in);

        double userweight; // user's weight
        double wristMeasurement; // wrist measurement for females
        double waistMeasurement; // waist measurement for both genders
        double hipMeasurement; // hip measurement for females
        double forearmMeasurement; // forearm measurement for females
        double A1; // used in both gender calulations
        double A2; // used in both gender calulations
        double A3; // used in female calculations only
        double A4; // used in female calculations only
        double A5; // used in female calculations only
        double B; // used in both gender calulations
        double bodyFat; // used in both gender calulations
        double calculatedBMI = 0; // used in both gender calulations

        // Check for valid input
        if (gender.equals("female") || gender.equals("male")) {
            System.out.println("Enter Weight:");
            userweight = input.nextDouble();
        
            System.out.println("Enter your waist measurement:");
            waistMeasurement = input.nextDouble();

            // If gender entered was male
            if (gender.equals("male")) {

                // Male specific calculations
                A1 = (userweight * 1.082) + 94.42;
                A2 = waistMeasurement * 4.15;
                B = A1 - A2;
                bodyFat = userweight - B;
                calculatedBMI = bodyFat * 100 / userweight;
            
            // If gender entered was female
            } else if (gender.equals("female")) {

                // Female specific questions for calculations
                System.out.println("Enter your wrist measurement:");
                wristMeasurement = input.nextDouble();
    
                System.out.println("Enter your hip measurement:");
                hipMeasurement = input.nextDouble();
    
                System.out.println("Enter your forearm measurement:");
                forearmMeasurement = input.nextDouble();
                
                // Female specific calculations
                A1 = (userweight * .732) + 8.987;
                A2 = wristMeasurement / 3.14;
                A3 = waistMeasurement * .157;
                A4 = hipMeasurement * .249;
                A5 = forearmMeasurement * .434;
                B = A1 + A2 - A3 - A4 + A5;
                bodyFat = userweight - B;
                calculatedBMI = bodyFat * 100 / userweight;
            }

        } else { 

            // Default value if invalid input
            calculatedBMI = -111;

        }

        return calculatedBMI;
        
    }

    //getFV
	//return: Future value of investment
	//paramters: 
        // investedAmount: user entered investment amount
        // yearlyInterestRate: user entered interest rate
        // numberOfYears: user entered number of years
    public static double getFV(
        double investedAmount, 
        double yearlyInterestRate, 
        int numberOfYears) {

            double convertedInterest; // holds converted decimal rate
            double monthlyInterestRate; // holds monthly interest rate
            double futureValue; // final value of of investment

            // convert interest rate to decimal
            convertedInterest = yearlyInterestRate / 100;

            // convert decimal rate to monthly rate
            monthlyInterestRate = convertedInterest / 12;

            // future value calculation
            futureValue = investedAmount * Math.pow(((1 + monthlyInterestRate)), ((numberOfYears * 12)));

            return futureValue;

    }
        
}
    