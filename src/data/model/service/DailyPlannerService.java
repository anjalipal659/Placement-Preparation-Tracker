package data.model.service;

import data.model.DailyPlannerRecord;


import java.util.ArrayList;



public class DailyPlannerService {

    ArrayList<DailyPlannerRecord> plannerRecords = new ArrayList<>();

    public void addPlan(DailyPlannerRecord plan) {
        plannerRecords.add(plan);
    }

    public void showPlans() {

        if (plannerRecords.isEmpty()) {
            System.out.println("No Daily Plans Found!");
            return;
        }

        for (DailyPlannerRecord p : plannerRecords) {

            System.out.println("--------------------------------------");
            System.out.println("Task     : " + p.task);
            System.out.println("Time     : " + p.time);
            System.out.println("Priority : " + p.priority);

        }
    }
    public int getTotalPlans(){
        return plannerRecords.size();
    }
}