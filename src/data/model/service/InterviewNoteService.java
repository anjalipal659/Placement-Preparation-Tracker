package data.model.service;

import java.util.ArrayList;
import data.model.InterviewNote;

public class InterviewNoteService {

    ArrayList<InterviewNote> interviewNotes = new ArrayList<>();

    public void addNote(InterviewNote note) {
        interviewNotes.add(note);
    }

    public void showNotes() {

        if (interviewNotes.isEmpty()) {
            System.out.println("No Interview Notes Found!");
            return;
        }

        for (InterviewNote n : interviewNotes) {
            System.out.println("--------------------------------------");
            System.out.println("Company : " + n.companyName);
            System.out.println("Round   : " + n.interviewRound);
            System.out.println("Notes   : " + n.notes);
        }
    }
}