package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import data.model.CompanyRecord;
import data.model.service.CompanyService;

public class CompanyFrame extends JFrame {

    public CompanyFrame() {

        setTitle("Company Tracker");

        setSize(550, 450);

        setLocationRelativeTo(null);

        setLayout(null);

        CompanyService companyService = new CompanyService();
        companyService.loadCompanies();

        // Title
        JLabel title = new JLabel("Company Tracker");
        title.setBounds(150, 20, 250, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // Company Name
        JLabel companyLabel = new JLabel("Company Name");
        companyLabel.setBounds(50, 80, 120, 25);
        add(companyLabel);

        JTextField companyField = new JTextField();
        companyField.setBounds(180, 80, 250, 25);
        add(companyField);

        // Role
        JLabel roleLabel = new JLabel("Role");
        roleLabel.setBounds(50, 130, 120, 25);
        add(roleLabel);

        JTextField roleField = new JTextField();
        roleField.setBounds(180, 130, 250, 25);
        add(roleField);

        // Status
        JLabel statusLabel = new JLabel("Status");
        statusLabel.setBounds(50, 180, 120, 25);
        add(statusLabel);

        JTextField statusField = new JTextField();
        statusField.setBounds(180, 180, 250, 25);
        add(statusField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(170, 300, 110, 35);

        add(saveButton);

       JButton showButton = new JButton("Show Records");
showButton.setBounds(320, 300, 170, 35);
add(showButton);

JButton searchButton = new JButton("Search");
searchButton.setBounds(20, 300, 110, 35);
add(searchButton);

JButton updateButton = new JButton("Update");
updateButton.setBounds(500, 300, 110, 35);
add(updateButton);

JButton deleteButton = new JButton("Delete");
deleteButton.setBounds(20, 350, 110, 35);
add(deleteButton);

        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                if (companyField.getText().isEmpty()
        || roleField.getText().isEmpty()
        || statusField.getText().isEmpty()) {

    JOptionPane.showMessageDialog(null,
            "Please fill all fields!");

    return;
}

                CompanyRecord record = new CompanyRecord();

                record.companyName = companyField.getText();
                record.role = roleField.getText();
                record.status = statusField.getText();
               

                companyService.addCompany(record);

                JOptionPane.showMessageDialog(null,
                        "Company Record Saved Successfully!");

                companyField.setText("");
                roleField.setText("");
                statusField.setText("");
                
            }
        });

        showButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        new ShowCompanyRecordsFrame();

    }
});

searchButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        CompanyRecord company = companyService.searchCompany(companyField.getText());

if (company != null) {

    JOptionPane.showMessageDialog(null,
            "Company : " + company.companyName +
            "\nRole : " + company.role +
            "\nStatus : " + company.status +
            "\nApplied Date : " + company.appliedDate);

} else {

    JOptionPane.showMessageDialog(null,
            "Company Not Found!");

}

    }
});

updateButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (companyField.getText().isEmpty() || statusField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Enter Company Name and New Status!");

            return;
        }

        companyService.updateCompanyStatus(
                companyField.getText(),
                statusField.getText());

        JOptionPane.showMessageDialog(null,
                "Company Status Updated Successfully!");

    }
});

deleteButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (companyField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Enter Company Name!");

            return;
        }

        int option = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to delete this company?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {

            companyService.deleteCompany(companyField.getText());

            JOptionPane.showMessageDialog(null,
                    "Company Deleted Successfully!");

            companyField.setText("");
            roleField.setText("");
            statusField.setText("");
        }
    }
});

        setVisible(true);
    }
}