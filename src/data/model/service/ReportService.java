package data.model.service;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openpdf.text.Document;
import org.openpdf.text.Font;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfWriter;
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

            String path =
                    System.getProperty("user.home")
                    + "\\Desktop\\Placement_Report.pdf";

            Document document = new Document();

            PdfWriter.getInstance(
                    document,
                    new FileOutputStream(path));

            document.open();

            Font titleFont =
                    new Font(Font.HELVETICA, 18, Font.BOLD);

            Font headingFont =
                    new Font(Font.HELVETICA, 14, Font.BOLD);

            Font normalFont =
                    new Font(Font.HELVETICA, 12);

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy hh:mm a");

            document.add(new Paragraph(
                    "PLACEMENT PREPARATION TRACKER REPORT",
                    titleFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "Generated On : "
                            + LocalDateTime.now()
                            .format(formatter),
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "STUDY ANALYTICS",
                    headingFont));

            document.add(new Paragraph(
                    "Total Study Records : "
                            + studyService.getTotalRecords(),
                    normalFont));

            document.add(new Paragraph(
                    "Total Study Hours : "
                            + studyService.getTotalStudyHours(),
                    normalFont));

            document.add(new Paragraph(
                    "Study Days : "
                            + studyService.getTotalStudyDays(),
                    normalFont));

            document.add(new Paragraph(
                    "Most Studied Subject : "
                            + studyService.getMostStudiedSubject(),
                    normalFont));

            document.add(new Paragraph(
                    "Best Study Day : "
                            + studyService.getBestStudyDay(),
                    normalFont));

            document.add(new Paragraph(
                    "Study Streak : "
                            + studyService.getStudyStreak()
                            + " Days",
                    normalFont));

            document.add(new Paragraph(" "));

                        document.add(new Paragraph(
                    "CODING ANALYTICS",
                    headingFont));

            document.add(new Paragraph(
                    "Coding Sessions : "
                            + codingService.getTotalCodingRecords(),
                    normalFont));

            document.add(new Paragraph(
                    "Questions Solved : "
                            + codingService.getTotalQuestionsSolved(),
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "COMPANY ANALYTICS",
                    headingFont));

            document.add(new Paragraph(
                    "Companies Applied : "
                            + companyService.getTotalCompanies(),
                    normalFont));

            document.add(new Paragraph(
                    "Selected : "
                            + companyService.getSelectedCompanies(),
                    normalFont));

            document.add(new Paragraph(
                    "Rejected : "
                            + companyService.getRejectedCompanies(),
                    normalFont));

            document.add(new Paragraph(
                    "Pending : "
                            + companyService.getPendingCompanies(),
                    normalFont));

            document.add(new Paragraph(
                    "Success Rate : "
                            + companyService.getSuccessRate() + "%",
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "DAILY PLANNER",
                    headingFont));

            document.add(new Paragraph(
                    "Total Plans : "
                            + plannerService.getTotalPlans(),
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "INTERVIEW NOTES",
                    headingFont));

            document.add(new Paragraph(
                    "Total Notes : "
                            + noteService.getTotalNotes(),
                    normalFont));

            document.add(new Paragraph(
                    "Technical Rounds : "
                            + noteService.getTechnicalRounds(),
                    normalFont));

            document.add(new Paragraph(
                    "HR Rounds : "
                            + noteService.getHRRounds(),
                    normalFont));

            document.add(new Paragraph(" "));
            document.add(new Paragraph(
                    "End Of Report",
                    headingFont));

            document.close();

            System.out.println("PDF Report Generated Successfully!");
            System.out.println("Saved at : " + path);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}