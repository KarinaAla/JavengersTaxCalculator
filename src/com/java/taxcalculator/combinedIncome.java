package com.java.taxcalculator;
import java.util.Scanner;

public class combinedIncome {

    //as a user  I want a program that's able to allow me to input
// my salary from my job, and other sources of income, and to
// have a total amount of income

        public static void calculateIncome() {
            double income;
            Scanner input = new Scanner(System.in);
            String secondIncome;
            String taxID;
            double second;
            double newIncome = 0;
            String employer;

            do {
                System.out.println("Please enter your income for the year of 2022");
                income = input.nextDouble();
                System.out.println("Please enter the name of your employer: ");
                employer = input.next();
                System.out.println("Please enter your employer's tax ID number: ");
                taxID = input.next();
                System.out.println("Do you have another job/source of income?");
                secondIncome = input.next();
                newIncome = newIncome + income;
            }
            while (secondIncome.equalsIgnoreCase("yes"));

            System.out.println("Your total income for the year of 2022 is: " + newIncome);

        }
    /*       double newIncome = 0.0;
String secondIncome = "";
String empTaxID = "";
double second = 0.0;
double newIncome = 0.0;
String employer = "";

System.out.println("Please enter your income for the year of 2022");
income = sc.nextDouble();

printLineWithSpace();

System.out.println("Please enter the name of your employer: ");
employer = sc.next();

printLineWithSpace();

System.out.println("Please enter your employer's tax ID number: ");
empTaxID = sc.next();

printLineWithSpace();

System.out.println("Do you have another job/source of income?");
secondIncome = sc.next();
if (secondIncome.equalsIgnoreCase(positive)) {
    printLineWithSpace();
    System.out.println("Enter your additional income for the year of 2022");
    second = sc.nextDouble();
}
newIncome = second + income;
*/
        public static void main(String[] args) {
            calculateIncome ();
        }
    }


