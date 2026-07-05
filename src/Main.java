import java.util.Scanner;
import data.model.CodingRecord;
import data.model.StudyRecord;
import data.model.CompanyRecord;
import data.model.service.StudyService;
import data.model.service.CompanyService;
import data.model.DailyPlannerRecord;
import data.model.service.DailyPlannerService;
import data.model.InterviewNote;
import data.model.service.InterviewNoteService;
import data.model.service.CodingService;



import data.model.CodingRecord;
import data.model.StudyRecord;
import data.model.service.StudyService;
public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        StudyService service = new StudyService();
        service.loadRecords();

        CodingService codingService = new CodingService();
        codingService.loadCodingRecords();

        CompanyService companyService = new CompanyService();
        companyService.loadCompanies();

        DailyPlannerService dailyPlannerService = new DailyPlannerService();
        dailyPlannerService.loadPlans();

        InterviewNoteService interviewNoteService = new InterviewNoteService();
        interviewNoteService.loadNotes();
        
        boolean running = true;
        while (running) {
            System.out.println();
            
        

        System.out.println("====================================");
        System.out.println("   Placement Preparation Tracker");
        System.out.println("====================================");
        System.out.println("1. Study Tracker");
        System.out.println("2. Coding Tracker");
        System.out.println("3. Company Tracker");
        System.out.println("4. Daily Planner");
        System.out.println("5. Interview Notes");
        System.out.println("6. Dashboard");
        System.out.println("7. Search Company");
        System.out.println("8. Update Company Status");
        System.out.println("9. Delete Company");
        System.out.println("10. Exit");
        
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {

    case 1:

    sc.nextLine();   

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
System.out.println("DEBUG 1");
System.out.println("Subject : " + record.subjectName);
System.out.println("Hours   : " + record.hoursStudied);
System.out.println("Goal    : " + record.todayGoal);
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
codingService.addCodingRecord(codingRecord);

System.out.println("\nCoding Record Saved Successfully!\n");

codingService.showCodingRecords();


break;
    case 3:

    sc.nextLine();

    System.out.print("Enter Company Name: ");
    String companyName = sc.nextLine();

    System.out.print("Enter Role: ");
    String role = sc.nextLine();

    System.out.print("Enter Status: ");
    String status = sc.nextLine();

    CompanyRecord company = new CompanyRecord();

    company.companyName = companyName;
    company.role = role;
    company.status = status;

    companyService.addCompany(company);

    System.out.println("\nCompany Record Saved Successfully!\n");

    companyService.showCompanies();

    break;

   case 4:

    sc.nextLine();

    System.out.print("Enter Task: ");
    String task = sc.nextLine();

    System.out.print("Enter Time: ");
    String time = sc.nextLine();

    System.out.print("Enter Priority (High/Medium/Low): ");
    String priority = sc.nextLine();

    DailyPlannerRecord plan = new DailyPlannerRecord();

    plan.task = task;
    plan.time = time;
    plan.priority = priority;

    dailyPlannerService.addPlan(plan);

    System.out.println("\nDaily Plan Saved Successfully!\n");

    dailyPlannerService.showPlans();

    break;

    case 5:

    sc.nextLine();

    System.out.print("Enter Company Name: ");
    String companyNameString = sc.nextLine();

    System.out.print("Enter Interview Round: ");
    String interviewRound = sc.nextLine();

    System.out.print("Enter Notes: ");
    String notes = sc.nextLine();

    InterviewNote note = new InterviewNote();

    note.companyName = companyNameString;
    note.interviewRound = interviewRound;
    note.notes = notes;

    interviewNoteService.addNote(note);

    System.out.println("\nInterview Note Saved Successfully!\n");

    interviewNoteService.showNotes();

    break;

    case 6:
        System.out.println("\n========== DASHBOARD ==========");

System.out.println("Study Records       : " + service.getTotalRecords());
System.out.println("Total Study Hours   : " + service.getTotalStudyHours());

System.out.println();

System.out.println("Coding Records      : " + codingService.getTotalCodingRecords());
System.out.println("Questions Solved    : " + codingService.getTotalQuestionsSolved());

System.out.println();

System.out.println("Companies Applied   : " + companyService.getTotalCompanies());
System.out.println("Selected Companies  : " + companyService.getSelectedCompanies());
System.out.println("Rejected Companies  : " + companyService.getRejectedCompanies());
System.out.println("Pending Companies   : " + companyService.getPendingCompanies());

System.out.println();

System.out.println("Daily Plans         : " + dailyPlannerService.getTotalPlans());
System.out.println("Interview Notes     : " + interviewNoteService.getTotalNotes());

System.out.println("===============================\n");

    

    case 7:

    sc.nextLine();

    System.out.print("Enter Company Name to Search: ");
    String searchCompany = sc.nextLine();

    companyService.searchCompany(searchCompany);

    break;

    case 8:

    sc.nextLine();

    System.out.print("Enter Company Name: ");
    String updateCompany = sc.nextLine();

    System.out.print("Enter New Status: ");
    String newStatus = sc.nextLine();

    companyService.updateCompanyStatus(updateCompany, newStatus);

    break;

    case 9:

    sc.nextLine();

    System.out.print("Enter Company Name to Delete: ");
    String deleteCompany = sc.nextLine();

    companyService.deleteCompany(deleteCompany);

    break;

    case 10:
        System.out.println("\nThank you for using Placement Preparation Tracker!");
        System.out.println("Keep Learning, Keep Coding!");
        running = false;
        break;
        

    default:
        System.out.println("Invalid Choice");
}

       // sc.close();
}
}}
