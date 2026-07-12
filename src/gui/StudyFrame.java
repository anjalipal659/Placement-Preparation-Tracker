package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import data.model.StudyRecord;
import data.model.service.StudyService;

public class StudyFrame extends JFrame {

    public StudyFrame() {

        setTitle("Study Tracker");

        setSize(650, 450);

        setLocationRelativeTo(null);

        setLayout(null);

        StudyService studyService = new StudyService();
studyService.loadRecords();

        // Title
JLabel title = new JLabel("Study Tracker");
title.setBounds(160, 20, 200, 30);
title.setFont(new Font("Arial", Font.BOLD, 20));
add(title);

// Subject
JLabel subjectLabel = new JLabel("Subject");
subjectLabel.setBounds(50, 80, 100, 25);
add(subjectLabel);

// Hours
JLabel hoursLabel = new JLabel("Hours");
hoursLabel.setBounds(50, 130, 100, 25);
add(hoursLabel);

// Goal
JLabel goalLabel = new JLabel("Goal");
goalLabel.setBounds(50, 180, 100, 25);
add(goalLabel);

JTextField subjectField = new JTextField();
subjectField.setBounds(150, 80, 220, 25);
add(subjectField);

JTextField hoursField = new JTextField();
hoursField.setBounds(150, 130, 220, 25);
add(hoursField);

JTextField goalField = new JTextField();
goalField.setBounds(150, 180, 220, 25);
add(goalField);

JButton saveButton = new JButton("Save");

saveButton.setBounds(170, 250, 110, 35);

add(saveButton);

JButton showButton = new JButton("Show Records");
showButton.setBounds(320, 250, 170, 35);
add(showButton);

JButton searchButton = new JButton("Search");
searchButton.setBounds(20, 250, 110, 35);
add(searchButton);

JButton updateButton = new JButton("Update");
updateButton.setBounds(500, 250, 110, 35);
add(updateButton);

JButton deleteButton = new JButton("Delete");
deleteButton.setBounds(20, 310, 110, 35);
add(deleteButton);

showButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        new ShowStudyRecordsFrame();

    }
});

saveButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            StudyRecord record = new StudyRecord();

            record.subjectName = subjectField.getText();
            record.hoursStudied = Integer.parseInt(hoursField.getText());
            record.todayGoal = goalField.getText();

            studyService.addRecord(record);

            JOptionPane.showMessageDialog(null,
                    "Study Record Saved Successfully!");

            subjectField.setText("");
            hoursField.setText("");
            goalField.setText("");

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null,
                    "Please enter valid hours!");

        }

    }
});

searchButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        StudyRecord record =
                studyService.searchStudyRecord(subjectField.getText());

        if (record != null) {

            JOptionPane.showMessageDialog(null,
                    "Subject : " + record.subjectName +
                    "\nHours : " + record.hoursStudied +
                    "\nGoal : " + record.todayGoal +
                    "\nDate & Time : " + record.dateTime);

        } else {

            JOptionPane.showMessageDialog(null,
                    "Study Record Not Found!");
        }
    }
});

updateButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (subjectField.getText().isEmpty()
                    || hoursField.getText().isEmpty()
                    || goalField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Please fill all fields!");

                return;
            }

            int newHours = Integer.parseInt(hoursField.getText());

            boolean updated = studyService.updateStudyRecord(
                    subjectField.getText(),
                    newHours,
                    goalField.getText());

            if (updated) {

                JOptionPane.showMessageDialog(null,
                        "Study Record Updated Successfully!");

            } else {

                JOptionPane.showMessageDialog(null,
                        "Study Record Not Found!");
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null,
                    "Please enter valid hours!");
        }
    }
});

deleteButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (subjectField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Please enter subject name!");

            return;
        }

        boolean deleted = studyService.deleteStudyRecord(
                subjectField.getText());

        if (deleted) {

            JOptionPane.showMessageDialog(null,
                    "Study Record Deleted Successfully!");

            subjectField.setText("");
            hoursField.setText("");
            goalField.setText("");

        } else {

            JOptionPane.showMessageDialog(null,
                    "Study Record Not Found!");
        }
    }
});

        setVisible(true);
    }
}