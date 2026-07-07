package gui;
import javax.swing.JLabel;
import javax.swing.JTextField;

import data.model.service.CodingService;

import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JFrame;

public class CodingFrame extends JFrame {

    public CodingFrame() {

        setTitle("Coding Tracker");

        setSize(500, 450);

        setLocationRelativeTo(null);

        setLayout(null);

        CodingService codingService = new CodingService();
codingService.loadCodingRecords();

        // Title
JLabel title = new JLabel("Coding Tracker");
title.setBounds(150, 20, 250, 30);
title.setFont(new Font("Arial", Font.BOLD, 20));
add(title);

// Platform
JLabel platformLabel = new JLabel("Platform");
platformLabel.setBounds(50, 80, 100, 25);
add(platformLabel);

JTextField platformField = new JTextField();
platformField.setBounds(170, 80, 220, 25);
add(platformField);

// Questions
JLabel questionsLabel = new JLabel("Questions");
questionsLabel.setBounds(50, 130, 100, 25);
add(questionsLabel);

JTextField questionsField = new JTextField();
questionsField.setBounds(170, 130, 220, 25);
add(questionsField);

// Difficulty
JLabel difficultyLabel = new JLabel("Difficulty");
difficultyLabel.setBounds(50, 180, 100, 25);
add(difficultyLabel);

JTextField difficultyField = new JTextField();
difficultyField.setBounds(170, 180, 220, 25);
add(difficultyField);

// Streak
JLabel streakLabel = new JLabel("Streak");
streakLabel.setBounds(50, 230, 100, 25);
add(streakLabel);

JTextField streakField = new JTextField();
streakField.setBounds(170, 230, 220, 25);
add(streakField);

// Save Button
JButton saveButton = new JButton("Save");
saveButton.setBounds(170, 300, 120, 35);
add(saveButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
    }
}