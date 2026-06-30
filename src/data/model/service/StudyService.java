package data.model.service;
import java.util.ArrayList;
import data.model.StudyRecord;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class StudyService {
    ArrayList<StudyRecord> studyRecords = new ArrayList<>();
    public void addRecord(StudyRecord record) {

    studyRecords.add(record);

    try {

        FileWriter writer = new FileWriter("study_records.txt", true);

        writer.write("Subject : " + record.subjectName + "\n");
        writer.write("Hours : " + record.hoursStudied + "\n");
        writer.write("Goal : " + record.todayGoal + "\n");
        writer.write("--------------------------\n");

        writer.close();

    } catch (IOException e) {

        System.out.println("Error Saving File!");
    }
}
    
    
    public void showRecords(){
        if (studyRecords.isEmpty()){
            System.out.println("No Study Records Found!");
            return;
        }
        for (StudyRecord r : studyRecords){
            System.out.println("--------------------------------------");
            System.out.println("Subject : " + r.subjectName);
              System.out.println("Hours : " + r.hoursStudied);
                System.out.println("Goal : " + r.todayGoal);
        }

    }
    public void readRecords() {

    try {

        BufferedReader reader = new BufferedReader(new FileReader("study_records.txt"));

        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();

    } catch (IOException e) {

        System.out.println("No File Found!");
    }
}
    public int getTotalRecords(){
        return studyRecords.size();
    }
    
}
