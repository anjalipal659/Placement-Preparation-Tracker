package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import data.model.service.CodingService;
import data.model.service.CompanyService;
import data.model.service.DailyPlannerService;
import data.model.service.InterviewNoteService;
import data.model.service.StudyService;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Dashboard");

        setSize(600, 500);

        setLocationRelativeTo(null);

        setLayout(null);

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

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("Placement Preparation Tracker Dashboard");
title.setBounds(40, 20, 500, 30);


JLabel studyLabel = new JLabel("Total Study Records : " + studyService.getTotalRecords());
studyLabel.setBounds(50, 80, 300, 25);
add(studyLabel);

JLabel hoursLabel = new JLabel("Total Study Hours : " + studyService.getTotalStudyHours());
hoursLabel.setBounds(50, 110, 300, 25);
add(hoursLabel);

JLabel codingLabel = new JLabel("Total Coding Sessions : " + codingService.getTotalCodingRecords());
codingLabel.setBounds(50, 150, 300, 25);
add(codingLabel);

JLabel questionLabel = new JLabel("Questions Solved : " + codingService.getTotalQuestionsSolved());
questionLabel.setBounds(50, 180, 300, 25);
add(questionLabel);

JLabel companyLabel = new JLabel("Companies Applied : " + companyService.getTotalCompanies());
companyLabel.setBounds(50, 220, 300, 25);
add(companyLabel);

JLabel selectedLabel = new JLabel("Selected : " + companyService.getSelectedCompanies());
selectedLabel.setBounds(50, 250, 300, 25);
add(selectedLabel);

JLabel rejectedLabel = new JLabel("Rejected : " + companyService.getRejectedCompanies());
rejectedLabel.setBounds(50, 280, 300, 25);
add(rejectedLabel);

JLabel pendingLabel = new JLabel("Pending : " + companyService.getPendingCompanies());
pendingLabel.setBounds(50, 310, 300, 25);
add(pendingLabel);

JLabel plannerLabel = new JLabel("Daily Plans : " + plannerService.getTotalPlans());
plannerLabel.setBounds(50, 340, 300, 25);
add(plannerLabel);

JLabel notesLabel = new JLabel("Interview Notes : " + noteService.getTotalNotes());
notesLabel.setBounds(50, 370, 300, 25);
add(notesLabel);

        setVisible(true);
    }
}
