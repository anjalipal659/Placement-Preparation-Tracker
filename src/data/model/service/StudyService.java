package data.model.service;
import java.util.ArrayList;
import data.model.StudyRecord;
public class StudyService {
    ArrayList<StudyRecord> studyRecords = new ArrayList<>();
    public void addRecord(StudyRecord record){
        studyRecords.add(record);
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
    public int getTotalRecords(){
        return studyRecords.size();
    }
}
