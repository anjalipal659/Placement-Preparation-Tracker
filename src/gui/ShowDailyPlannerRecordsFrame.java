package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.model.DailyPlannerRecord;
import data.model.service.DailyPlannerService;

public class ShowDailyPlannerRecordsFrame extends JFrame {

    public ShowDailyPlannerRecordsFrame() {

        setTitle("Daily Planner Records");

        setSize(700, 400);

        setLocationRelativeTo(null);

        setLayout(null);

        DailyPlannerService plannerService = new DailyPlannerService();
        plannerService.loadPlans();

        ArrayList<DailyPlannerRecord> records = plannerService.getAllPlans();

        String[] columns = {
                "Date & Time",
                "Task",
                "Time",
                "Priority"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (int i = records.size() - 1; i >= 0; i--) {

    DailyPlannerRecord record = records.get(i);

    model.addRow(new Object[] {
    record.dateTime,
    record.task,
    record.time,
    record.priority
});
}
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 650, 300);

        add(scrollPane);

        setVisible(true);
    }
}