package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.model.InterviewNote;
import data.model.service.InterviewNoteService;

public class ShowInterviewNotesFrame extends JFrame {

    public ShowInterviewNotesFrame() {

        setTitle("Interview Notes");

        setSize(700, 400);

        setLocationRelativeTo(null);

        setLayout(null);

        InterviewNoteService noteService = new InterviewNoteService();
        noteService.loadNotes();

        ArrayList<InterviewNote> records = noteService.getAllNotes();

        String[] columns = {
                "Date & Time",
                "Company",
                "Round",
                "Notes"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (InterviewNote record : records) {

            model.addRow(new Object[] {
                    record.dateTime,
                    record.companyName,
                    record.interviewRound,
                    record.notes
            });

        }

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 650, 300);

        add(scrollPane);

        setVisible(true);
    }
}