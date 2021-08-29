package com.assessment.lab;

public class ITAdministration {


    public static final String COMPANY_NAME = "GREATLEARNING";

    public static void main(String[] args) {
        CredentialService credentialService = new CredentialService();
        Employee employee = new Employee("Srihita", "Maturu");
        int departmentChoice=3;
        switch (departmentChoice) {
            case 1:
                employee.setDepartment("Technical");
                break;
            case 2:
                employee.setDepartment("Admin");
                break;
            case 3:
                employee.setDepartment("Human Resource");
                break;
            case 4:
                employee.setDepartment("Legal");
                break;
        }

        employee.setEmailId(credentialService.generateEmailAddress(employee));
        employee.showCredentials();
    }


}
