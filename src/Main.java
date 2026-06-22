import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("   Placement Preparation Tracker");
        System.out.println("====================================");
        System.out.println("1. Study Tracker");
        System.out.println("2. Coding Tracker");
        System.out.println("3. Company Tracker");
        System.out.println("4. Daily Planner");
        System.out.println("5. Interview Notes");
        System.out.println("6. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {

    case 1:
        System.out.println("Study Tracker selected");
        break;

    case 2:
        System.out.println("Coding Tracker selected");
        break;

    case 3:
        System.out.println("Company Tracker selected");
        break;

    case 4:
        System.out.println("Daily Planner selected");
        break;

    case 5:
        System.out.println("Interview Notes selected");
        break;

    case 6:
        System.out.println("Thank you! Exiting...");
        break;

    default:
        System.out.println("Invalid Choice");
}

        sc.close();
    }
}