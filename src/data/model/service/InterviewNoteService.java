package data.model.service;

import java.util.ArrayList;
import data.model.InterviewNote;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InterviewNoteService {

    ArrayList<InterviewNote> interviewNotes = new ArrayList<>();

    public void addNote(InterviewNote note) {

    interviewNotes.add(note);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
note.dateTime = LocalDateTime.now().format(formatter);

    try {

        FileWriter writer = new FileWriter("interview_notes.txt", true);

        writer.write("Date & Time : " + note.dateTime + "\n");
        writer.write("Company : " + note.companyName + "\n");
        writer.write("Round : " + note.interviewRound + "\n");
        writer.write("Notes : " + note.notes + "\n");
        writer.write("--------------------------\n");

        writer.close();

    } catch (IOException e) {

        System.out.println("Error Saving File!");
    }
}
    public void showNotes() {

        if (interviewNotes.isEmpty()) {
            System.out.println("No Interview Notes Found!");
            return;
        }

        for (InterviewNote n : interviewNotes) {
            System.out.println("--------------------------------------");
            System.out.println("Date & Time : " + n.dateTime);
            System.out.println("Company : " + n.companyName);
            System.out.println("Round   : " + n.interviewRound);
            System.out.println("Notes   : " + n.notes);
        }
    }
    public void loadNotes() {

    interviewNotes.clear();

    try {

        BufferedReader reader = new BufferedReader(new FileReader("interview_notes.txt"));

        String dateTime;
        String company;
        String round;
        String notes;
        String separator;

        while ((dateTime = reader.readLine()) != null) {

            company = reader.readLine();
            round = reader.readLine();
            notes = reader.readLine();
            separator = reader.readLine();

            InterviewNote note = new InterviewNote();

            note.dateTime = dateTime.replace("Date & Time : ", "");
            note.companyName = company.replace("Company : ", "");
            note.interviewRound = round.replace("Round : ", "");
            note.notes = notes.replace("Notes : ", "");

            interviewNotes.add(note);
        }

        reader.close();

    } catch (IOException e) {

        // First run par file nahi hogi
    }
}
    public int getTotalNotes(){
        return interviewNotes.size();
    }

    public ArrayList<InterviewNote> getAllNotes() {
    return interviewNotes;
}
}