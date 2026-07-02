package data.model.service;

import data.model.DailyPlannerRecord;


import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;



public class DailyPlannerService {

    ArrayList<DailyPlannerRecord> plannerRecords = new ArrayList<>();

    public void addPlan(DailyPlannerRecord plan) {

    plannerRecords.add(plan);

    try {

        FileWriter writer = new FileWriter("daily_plans.txt", true);

        writer.write("Task : " + plan.task + "\n");
        writer.write("Time : " + plan.time + "\n");
        writer.write("Priority : " + plan.priority + "\n");
        writer.write("--------------------------\n");

        writer.close();

    } catch (IOException e) {

        System.out.println("Error Saving File!");
    }
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
    public void loadPlans() {

    plannerRecords.clear();

    try {

        BufferedReader reader = new BufferedReader(new FileReader("daily_plans.txt"));

        String task;
        String time;
        String priority;
        String separator;

        while ((task = reader.readLine()) != null) {

            time = reader.readLine();
            priority = reader.readLine();
            separator = reader.readLine();

            DailyPlannerRecord plan = new DailyPlannerRecord();

            plan.task = task.replace("Task : ", "");
            plan.time = time.replace("Time : ", "");
            plan.priority = priority.replace("Priority : ", "");

            plannerRecords.add(plan);
        }

        reader.close();

    } catch (IOException e) {

        // First run par file nahi hogi
    }
}
    public int getTotalPlans(){
        return plannerRecords.size();
    }
}