package com.java.taxcalculator;
import java.util.Scanner;
public class TaxCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\tWelcome to Tax Calculator");
        System.out.println("\tPlease fill the following steps to continue!");
        System.out.println("\t--------------------------------------------");
        String positive = "yes";
        String negative = "no";

        System.out.println("Enter your full name:");
        String name=checkName(sc);

        printLineWithSpace();

        System.out.println("Enter your address:");
        String address = sc.nextLine();
        printLineWithSpace();

        System.out.println("Enter your tax ID:");
        int taxID = checkInt(sc);
        printLineWithSpace();

        System.out.println("Are you an active duty military member? (Yes/No)");

        String militaryMember = CheckingAnswer(sc);
        if (militaryMember.equalsIgnoreCase(positive)) {
            System.out.println("!! Please include your Military Tax Exemption Certificate. !!");
        }
        printLineWithSpace();

        System.out.println("Are you a full-time student in college/university? (Yes/No)");
        String student = CheckingAnswer(sc);
        double tuition = 0.0;
        if (student.equalsIgnoreCase(positive)) {
            System.out.println("Enter the annual tuition fee:");
            tuition = checkDouble(sc);
        }

        printLineWithSpace();
        System.out.println("Are you filing as single? (Yes/No):");
        String status = CheckingAnswer(sc);
        printLineWithSpace();
        System.out.println("Do you have children under 18? (Yes/No):");
        String hasKids = CheckingAnswer (sc);
        int kids = 0;
        if (hasKids.equalsIgnoreCase(positive)) {
            System.out.println("Please enter the number of kids:");
            kids = checkInt(sc);
        }

        printLineWithSpace();
        System.out.println("Do you have any dependents? (Yes/No): ");
        String hasDependents = CheckingAnswer(sc);
        int dependents = 0;
        if (hasDependents.equalsIgnoreCase(positive)) {
            System.out.println("Please enter the number of dependents: ");
            dependents = checkInt(sc);
        }

        printLineWithSpace();
        double newIncome = calculateIncome(sc);

        printLineWithSpace();

        double taxRate = taxRate(newIncome, status, militaryMember, kids, dependents, positive, negative);
        paidTaxes(newIncome, taxRate, student, tuition);

    }
    public static double calculateIncome(Scanner sc) {
        double income;
        String secondIncome;
        int emptaxID;
        double newIncome = 0.0;
        String employer = "";

        do {
            System.out.println("Please enter your income for the year of 2022:");
            income = checkDouble(sc);
            System.out.println("Please enter the name of your employer: ");
            employer = checkName(sc);
            System.out.println("Please enter your employer's tax ID number: ");
            emptaxID = checkInt(sc);
            System.out.println("Do you have another job/source of income?(Yes/No)");
            secondIncome = CheckingAnswer(sc);
            newIncome = newIncome + income;
        }
        while (secondIncome.equalsIgnoreCase("yes"));

        System.out.println("Your total income for the year of 2022 is $" + newIncome);
        return newIncome;
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

        //System.out.println("Your total income for the year of 2022 is: $" + newIncome);

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
        taxRate-=Persentage(kids);
        System.out.println("Based on your marital status and income, your Tax Rate is " + (int) (taxRate * 100) + "%");
        return taxRate;
    }
    static void paidTaxes(double income, double taxRate, String isStudent, double tuition) {
        double beforePayingTaxes = income;
        double taxesPaid = income * taxRate;
        double afterPayingTaxes = beforePayingTaxes - taxesPaid;
        double reimbursement = 0.0;
        if (isStudent.equals("yes")) {
            reimbursement = tuition*0.1;
            afterPayingTaxes += reimbursement;
        }
        System.out.println("\nTaxes paid = $" + taxesPaid);
        System.out.println("Your reimbursement = $" + reimbursement);
        System.out.println("Total kept income = $" + afterPayingTaxes);
    }

    static void printLineWithSpace() {
        System.out.println(" ");
    }

    static double Persentage(int kids) {
        double persentage = kids*0.005;
        System.out.println("Based on the number of kids you have, your tax \"discount\" is "+ (int)(persentage*100)+ "%");
        return persentage;
    }
    public static String CheckingAnswer (Scanner sc){
        String answer = sc.nextLine();
        while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))){
            System.out.println("Your input is incorrect! Please enter YES or NO:");
            answer = sc.nextLine();
        }
        return answer;
    }
    public static int checkInt(Scanner sc){
        String intStr = sc.nextLine();
        while(!isInteger(intStr)){
            intStr = sc.nextLine();
        }
        return Integer.parseInt(intStr);
    }
    public static double checkDouble(Scanner sc){
        String intStr = sc.nextLine();
        while(!isDouble(intStr)){
            intStr = sc.nextLine();
        }
        return Double.parseDouble(intStr);
    }
    public static boolean isDouble( String str ) {
        try {
            Double.parseDouble(str);
            return true;
        }
        catch( Exception e ) {
            System.out.println("Incorrect input! Please input only numbers:");
            return false;
        }
    }
    public static boolean isInteger( String str ) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch( Exception e ) {
            System.out.println("Incorrect input! Please input only numbers:");
            return false;
        }
    }
    static boolean isAlphabetical(String name){
        int count=0;
        char[] ch = name.toCharArray();
        for (char c : ch) {
            if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
                count++;
            }
        }
        if(name.length()==count){
            return true;
        }else{
            System.out.println("You have entered unsupported characters or digits. Please try again.");
            return false;
        }
    }
    static String checkName(Scanner sc){
        String name = sc.nextLine();
        while(!isAlphabetical(name)) {
            name=sc.nextLine();
        }
        return name;
    }
}
