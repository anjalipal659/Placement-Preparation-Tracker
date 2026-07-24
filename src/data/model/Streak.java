package data.model;

import java.time.LocalDate;

public class Streak {

    private int currentStreak;
    private int bestStreak;
    private LocalDate lastStudyDate;

    // Default Constructor
    public Streak() {

        this.currentStreak = 0;
        this.bestStreak = 0;
        this.lastStudyDate = null;
    }

    // Parameterized Constructor
    public Streak(int currentStreak,
                  int bestStreak,
                  LocalDate lastStudyDate) {

        this.currentStreak = currentStreak;
        this.bestStreak = bestStreak;
        this.lastStudyDate = lastStudyDate;
    }

    // Getters

    public int getCurrentStreak() {

        return currentStreak;
    }

    public int getBestStreak() {

        return bestStreak;
    }

    public LocalDate getLastStudyDate() {

        return lastStudyDate;
    }

    // Setters

    public void setCurrentStreak(int currentStreak) {

        this.currentStreak = currentStreak;
    }

    public void setBestStreak(int bestStreak) {

        this.bestStreak = bestStreak;
    }

    public void setLastStudyDate(LocalDate lastStudyDate) {

        this.lastStudyDate = lastStudyDate;
    }
}