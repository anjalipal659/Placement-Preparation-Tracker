package data.model.service;
import java.util.ArrayList;
import data.model.StudyRecord;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class StudyService {
    ArrayList<StudyRecord> studyRecords = new ArrayList<>();
    public void addRecord(StudyRecord record) {

    studyRecords.add(record);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
record.dateTime = LocalDateTime.now().format(formatter);

    try {

        FileWriter writer = new FileWriter("study_records.txt", true);
        writer.write("Date & Time : " + record.dateTime + "\n");
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
            System.out.println("Date & Time : " + r.dateTime);
            System.out.println("Subject : " + r.subjectName);
              System.out.println("Hours : " + r.hoursStudied);
                System.out.println("Goal : " + r.todayGoal);
        }

    }
    public void loadRecords() {

    studyRecords.clear();

    try {

        BufferedReader reader = new BufferedReader(new FileReader("study_records.txt"));

        String dateTime;
String subject;
String hours;
String goal;
String separator;

while ((dateTime = reader.readLine()) != null) {

    subject = reader.readLine();
    hours = reader.readLine();
    goal = reader.readLine();
    separator = reader.readLine();

    StudyRecord record = new StudyRecord();

    record.dateTime = dateTime.replace("Date & Time : ", "");
    record.subjectName = subject.replace("Subject : ", "");
    record.hoursStudied = Integer.parseInt(hours.replace("Hours : ", ""));
    record.todayGoal = goal.replace("Goal : ", "");

    studyRecords.add(record);
}

        reader.close();

    } catch (IOException e) {

        // File first time run par nahi hogi
    }
}
    public int getTotalRecords(){
        return studyRecords.size();
    }

    public int getTotalStudyHours() {

    int totalHours = 0;

    for (StudyRecord record : studyRecords) {

        totalHours += record.hoursStudied;
    }

    return totalHours;
}
    
}
