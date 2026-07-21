package data.model.service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportService {

    public void exportReport() {

        StudyService studyService = new StudyService();
        studyService.loadRecords();

        CodingService codingService = new CodingService();
        codingService.loadCodingRecords();

        CompanyService companyService = new CompanyService();
        companyService.loadCompanies();

        DailyPlannerService plannerService = new DailyPlannerService();
        plannerService.loadPlans();

        InterviewNoteService noteService = new InterviewNoteService();
        noteService.loadNotes();

        try {

            String path = System.getProperty("user.home") + "\\Desktop\\Placement_Report.txt";
FileWriter writer = new FileWriter(path);

System.out.println("Saved at: " + path);

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");

            writer.write("=============================================\n");
            writer.write("   PLACEMENT PREPARATION TRACKER REPORT\n");
            writer.write("=============================================\n\n");

            writer.write("Generated On : "
                    + LocalDateTime.now().format(formatter) + "\n\n");

            writer.write("--------------- STUDY ----------------\n");
            writer.write("Total Study Records : "
                    + studyService.getTotalRecords() + "\n");
            writer.write("Total Study Hours : "
                    + studyService.getTotalStudyHours() + "\n");
            writer.write("Study Days : "
                    + studyService.getTotalStudyDays() + "\n");
            writer.write("Most Studied Subject : "
                    + studyService.getMostStudiedSubject() + "\n");
            writer.write("Best Study Day : "
                    + studyService.getBestStudyDay() + "\n");
            writer.write("Study Streak : "
                    + studyService.getStudyStreak() + " Days\n\n");

            writer.write("--------------- CODING ----------------\n");
            writer.write("Coding Sessions : "
                    + codingService.getTotalCodingRecords() + "\n");
            writer.write("Questions Solved : "
                    + codingService.getTotalQuestionsSolved() + "\n\n");

            writer.write("--------------- COMPANIES ----------------\n");
            writer.write("Applied : "
                    + companyService.getTotalCompanies() + "\n");
            writer.write("Selected : "
                    + companyService.getSelectedCompanies() + "\n");
            writer.write("Rejected : "
                    + companyService.getRejectedCompanies() + "\n");
            writer.write("Pending : "
                    + companyService.getPendingCompanies() + "\n");
            writer.write("Success Rate : "
                    + companyService.getSuccessRate() + "%\n\n");

            writer.write("--------------- DAILY PLANNER ----------------\n");
            writer.write("Total Plans : "
                    + plannerService.getTotalPlans() + "\n\n");

            writer.write("--------------- INTERVIEW NOTES ----------------\n");
            writer.write("Total Notes : "
                    + noteService.getTotalNotes() + "\n");
            writer.write("Technical Rounds : "
                    + noteService.getTechnicalRounds() + "\n");
            writer.write("HR Rounds : "
                    + noteService.getHRRounds() + "\n\n");

            writer.write("=============================================\n");
            writer.write("End Of Report\n");
            writer.write("=============================================\n");

            writer.close();
            writer.close();

System.out.println("Saved at: " + path);
System.out.println("Report saved successfully.");
            System.out.println("Report saved successfully.");

            System.out.println("Report Generated Successfully.");

        } catch (IOException e) {

            System.out.println("Error Generating Report!");
        }
    }
}