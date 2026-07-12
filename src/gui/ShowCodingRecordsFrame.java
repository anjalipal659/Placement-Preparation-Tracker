package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.model.CodingRecord;
import data.model.service.CodingService;

public class ShowCodingRecordsFrame extends JFrame {

    public ShowCodingRecordsFrame() {

        setTitle("Coding Records");

        setSize(700, 400);

        setLocationRelativeTo(null);

        setLayout(null);

        CodingService codingService = new CodingService();
        codingService.loadCodingRecords();

        ArrayList<CodingRecord> records = codingService.getAllCodingRecords();

        String[] columns = {
                "Platform",
                "Questions",
                "Difficulty",
                "Current Streak"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (int i = records.size() - 1; i >= 0; i--) {

    CodingRecord record = records.get(i);

    model.addRow(new Object[] {
        record.platform,
        record.questionsSolved,
        record.difficulty,
        record.currentStreak
    });
}

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 650, 300);

        add(scrollPane);

        setVisible(true);
    }
}