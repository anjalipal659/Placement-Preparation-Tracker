package data.model.service;

import java.util.ArrayList;
import data.model.CodingRecord;

public class CodingService {

    ArrayList<CodingRecord> codingRecords = new ArrayList<>();

    public void addCodingRecord(CodingRecord record) {
        codingRecords.add(record);
    }

    public void showCodingRecords() {

        if (codingRecords.isEmpty()) {
            System.out.println("No Coding Records Found!");
            return;
        }

        for (CodingRecord c : codingRecords) {

            System.out.println("--------------------------------------");
            System.out.println("Platform   : " + c.platform);
            System.out.println("Questions  : " + c.questionsSolved);
            System.out.println("Difficulty : " + c.difficulty);
            System.out.println("Streak     : " + c.currentStreak);
        }
    }

    public int getTotalCodingRecords() {
        return codingRecords.size();
    }
}