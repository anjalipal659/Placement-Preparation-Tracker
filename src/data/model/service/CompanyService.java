package data.model.service;

import java.util.ArrayList;
import data.model.CompanyRecord;

public class CompanyService {

    ArrayList<CompanyRecord> companyRecords = new ArrayList<>();

    public void addCompany(CompanyRecord company) {
        companyRecords.add(company);
    }

    public void showCompanies() {

        if (companyRecords.isEmpty()) {
            System.out.println("No Company Records Found!");
            return;
        }

        for (CompanyRecord c : companyRecords) {
            System.out.println("--------------------------------------");
            System.out.println("Company : " + c.companyName);
            System.out.println("Role    : " + c.role);
            System.out.println("Status  : " + c.status);
        }
    }
   public int getTotalCompanies() {
    return companyRecords.size();
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

            System.out.println("\nCompany Deleted Successfully!");
            return;
        }
    }

    System.out.println("Company Not Found!");
}
}