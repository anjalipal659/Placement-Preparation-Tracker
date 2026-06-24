import java.util.Scanner;

import data.model.CodingRecord;
import data.model.StudyRecord;
import data.model.service.StudyService;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudyService service = new StudyService();
        boolean running = true;
        while (running){
        

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

    System.out.print("Enter Subject Name: ");
    String subject = sc.nextLine();

    System.out.print("Enter Hours Studied: ");
    int hours = sc.nextInt();

    System.out.print("Enter Today's Goal:");
    sc.nextLine();
    String goal = sc.nextLine();

StudyRecord record = new StudyRecord();

    record.subjectName = subject;
    record.hoursStudied = hours;
    record.todayGoal = goal;

    service.addRecord(record);
    System.out.println("\nStudy Record Saved Successfully!");
    service.showRecords();
    break;
    case 2:
        System.out.print("Enter Platform: ");
sc.nextLine();
String platform = sc.nextLine();

System.out.print("Questions Solved Today: ");
int questionsSolved = sc.nextInt();

sc.nextLine();

System.out.print("Enter Difficulty: ");
String difficulty = sc.nextLine();

System.out.print("Enter Current Streak: ");
int currentStreak = sc.nextInt();

CodingRecord codingRecord = new CodingRecord();

codingRecord.platform = platform;
codingRecord.questionsSolved = questionsSolved;
codingRecord.difficulty = difficulty;
codingRecord.currentStreak = currentStreak;

System.out.println("\nCoding Record Saved Successfully!");

System.out.println("Platform : " + codingRecord.platform);
System.out.println("Questions: " + codingRecord.questionsSolved);
System.out.println("Difficulty: " + codingRecord.difficulty);
System.out.println("Streak : " + codingRecord.currentStreak);

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
        System.out.println("\nThank you! for using Placement Preparati Tracker!");
        System.out.println("Keep Learning, Keep Coding!");
        running = false;
        break;
        

    default:
        System.out.println("Invalid Choice");
}

       // sc.close();
}
}}
