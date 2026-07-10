package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.model.CompanyRecord;
import data.model.service.CompanyService;

public class ShowCompanyRecordsFrame extends JFrame {

    public ShowCompanyRecordsFrame() {

        setTitle("Company Records");

        setSize(700, 400);

        setLocationRelativeTo(null);

        setLayout(null);

        CompanyService companyService = new CompanyService();
        companyService.loadCompanies();

        ArrayList<CompanyRecord> records = companyService.getAllCompanies();

        String[] columns = {
                "Applied Date",
                "Company",
                "Role",
                "Status"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (CompanyRecord record : records) {

            model.addRow(new Object[] {
                    record.appliedDate,
                    record.companyName,
                    record.role,
                    record.status
            });

        }

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 650, 300);

        add(scrollPane);

        setVisible(true);
    }
}