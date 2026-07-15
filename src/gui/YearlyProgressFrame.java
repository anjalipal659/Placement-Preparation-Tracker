package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Font;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import data.model.StudyRecord;
import data.model.service.StudyService;

public class YearlyProgressFrame extends JFrame {

    public YearlyProgressFrame() {

        setTitle("Yearly Study Progress");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        StudyService studyService =
                new StudyService();

        studyService.loadRecords();

        add(new GraphPanel(
                studyService.getAllRecords()));

        setVisible(true);
    }

    class GraphPanel extends JPanel {

        Map<Integer, Integer> yearlyHours =
                new TreeMap<>();

        public GraphPanel(
                ArrayList<StudyRecord> records) {

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy hh:mm a");

            for (StudyRecord record : records) {

                try {

                    LocalDateTime dateTime =
                            LocalDateTime.parse(
                                    record.dateTime,
                                    formatter);

                    int year =
                            dateTime.getYear();

                    yearlyHours.put(
                            year,
                            yearlyHours.getOrDefault(
                                    year, 0)
                                    + record.hoursStudied);

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
                    "Yearly Study Hours",
                    300,
                    40);

            g.drawLine(60, 70, 60, 380);
            g.drawLine(60, 380, 740, 380);

            int x = 100;

            for (Map.Entry<Integer, Integer> entry
                    : yearlyHours.entrySet()) {

                int hours = entry.getValue();

                int barHeight =
                        Math.min(hours * 10, 280);

                g.fillRect(
                        x,
                        380 - barHeight,
                        80,
                        barHeight);

                g.drawString(
                        hours + "h",
                        x + 20,
                        370 - barHeight);

                g.drawString(
                        String.valueOf(entry.getKey()),
                        x + 15,
                        405);

                x += 140;
            }
        }
    }
}