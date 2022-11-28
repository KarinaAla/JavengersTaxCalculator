package com.java.taxcalculator;
import java.util.Scanner;
public class TaxCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tax Calculator");
        System.out.println("Please fill the following steps to continue!");
        String positive = "Yes";
        String negative = "No";
        double taxRate = 0.0;

        System.out.println("Enter your full name:");
        String name = sc.nextLine();
        printLineWithSpace();

        System.out.println("Enter your address:");
        String address = sc.nextLine();
        printLineWithSpace();

        System.out.println("Enter your tax ID:");
        String taxID = sc.nextLine();
        printLineWithSpace();

        System.out.println("Are you an active duty military member? (Yes/No)");
        String militaryMember = sc.nextLine();
        if (militaryMember.equalsIgnoreCase(positive)) {
            System.out.println("!! Please include your Military Tax Exemption Certificate. !!");
        }
        printLineWithSpace();

        System.out.println("Are you a full-time student in college/university? (Yes/No)");
        String student = sc.nextLine();
        //if we going to use tuition in future, we should initialize it here, other way we won't be able to access
        double tuition = 0;
        if (student.equalsIgnoreCase(positive)) {
            System.out.println("Enter the annual tuition fee:");
            tuition = sc.nextDouble();
        }

        System.out.println("Are you filing as single? (Yes or No):");
        String status = sc.nextLine();
        System.out.println("Do you have children under 18? (Yes or No):");
        String hasKids = sc.nextLine();
        int kids = 0;
        if (hasKids.equalsIgnoreCase(positive)) {
            System.out.println("Please enter the number of kids:");
            kids = sc.nextInt();
        }
        System.out.println("Do you have any dependents? (Yes or No): ");
        String hasDependents = sc.nextLine();
        int dependents = 0;
        if (hasDependents.equalsIgnoreCase(positive)) {
            System.out.println("Please enter the number of dependents: ");
            dependents = sc.nextInt();
        }
        printLineWithSpace();

        double income = 0.0;
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

        printLineWithSpace();

        taxRate = taxRate(newIncome, status, militaryMember, kids, dependents, positive, negative);

    }

    static double taxRate(double newIncome, String status, String militaryMember, int kids, int dependents, String positive, String negative) {

        double taxCreditSingle0 = 17640;
        double taxCreditSingle1 = 46560;
        double taxCreditSingle2 = 52918;
        double taxCreditSingle3 = 56838;
        double taxCreditMarried0 = 24210;
        double taxCreditMarried1 = 53120;
        double taxCreditMarried2 = 59478;
        double taxCreditMarried3 = 63398;

        if (status.equalsIgnoreCase(positive)) {
            if (kids + dependents == 0) {
                newIncome = newIncome - taxCreditSingle0;
            } else if (kids + dependents == 1) {
                newIncome = newIncome - taxCreditSingle1;
            } else if (kids + dependents == 2) {
                newIncome = newIncome - taxCreditSingle2;
            } else if (kids + dependents == 3) {
                newIncome = newIncome - taxCreditSingle3;
            }
        }
        if (status.equalsIgnoreCase(negative)) {
            if (kids + dependents == 0) {
                newIncome = newIncome - taxCreditMarried0;
            } else if (kids + dependents == 1) {
                newIncome = newIncome - taxCreditMarried1;
            } else if (kids + dependents == 2) {
                newIncome = newIncome - taxCreditMarried2;
            } else if (kids + dependents == 3) {
                newIncome = newIncome - taxCreditMarried3;
            }
        }

        printLineWithSpace();

        System.out.println("Your total income for the year of 2022 is: " + newIncome);

        double taxRate = 0.0;

        if (militaryMember.equalsIgnoreCase(positive)) {
            taxRate = 0.0;
        }
        if (status.equalsIgnoreCase(positive)) {
            if (newIncome <= 10275) {
                taxRate = 0.1;
            } else if (newIncome <= 41775) {
                taxRate = 0.12;
            } else if (newIncome <= 89075) {
                taxRate = 0.22;
            } else if (newIncome <= 170050) {
                taxRate = 0.24;
            } else if (newIncome <= 215950) {
                taxRate = 0.32;
            } else if (newIncome <= 539500) {
                taxRate = 0.35;
            } else {
                taxRate = 0.37;
            }
        }
        if (status.equalsIgnoreCase(negative)) {
            if (newIncome <= 20550) {
                taxRate = 0.1;
            } else if (newIncome <= 83550) {
                taxRate = 0.12;
            } else if (newIncome <= 178150) {
                taxRate = 0.22;
            } else if (newIncome <= 340100) {
                taxRate = 0.24;
            } else if (newIncome <= 431900) {
                taxRate = 0.32;
            } else if (newIncome <= 647850) {
                taxRate = 0.35;
            } else {
                taxRate = 0.37;
            }
        }
        printLineWithSpace();

        System.out.println("Based on your marital status and income, your Tax Rate is: " + taxRate * 100);
        return taxRate;
    }


    static void printLineWithSpace() {
        System.out.println(" ");
    }
}