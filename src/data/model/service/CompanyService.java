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
}