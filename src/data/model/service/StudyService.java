package data.model.service;
import java.util.ArrayList;
import data.model.StudyRecord;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
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
    public ArrayList<StudyRecord> getAllRecords() {
    return studyRecords;
}

public StudyRecord searchStudyRecord(String subjectName) {

    StudyRecord foundRecord = null;

    for (StudyRecord record : studyRecords) {

        if (record.subjectName.equalsIgnoreCase(subjectName)) {
            foundRecord = record;
        }
    }

    return foundRecord;
}

public boolean updateStudyRecord(String subjectName, int newHours, String newGoal) {

    for (int i = studyRecords.size() - 1; i >= 0; i--) {

        StudyRecord record = studyRecords.get(i);

        if (record.subjectName.equalsIgnoreCase(subjectName)) {

            record.hoursStudied = newHours;
            record.todayGoal = newGoal;

            saveStudyRecordsToFile();

            return true;
        }
    }

    return false;
}

public void saveStudyRecordsToFile() {

    try {

        FileWriter writer = new FileWriter("study_records.txt");

        for (StudyRecord record : studyRecords) {

            writer.write("Date & Time : " + record.dateTime + "\n");
            writer.write("Subject : " + record.subjectName + "\n");
            writer.write("Hours : " + record.hoursStudied + "\n");
            writer.write("Goal : " + record.todayGoal + "\n");
            writer.write("--------------------------\n");
        }

        writer.close();

    } catch (IOException e) {

        System.out.println("Error Saving File!");
    }
}

public boolean deleteStudyRecord(String subjectName) {

    for (int i = studyRecords.size() - 1; i >= 0; i--) {

        StudyRecord record = studyRecords.get(i);

        if (record.subjectName.equalsIgnoreCase(subjectName)) {

            studyRecords.remove(i);

            saveStudyRecordsToFile();

            return true;
        }
    }

    return false;
}

public String getMostStudiedSubject() {

    if (studyRecords.isEmpty()) {
        return "No Data";
    }

    String subject = "";
    int maxHours = 0;

    for (StudyRecord record : studyRecords) {

        if (record.hoursStudied > maxHours) {

            maxHours = record.hoursStudied;
            subject = record.subjectName;
        }
    }

    return subject + " (" + maxHours + " hrs)";
}

public int getTotalStudyDays() {

    java.util.HashSet<String> days =
            new java.util.HashSet<>();

    for (StudyRecord record : studyRecords) {

        if (record.dateTime.length() >= 10) {

            days.add(record.dateTime.substring(0, 10));
        }
    }

    return days.size();
}

public String getBestStudyDay() {

    if (studyRecords.isEmpty()) {

        return "No Data";
    }

    String bestDay = "";
    int maxHours = 0;

    for (StudyRecord record : studyRecords) {

        if (record.hoursStudied > maxHours) {

            maxHours = record.hoursStudied;
            bestDay = record.dateTime.substring(0, 10);
        }
    }

    return bestDay + " (" + maxHours + " hrs)";
}

public int getStudyStreak() {

    if (studyRecords.isEmpty()) {
        return 0;
    }

    HashSet<LocalDate> uniqueDates = new HashSet<>();

    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    for (StudyRecord record : studyRecords) {

        try {

            String date =
                    record.dateTime.substring(0, 10);

            uniqueDates.add(
                    LocalDate.parse(date, formatter));

        } catch (Exception e) {

            // Ignore invalid dates
        }
    }

    ArrayList<LocalDate> dates =
            new ArrayList<>(uniqueDates);

    dates.sort(null);

    if (dates.isEmpty()) {
        return 0;
    }

    int streak = 1;
    int maxStreak = 1;

    for (int i = 1; i < dates.size(); i++) {

        long days =
                ChronoUnit.DAYS.between(
                        dates.get(i - 1),
                        dates.get(i));

        if (days == 1) {

            streak++;

        } else {

            streak = 1;
        }

        if (streak > maxStreak) {

            maxStreak = streak;
        }
    }

    return maxStreak;
}
}
