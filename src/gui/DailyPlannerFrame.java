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

        setSize(650, 450);

        setLocationRelativeTo(null);

        setLayout(null);

        DailyPlannerService plannerService = new DailyPlannerService();
        plannerService.loadPlans();
        System.out.println("Loaded Plans: " + plannerService.getTotalPlans());

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
        saveButton.setBounds(160, 250, 110, 35);
        add(saveButton);

       JButton showButton = new JButton("Show Records");
showButton.setBounds(300, 250, 150, 35);
add(showButton);

JButton searchButton = new JButton("Search");
searchButton.setBounds(20, 250, 110, 35);
add(searchButton);

JButton updateButton = new JButton("Update");
updateButton.setBounds(470, 250, 110, 35);
add(updateButton);

JButton deleteButton = new JButton("Delete");
deleteButton.setBounds(20, 310, 110, 35);
add(deleteButton);


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
System.out.println("Searching: [" + taskField.getText() + "]");

searchButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        String taskName = JOptionPane.showInputDialog(
                null,
                "Enter Task Name:");

        if (taskName == null || taskName.trim().isEmpty()) {
            return;
        }

        DailyPlannerRecord plan =
                plannerService.searchPlan(taskName.trim());

        if (plan != null) {

            taskField.setText(plan.task);
            timeField.setText(plan.time);
            priorityField.setText(plan.priority);

            JOptionPane.showMessageDialog(null,
                    "Plan Found!");

        } else {

            JOptionPane.showMessageDialog(null,
                    "Plan Not Found!");
        }
    }
});




updateButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        String taskName = JOptionPane.showInputDialog(
                null,
                "Enter Task Name to Update:");

        if (taskName == null || taskName.trim().isEmpty()) {
            return;
        }

        if (timeField.getText().trim().isEmpty()
                || priorityField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Enter New Time and Priority!");

            return;
        }

        boolean updated = plannerService.updatePlan(
                taskName.trim(),
                timeField.getText().trim(),
                priorityField.getText().trim());

        if (updated) {

            JOptionPane.showMessageDialog(null,
                    "Plan Updated Successfully!");

        } else {

            JOptionPane.showMessageDialog(null,
                    "Plan Not Found!");
        }
    }
});


deleteButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        String taskName = JOptionPane.showInputDialog(
                null,
                "Enter Task Name to Delete:");

        if (taskName == null || taskName.trim().isEmpty()) {
            return;
        }

        int option = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to delete this plan?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {

            boolean deleted = plannerService.deletePlan(taskName.trim());

            if (deleted) {

                JOptionPane.showMessageDialog(null,
                        "Plan Deleted Successfully!");

            } else {

                JOptionPane.showMessageDialog(null,
                        "Plan Not Found!");
            }
        }
    }
});

        setVisible(true);
    }


}