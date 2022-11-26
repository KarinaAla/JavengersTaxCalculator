package com.java.taxcalculator;
import java.util.Scanner;
public class TaxCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Tax Calculator");
        System.out.println("Please fill the following steps to continue!");
        String positive="Yes";

        System.out.println("Enter your full name:");
        String name=sc.nextLine();
        printLineWithSpace();

        System.out.println("Enter your address:");
        String address=sc.nextLine();
        printLineWithSpace();

        System.out.println("Enter your tax ID:");
        String taxID=sc.nextLine();
        printLineWithSpace();

        System.out.println("Are you an active duty military member? (Yes/No)");
        String militaryMember = sc.nextLine();
        if(militaryMember.equalsIgnoreCase(positive)){
            System.out.println("!! Please include your Military Tax Exemption Certificate. !!");
        }
        printLineWithSpace();

        System.out.println("Are you a full-time student in college/university? (Yes/No)");
        String student=sc.nextLine();
        if(student.equalsIgnoreCase(positive)) {
            System.out.println("Enter the annual tuition fee:");
            double tuition=sc.nextDouble();
        }

        System.out.println("Please write your status:");
        String status = sc.next();
        System.out.println("Do you have children? (Yes or No):");
        int kids = sc.nextInt();
        System.out.println("How old your kids are: ");
        int dependents = sc.nextInt();
        System.out.println("Please enter the number of dependents: ");
        printLineWithSpace();
    }

    static void printLineWithSpace(){
        System.out.println(" ");
    }
}