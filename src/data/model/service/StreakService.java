package data.model.service;

import data.model.Streak;

import java.io.*;
import java.time.LocalDate;

public class StreakService {

    private static final String FILE_NAME = "streak.txt";

    private Streak streak;

    public StreakService() {
        loadStreak();
    }

    public Streak getStreak() {
        return streak;
    }

    public void loadStreak() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            streak = new Streak();
            saveStreak();
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            int current = Integer.parseInt(br.readLine());
            int best = Integer.parseInt(br.readLine());
            LocalDate lastDate = LocalDate.parse(br.readLine());

            streak = new Streak(current, best, lastDate);

        } catch (Exception e) {

            streak = new Streak();
        }
    }

    public void saveStreak() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {

            pw.println(streak.getCurrentStreak());
            pw.println(streak.getBestStreak());
            pw.println(streak.getLastStudyDate());

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void updateStreak() {

        LocalDate today = LocalDate.now();

        if (streak.getLastStudyDate() == null) {

            streak.setCurrentStreak(1);
            streak.setBestStreak(1);
            streak.setLastStudyDate(today);

        } else {

            LocalDate last = streak.getLastStudyDate();

            if (last.equals(today.minusDays(1))) {

                streak.setCurrentStreak(
                        streak.getCurrentStreak() + 1);

            } else if (!last.equals(today)) {

                streak.setCurrentStreak(1);
            }

            if (streak.getCurrentStreak()
                    > streak.getBestStreak()) {

                streak.setBestStreak(
                        streak.getCurrentStreak());
            }

            streak.setLastStudyDate(today);
        }

        saveStreak();
    }
}