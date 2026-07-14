package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import data.model.service.CodingService;
import data.model.service.CompanyService;
import data.model.service.DailyPlannerService;
import data.model.service.InterviewNoteService;
import data.model.service.StudyService;
import data.model.service.GoalService;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Dashboard");
        setSize(750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ================= SERVICES =================

        StudyService studyService = new StudyService();
        studyService.loadRecords();

        CodingService codingService = new CodingService();
        codingService.loadCodingRecords();

        CompanyService companyService = new CompanyService();
        companyService.loadCompanies();

        DailyPlannerService plannerService =
                new DailyPlannerService();
        plannerService.loadPlans();

        InterviewNoteService noteService =
                new InterviewNoteService();
        noteService.loadNotes();

        GoalService goalService = new GoalService();

        int studyGoal = goalService.loadStudyGoal();
        int codingGoal = goalService.loadCodingGoal();

        // ================= TITLE =================

        JLabel title = new JLabel(
                "Placement Preparation Tracker Dashboard");

        title.setBounds(145, 20, 500, 35);
        title.setFont(
                new Font("Arial", Font.BOLD, 22));

        add(title);

        // ================= DASHBOARD PANEL =================

        JPanel dashboardPanel = new JPanel();

        dashboardPanel.setBounds(
                40, 80, 650, 370);

        dashboardPanel.setLayout(
                new GridLayout(2, 3, 15, 15));

        add(dashboardPanel);

        // ================= STUDY CARD =================

        JPanel studyCard = createCard("STUDY");

        studyCard.add(new JLabel(
                "Study Records : "
                        + studyService.getTotalRecords()));

        studyCard.add(new JLabel(
                "Study Hours : "
                        + studyService.getTotalStudyHours()));

        int studyHours =
                (int) studyService.getTotalStudyHours();

        JProgressBar studyProgress =
                new JProgressBar(0, studyGoal);

        studyProgress.setValue(
                Math.min(studyHours, studyGoal));

        studyProgress.setStringPainted(true);

        studyProgress.setString(
                studyHours
                        + " / "
                        + studyGoal
                        + " Hours");

        studyCard.add(studyProgress);

        JButton updateGoalButton = new JButton("Update Goal");

updateGoalButton.addActionListener(e -> {

    String goalInput = JOptionPane.showInputDialog(
            this,
            "Enter New Study Goal (Hours):");

    if (goalInput == null
            || goalInput.trim().isEmpty()) {
        return;
    }

    try {

        int newGoal =
                Integer.parseInt(goalInput.trim());

        if (newGoal <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Goal must be greater than 0!");

            return;
        }

        goalService.saveStudyGoal(newGoal);

        studyProgress.setMaximum(newGoal);

        studyProgress.setValue(
                Math.min(studyHours, newGoal));

        studyProgress.setString(
                studyHours + " / "
                        + newGoal + " Hours");

        JOptionPane.showMessageDialog(
                this,
                "Study Goal Updated Successfully!");

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number!");
    }
});

studyCard.add(updateGoalButton);

        dashboardPanel.add(studyCard);

        // ================= CODING CARD =================

      // ================= CODING CARD =================

JPanel codingCard = createCard("CODING");

codingCard.add(new JLabel(
        "Coding Sessions : "
                + codingService.getTotalCodingRecords()));

codingCard.add(new JLabel(
        "Questions Solved : "
                + codingService.getTotalQuestionsSolved()));

int solvedQuestions =
        codingService.getTotalQuestionsSolved();

JProgressBar codingProgress =
        new JProgressBar(0, codingGoal);

codingProgress.setValue(
        Math.min(solvedQuestions, codingGoal));

codingProgress.setStringPainted(true);

codingProgress.setString(
        solvedQuestions + " / "
                + codingGoal + " Questions");

codingCard.add(codingProgress);

JButton updateCodingGoalButton =
        new JButton("Update Goal");

updateCodingGoalButton.addActionListener(e -> {

    String goalInput = JOptionPane.showInputDialog(
            this,
            "Enter New Coding Goal (Questions):");

    if (goalInput == null
            || goalInput.trim().isEmpty()) {
        return;
    }

    try {

        int newGoal =
                Integer.parseInt(goalInput.trim());

        if (newGoal <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Goal must be greater than 0!");

            return;
        }

        goalService.saveCodingGoal(newGoal);

        codingProgress.setMaximum(newGoal);

        codingProgress.setValue(
                Math.min(solvedQuestions, newGoal));

        codingProgress.setString(
                solvedQuestions + " / "
                        + newGoal + " Questions");

        JOptionPane.showMessageDialog(
                this,
                "Coding Goal Updated Successfully!");

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number!");
    }
});

codingCard.add(updateCodingGoalButton);

dashboardPanel.add(codingCard);

        // ================= COMPANY CARD =================

        JPanel companyCard =
                createCard("COMPANIES");

        companyCard.add(new JLabel(
                "Applied : "
                        + companyService
                        .getTotalCompanies()));

        companyCard.add(new JLabel(
                "Selected : "
                        + companyService
                        .getSelectedCompanies()));

        companyCard.add(new JLabel(
                "Rejected : "
                        + companyService
                        .getRejectedCompanies()));

        companyCard.add(new JLabel(
                "Pending : "
                        + companyService
                        .getPendingCompanies()));

        dashboardPanel.add(companyCard);

        // ================= DAILY PLANNER =================

        JPanel plannerCard =
                createCard("DAILY PLANNER");

        plannerCard.add(new JLabel(
                "Total Plans : "
                        + plannerService
                        .getTotalPlans()));

        dashboardPanel.add(plannerCard);

        // ================= INTERVIEW NOTES =================

        JPanel interviewCard =
                createCard("INTERVIEW NOTES");

        interviewCard.add(new JLabel(
                "Total Notes : "
                        + noteService
                        .getTotalNotes()));

        dashboardPanel.add(interviewCard);

        // ================= FRAME =================

        setVisible(true);
    }

    private JPanel createCard(String cardTitle) {

        JPanel card = new JPanel();

        card.setLayout(
                new GridLayout(5, 1, 5, 5));

        card.setBorder(
                BorderFactory
                        .createTitledBorder(cardTitle));

        return card;
    }
}