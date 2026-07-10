package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import data.model.DailyPlannerRecord;
import data.model.service.DailyPlannerService;

public class DailyPlannerFrame extends JFrame {

    public DailyPlannerFrame() {

        setTitle("Daily Planner");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setLayout(null);

        DailyPlannerService plannerService = new DailyPlannerService();
        plannerService.loadPlans();

        // Title
        JLabel title = new JLabel("Daily Planner");
        title.setBounds(160, 20, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // Task
        JLabel taskLabel = new JLabel("Task");
        taskLabel.setBounds(50, 80, 100, 25);
        add(taskLabel);

        JTextField taskField = new JTextField();
        taskField.setBounds(150, 80, 220, 25);
        add(taskField);

        // Time
        JLabel timeLabel = new JLabel("Time");
        timeLabel.setBounds(50, 130, 100, 25);
        add(timeLabel);

        JTextField timeField = new JTextField();
        timeField.setBounds(150, 130, 220, 25);
        add(timeField);

        // Priority
        JLabel priorityLabel = new JLabel("Priority");
        priorityLabel.setBounds(50, 180, 100, 25);
        add(priorityLabel);

        JTextField priorityField = new JTextField();
        priorityField.setBounds(150, 180, 220, 25);
        add(priorityField);

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

                if (taskField.getText().isEmpty()
                        || timeField.getText().isEmpty()
                        || priorityField.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null,
                            "Please fill all fields!");

                    return;
                }

                DailyPlannerRecord plan = new DailyPlannerRecord();

                plan.task = taskField.getText();
                plan.time = timeField.getText();
                plan.priority = priorityField.getText();

                plannerService.addPlan(plan);

                JOptionPane.showMessageDialog(null,
                        "Daily Plan Saved Successfully!");

                taskField.setText("");
                timeField.setText("");
                priorityField.setText("");
            }
        });

        showButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        new ShowDailyPlannerRecordsFrame();

    }
});

        setVisible(true);
    }
}