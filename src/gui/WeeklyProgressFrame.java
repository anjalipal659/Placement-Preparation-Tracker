package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

import data.model.StudyRecord;
import data.model.service.StudyService;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class WeeklyProgressFrame extends JFrame {

    public WeeklyProgressFrame() {

        setTitle("Weekly Study Progress");

        setSize(700, 450);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        StudyService studyService = new StudyService();

        studyService.loadRecords();

        ArrayList<StudyRecord> records =
                studyService.getAllRecords();

        add(new GraphPanel(records));

        setVisible(true);
    }
}

class GraphPanel extends JPanel {

    private int[] weeklyHours = new int[7];

    private String[] days = {
            "Mon", "Tue", "Wed",
            "Thu", "Fri", "Sat", "Sun"
    };

    public GraphPanel(ArrayList<StudyRecord> records) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy hh:mm a");

                        LocalDate today = LocalDate.now();

LocalDate weekStart =
        today.with(
                TemporalAdjusters.previousOrSame(
                        DayOfWeek.MONDAY));

LocalDate weekEnd =
        today.with(
                TemporalAdjusters.nextOrSame(
                        DayOfWeek.SUNDAY));

        for (StudyRecord record : records) {

            try {

                LocalDateTime dateTime =
                        LocalDateTime.parse(
                                record.dateTime,
                                formatter);

               LocalDate recordDate =
        dateTime.toLocalDate();

if (!recordDate.isBefore(weekStart)
        && !recordDate.isAfter(weekEnd)) {

    DayOfWeek day =
            dateTime.getDayOfWeek();

    int index =
            day.getValue() - 1;

    weeklyHours[index] +=
            record.hoursStudied;
}
            } catch (Exception e) {

                System.out.println(
                        "Date Error: "
                                + record.dateTime);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16));

        g.drawString(
                "Weekly Study Hours",
                250,
                30);

        // Y AXIS

        g.drawLine(
                60,
                60,
                60,
                320);

        // X AXIS

        g.drawLine(
                60,
                320,
                640,
                320);

        int barWidth = 45;

        int gap = 35;

        int startX = 90;

        for (int i = 0;
             i < weeklyHours.length;
             i++) {

            int barHeight =
                    weeklyHours[i] * 15;

            int x =
                    startX
                            + i
                            * (barWidth + gap);

            int y =
                    320 - barHeight;

            g.setColor(Color.BLUE);

            g.fillRect(
                    x,
                    y,
                    barWidth,
                    barHeight);

            g.setColor(Color.BLACK);

            g.drawString(
                    weeklyHours[i]
                            + "h",
                    x + 10,
                    y - 5);

            g.drawString(
                    days[i],
                    x + 7,
                    345);
        }
    }
}