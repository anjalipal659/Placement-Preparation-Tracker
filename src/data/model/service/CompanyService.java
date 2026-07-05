package data.model.service;

import java.util.ArrayList;
import data.model.CompanyRecord;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CompanyService {

    ArrayList<CompanyRecord> companyRecords = new ArrayList<>();

    public void addCompany(CompanyRecord company) {

    companyRecords.add(company);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
company.appliedDate = LocalDateTime.now().format(formatter);

    try {

        FileWriter writer = new FileWriter("company_records.txt", true);

        writer.write("Applied Date : " + company.appliedDate + "\n");
        writer.write("Company : " + company.companyName + "\n");
        writer.write("Role : " + company.role + "\n");
        writer.write("Status : " + company.status + "\n");
        writer.write("--------------------------\n");

        writer.close();

    } catch (IOException e) {

        System.out.println("Error Saving File!");
    }
}

    public void showCompanies() {

        if (companyRecords.isEmpty()) {
            System.out.println("No Company Records Found!");
            return;
        }

        for (CompanyRecord c : companyRecords) {
            System.out.println("--------------------------------------");
            System.out.println("Applied Date : " + c.appliedDate);
            System.out.println("Company : " + c.companyName);
            System.out.println("Role    : " + c.role);
            System.out.println("Status  : " + c.status);
        }
    }
    public void loadCompanies() {

    companyRecords.clear();

    try {

        BufferedReader reader = new BufferedReader(new FileReader("company_records.txt"));
        String appliedDate;
        String company;
        String role;
        String status;
        String separator;

        while ((appliedDate = reader.readLine()) != null) {
            company = reader.readLine();
            role = reader.readLine();
            status = reader.readLine();
            separator = reader.readLine();

            CompanyRecord record = new CompanyRecord();

            record.appliedDate = appliedDate.replace("Applied Date : ", "");
            record.companyName = company.replace("Company : ", "");
            record.role = role.replace("Role : ", "");
            record.status = status.replace("Status : ", "");

            companyRecords.add(record);
        }

        reader.close();

    } catch (IOException e) {

        // File first time run par nahi hogi
    }
}
public void saveCompaniesToFile() {

    try {

        FileWriter writer = new FileWriter("company_records.txt");

        for (CompanyRecord company : companyRecords) {

            writer.write("Applied Date : " + company.appliedDate + "\n");
            writer.write("Company : " + company.companyName + "\n");
            writer.write("Role : " + company.role + "\n");
            writer.write("Status : " + company.status + "\n");
            writer.write("--------------------------\n");
        }

        writer.close();

    } catch (IOException e) {

        System.out.println("Error Saving File!");
    }
}
   public int getTotalCompanies() {
    return companyRecords.size();
}

public int getSelectedCompanies() {

    int count = 0;

    for (CompanyRecord company : companyRecords) {

        if (company.status.equalsIgnoreCase("Selected")) {
            count++;
        }
    }

    return count;
}

public int getRejectedCompanies() {

    int count = 0;

    for (CompanyRecord company : companyRecords) {

        if (company.status.equalsIgnoreCase("Rejected")) {
            count++;
        }
    }

    return count;
}

public int getPendingCompanies() {

    int count = 0;

    for (CompanyRecord company : companyRecords) {

        if (company.status.equalsIgnoreCase("Applied") ||
            company.status.equalsIgnoreCase("Pending")) {

            count++;
        }
    }

    return count;
}

public void searchCompany(String companyName) {

    for (CompanyRecord c : companyRecords) {

        if (c.companyName.equalsIgnoreCase(companyName)) {

            System.out.println("\n========= SEARCH RESULT =========");
            System.out.println("Company : " + c.companyName);
            System.out.println("Role    : " + c.role);
            System.out.println("Status  : " + c.status);
            System.out.println("================================");

            return;
        }
    }

    System.out.println("Company Not Found!");
}
public void updateCompanyStatus(String companyName, String newStatus) {

    for (CompanyRecord c : companyRecords) {

        if (c.companyName.equalsIgnoreCase(companyName)) {

            c.status = newStatus;
            saveCompaniesToFile();

            System.out.println("\nStatus Updated Successfully!");
            return;
        }
    }

    System.out.println("Company Not Found!");
}
public void deleteCompany(String companyName) {

    for (int i = 0; i < companyRecords.size(); i++) {

        if (companyRecords.get(i).companyName.equalsIgnoreCase(companyName)) {

            companyRecords.remove(i);
            saveCompaniesToFile();

            System.out.println("\nCompany Deleted Successfully!");
            return;
        }
    }

    System.out.println("Company Not Found!");
}
}