package data.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import data.model.CodingRecord;


public class CodingService {

    ArrayList<CodingRecord> codingRecords = new ArrayList<>();

    public void addCodingRecord(CodingRecord record) {

    codingRecords.add(record);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
record.dateTime = LocalDateTime.now().format(formatter);

    try {

        FileWriter writer = new FileWriter("coding_records.txt", true);

        writer.write("Date & Time : " + record.dateTime + "\n");

        writer.write("Platform : " + record.platform + "\n");
        writer.write("Questions : " + record.questionsSolved + "\n");
        writer.write("Difficulty : " + record.difficulty + "\n");
        writer.write("Streak : " + record.currentStreak + "\n");
        writer.write("--------------------------\n");

        writer.close();

    } catch (IOException e) {

        System.out.println("Error Saving File!");
    }
}
    public void showCodingRecords() {

        if (codingRecords.isEmpty()) {
            System.out.println("No Coding Records Found!");
            return;
        }

        for (CodingRecord c : codingRecords) {

            System.out.println("--------------------------------------");
            System.out.println("Date & Time: " + c.dateTime);
            System.out.println("Platform   : " + c.platform);
            System.out.println("Questions  : " + c.questionsSolved);
            System.out.println("Difficulty : " + c.difficulty);
            System.out.println("Streak     : " + c.currentStreak);
        }
    }
    public void loadCodingRecords() {

    codingRecords.clear();

    try {

        BufferedReader reader = new BufferedReader(new FileReader("coding_records.txt"));
        String dateTime;
        String platform;
        String questions;
        String difficulty;
        String streak;
        String separator;

       while ((dateTime = reader.readLine()) != null) {

    platform = reader.readLine();
    questions = reader.readLine();
    difficulty = reader.readLine();
    streak = reader.readLine();
    separator = reader.readLine();

    CodingRecord record = new CodingRecord();

    record.dateTime = dateTime.replace("Date & Time : ", "");
    record.platform = platform.replace("Platform : ", "");
    record.questionsSolved = Integer.parseInt(questions.replace("Questions : ", ""));
    record.difficulty = difficulty.replace("Difficulty : ", "");
    record.currentStreak = Integer.parseInt(streak.replace("Streak : ", ""));

    codingRecords.add(record);
}

        reader.close();

    } catch (IOException e) {

        // File first time run par nahi hogi
    }
}

    public int getTotalCodingRecords() {
        return codingRecords.size();
    }

    public int getTotalQuestionsSolved() {

    int totalQuestions = 0;

    for (CodingRecord record : codingRecords) {

        totalQuestions += record.questionsSolved;
    }

    return totalQuestions;
}
public ArrayList<CodingRecord> getAllCodingRecords() {
    return codingRecords;
}
}