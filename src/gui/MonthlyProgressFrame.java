package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Font;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

import data.model.StudyRecord;
import data.model.service.StudyService;

public class MonthlyProgressFrame extends JFrame {

    public MonthlyProgressFrame() {

        setTitle("Monthly Study Progress");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        StudyService studyService = new StudyService();
        studyService.loadRecords();

        add(new GraphPanel(studyService.getAllRecords()));

        setVisible(true);
    }

    class GraphPanel extends JPanel {

        int[] monthlyHours = new int[12];

        public GraphPanel(ArrayList<StudyRecord> records) {

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy hh:mm a");

            int currentYear =
                    LocalDateTime.now().getYear();

            for (StudyRecord record : records) {

                try {

                    LocalDateTime dateTime =
                            LocalDateTime.parse(
                                    record.dateTime,
                                    formatter);

                    if (dateTime.getYear() == currentYear) {

                        int month =
                                dateTime.getMonthValue() - 1;

                        monthlyHours[month] +=
                                record.hoursStudied;
                    }

                } catch (Exception e) {

                    System.out.println(
                            "Date Parse Error: "
                                    + record.dateTime);
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            g.setFont(
                    new Font("Arial", Font.BOLD, 18));

            g.drawString(
                    "Monthly Study Hours",
                    290,
                    40);

            g.drawLine(60, 70, 60, 380);
            g.drawLine(60, 380, 740, 380);

            String[] months = {
                    "Jan", "Feb", "Mar", "Apr",
                    "May", "Jun", "Jul", "Aug",
                    "Sep", "Oct", "Nov", "Dec"
            };

            int barWidth = 35;
            int gap = 20;

            for (int i = 0; i < 12; i++) {

                int x =
                        75 + i * (barWidth + gap);

                int barHeight =
                        monthlyHours[i] * 10;

                g.fillRect(
                        x,
                        380 - barHeight,
                        barWidth,
                        barHeight);

                g.drawString(
                        monthlyHours[i] + "h",
                        x,
                        370 - barHeight);

                g.drawString(
                        months[i],
                        x,
                        405);
            }
        }
    }
}