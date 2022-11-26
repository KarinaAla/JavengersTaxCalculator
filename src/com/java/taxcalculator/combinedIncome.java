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
        public static void main(String[] args) {
            calculateIncome ();
        }
    }


