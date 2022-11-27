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
        //if we going to use tuition in future, we should initialize it here, other way we won't be able to access
        double tuition =0;
        if(student.equalsIgnoreCase(positive)) {
            System.out.println("Enter the annual tuition fee:");
            tuition=sc.nextDouble();
        }

        System.out.println("Please write your marital status:"); 
        String status = sc.nextLine(); 
        System.out.println("Do you have children under 18? (Yes or No):"); 
        String hasKids = sc.nextLine();
        int kids =0;
        if(hasKids.equalsIgnoreCase(positive)){
              System.out.println("Please enter the number of kids:");
              kids = sc.nextInt(); 
        }    
        System.out.println("Do you have any dependents? (Yes or No): ");
        String hasDependents = sc.nextLine();
        int dependents = 0;
        if(hasDependents.equalsIgnoreCase(positive)){
            System.out.println("Please enter the number of dependents: ");
            dependents = sc.nextInt();
        }
        printLineWithSpace();
    }

    static void printLineWithSpace(){
        System.out.println(" ");
    }
}
