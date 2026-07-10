package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import data.model.InterviewNote;
import data.model.service.InterviewNoteService;

public class InterviewNoteFrame extends JFrame {

    public InterviewNoteFrame() {

        setTitle("Interview Notes");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setLayout(null);

        InterviewNoteService noteService = new InterviewNoteService();
        noteService.loadNotes();

        // Title
        JLabel title = new JLabel("Interview Notes");
        title.setBounds(150, 20, 220, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // Company
        JLabel companyLabel = new JLabel("Company");
        companyLabel.setBounds(50, 80, 100, 25);
        add(companyLabel);

        JTextField companyField = new JTextField();
        companyField.setBounds(150, 80, 220, 25);
        add(companyField);

        // Round
        JLabel roundLabel = new JLabel("Round");
        roundLabel.setBounds(50, 130, 100, 25);
        add(roundLabel);

        JTextField roundField = new JTextField();
        roundField.setBounds(150, 130, 220, 25);
        add(roundField);

        // Notes
        JLabel notesLabel = new JLabel("Notes");
        notesLabel.setBounds(50, 180, 100, 25);
        add(notesLabel);

        JTextField notesField = new JTextField();
        notesField.setBounds(150, 180, 220, 25);
        add(notesField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(170, 250, 120, 35);
        add(saveButton);

        JButton showButton = new JButton("Show Records");
showButton.setBounds(310, 250, 140, 35);
add(showButton);

        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (companyField.getText().isEmpty()
                        || roundField.getText().isEmpty()
                        || notesField.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null,
                            "Please fill all fields!");

                    return;
                }

                InterviewNote note = new InterviewNote();

                note.companyName = companyField.getText();
                note.interviewRound = roundField.getText();
                note.notes = notesField.getText();

                noteService.addNote(note);

                JOptionPane.showMessageDialog(null,
                        "Interview Note Saved Successfully!");

                companyField.setText("");
                roundField.setText("");
                notesField.setText("");
            }
        });

        showButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        new ShowInterviewNotesFrame();

    }
});

        setVisible(true);
    }
}