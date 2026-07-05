package gui;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Placement Preparation Tracker");

        setSize(800, 600);

        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Placement Preparation Tracker");

title.setBounds(180, 30, 500, 40);

title.setFont(new Font("Arial", Font.BOLD, 24));

add(title);
JButton studyButton = new JButton("Study Tracker");
studyButton.setBounds(250, 100, 250, 35);
add(studyButton);

JButton codingButton = new JButton("Coding Tracker");
codingButton.setBounds(250, 150, 250, 35);
add(codingButton);

JButton companyButton = new JButton("Company Tracker");
companyButton.setBounds(250, 200, 250, 35);
add(companyButton);

JButton plannerButton = new JButton("Daily Planner");
plannerButton.setBounds(250, 250, 250, 35);
add(plannerButton);

JButton interviewButton = new JButton("Interview Notes");
interviewButton.setBounds(250, 300, 250, 35);
add(interviewButton);

JButton dashboardButton = new JButton("Dashboard");
dashboardButton.setBounds(250, 350, 250, 35);
add(dashboardButton);

JButton exitButton = new JButton("Exit");
exitButton.setBounds(250, 420, 250, 35);
add(exitButton);

        setVisible(true);
    }
}