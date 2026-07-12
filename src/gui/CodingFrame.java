package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import data.model.CodingRecord;
import data.model.service.CodingService;

public class CodingFrame extends JFrame {

    public CodingFrame() {

        setTitle("Coding Tracker");

        setSize(600, 450);

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
        saveButton.setBounds(140, 300, 120, 35);
        add(saveButton);

        // Show Records Button
        JButton showButton = new JButton("Show Records");
        showButton.setBounds(260, 300, 150, 35);
        add(showButton);

        // Search Button
JButton searchButton = new JButton("Search");
searchButton.setBounds(20, 300, 100, 35);
add(searchButton);

JButton updateButton = new JButton("Update");
updateButton.setBounds(430, 300, 100, 35);
add(updateButton);

JButton deleteButton = new JButton("Delete");
deleteButton.setBounds(20, 360, 100, 35);
add(deleteButton);

        // Save Button Action
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if (platformField.getText().isEmpty()
                            || questionsField.getText().isEmpty()
                            || difficultyField.getText().isEmpty()
                            || streakField.getText().isEmpty()) {

                        JOptionPane.showMessageDialog(null,
                                "Please fill all fields!");

                        return;
                    }

                    CodingRecord record = new CodingRecord();

                    record.platform = platformField.getText();
                    record.questionsSolved = Integer.parseInt(questionsField.getText());
                    record.difficulty = difficultyField.getText();
                  record.currentStreak = Integer.parseInt(streakField.getText());

                    codingService.addCodingRecord(record);

                    JOptionPane.showMessageDialog(null,
                            "Coding Record Saved Successfully!");

                    platformField.setText("");
                    questionsField.setText("");
                    difficultyField.setText("");
                    streakField.setText("");

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(null,
                            "Please enter valid numbers!");

                }

            }
        });

        // Show Records Button Action
        showButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new ShowCodingRecordsFrame();

            }
        });

        searchButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        CodingRecord record =
                codingService.searchCodingRecord(platformField.getText());

        if (record != null) {

            JOptionPane.showMessageDialog(null,
                    "Platform : " + record.platform +
                    "\nQuestions : " + record.questionsSolved +
                    "\nDifficulty : " + record.difficulty +
                    "\nStreak : " + record.currentStreak +
                    "\nDate & Time : " + record.dateTime);

        } else {

            JOptionPane.showMessageDialog(null,
                    "Coding Record Not Found!");
        }
    }
});

updateButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (platformField.getText().isEmpty()
                    || questionsField.getText().isEmpty()
                    || difficultyField.getText().isEmpty()
                    || streakField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Please fill all fields!");

                return;
            }

            int newQuestions =
                    Integer.parseInt(questionsField.getText());

            int newStreak =
                    Integer.parseInt(streakField.getText());

            boolean updated = codingService.updateCodingRecord(
                    platformField.getText(),
                    newQuestions,
                    difficultyField.getText(),
                    newStreak);

            if (updated) {

                JOptionPane.showMessageDialog(null,
                        "Coding Record Updated Successfully!");

            } else {

                JOptionPane.showMessageDialog(null,
                        "Coding Record Not Found!");
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null,
                    "Please enter valid numbers!");
        }
    }
});

deleteButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (platformField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Please enter platform name!");

            return;
        }

        boolean deleted = codingService.deleteCodingRecord(
                platformField.getText());

        if (deleted) {

            JOptionPane.showMessageDialog(null,
                    "Coding Record Deleted Successfully!");

            platformField.setText("");
            questionsField.setText("");
            difficultyField.setText("");
            streakField.setText("");

        } else {

            JOptionPane.showMessageDialog(null,
                    "Coding Record Not Found!");
        }
    }
});

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
    }
}