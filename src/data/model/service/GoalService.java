package data.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GoalService {

    private final String STUDY_GOAL_FILE =
            "study_goal.txt";

    private final String CODING_GOAL_FILE =
            "coding_goal.txt";

    private final String COMPANY_GOAL_FILE =
            "company_goal.txt";

     private final String PLANNER_GOAL_FILE =
        "planner_goal.txt";

        private final String INTERVIEW_GOAL_FILE =
        "interview_goal.txt";

    // ================= STUDY GOAL =================

    public void saveStudyGoal(int goal) {

        saveGoal(STUDY_GOAL_FILE, goal);
    }

    public int loadStudyGoal() {

        return loadGoal(STUDY_GOAL_FILE, 100);
    }

    // ================= CODING GOAL =================

    public void saveCodingGoal(int goal) {

        saveGoal(CODING_GOAL_FILE, goal);
    }

    public int loadCodingGoal() {

        return loadGoal(CODING_GOAL_FILE, 100);
    }


    // ================= COMPANY GOAL =================

public void saveCompanyGoal(int goal) {

    saveGoal(COMPANY_GOAL_FILE, goal);
}

public int loadCompanyGoal() {

    return loadGoal(COMPANY_GOAL_FILE, 50);
}

// ================= PLANNER GOAL =================

public void savePlannerGoal(int goal) {

    saveGoal(PLANNER_GOAL_FILE, goal);
}

public int loadPlannerGoal() {

    return loadGoal(PLANNER_GOAL_FILE, 30);
}

// ================= INTERVIEW GOAL =================

public void saveInterviewGoal(int goal) {

    saveGoal(INTERVIEW_GOAL_FILE, goal);
}

public int loadInterviewGoal() {

    return loadGoal(INTERVIEW_GOAL_FILE, 20);
}
    // ================= SAVE GOAL =================

    private void saveGoal(String fileName, int goal) {

        try {

            FileWriter writer =
                    new FileWriter(fileName);

            writer.write(String.valueOf(goal));

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error Saving Goal!");
        }
    }

    // ================= LOAD GOAL =================

    private int loadGoal(
            String fileName,
            int defaultGoal) {

        int goal = defaultGoal;

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(fileName));

            String value = reader.readLine();

            if (value != null
                    && !value.trim().isEmpty()) {

                goal = Integer.parseInt(
                        value.trim());
            }

            reader.close();

        } catch (IOException
                 | NumberFormatException e) {

            // Default goal use hoga
        }

        return goal;
    }
}