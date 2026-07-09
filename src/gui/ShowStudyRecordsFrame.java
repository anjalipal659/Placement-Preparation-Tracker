package gui;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import data.model.StudyRecord;
import data.model.service.StudyService;

public class ShowStudyRecordsFrame extends JFrame {

    public ShowStudyRecordsFrame() {

        setTitle("Study Records");

        setSize(700, 400);

        setLocationRelativeTo(null);

        setLayout(null);

        StudyService studyService = new StudyService();
studyService.loadRecords();

ArrayList<StudyRecord> records = studyService.getAllRecords();

String[] columns = {
        "Date & Time",
        "Subject",
        "Hours",
        "Goal"
};

DefaultTableModel model = new DefaultTableModel(columns, 0);

for (StudyRecord record : records) {

    model.addRow(new Object[] {
            record.dateTime,
            record.subjectName,
            record.hoursStudied,
            record.todayGoal
    });

}

JTable table = new JTable(model);

JScrollPane scrollPane = new JScrollPane(table);

scrollPane.setBounds(20, 20, 650, 300);

add(scrollPane);

        setVisible(true);
    }
}