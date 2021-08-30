package com.assessment.lab;

import java.util.Scanner;

public class ITAdministration {

    public static final String COMPANY_NAME = "GREAT LEARNING";

    public static void main(String[] args) {
        CredentialService credentialService = new CredentialService();
        //Print Welcome message
        Scanner scanInput = new Scanner(System.in);
        System.out.println("Welcome to " + COMPANY_NAME + ".\n"
                + "Please proceed with your registration.\n");

        //Get Employee First Name
        boolean firstNameSet = false;
        String firstName = "";
        while (!firstNameSet) {
            System.out.println("Please enter your first name.");
            firstName = scanInput.nextLine();
            if (firstName != null && !firstName.isEmpty()) {
                firstNameSet = true;
            } else {
                System.out.println("The first name you entered is empty.");
            }
        }

        //Get Employee Last Name
        boolean lastNameSet = false;
        String lastName = "";
        while (!lastNameSet) {
            System.out.println("Please enter your last name.");
            lastName = scanInput.nextLine();
            if (lastName != null && !lastName.isEmpty()) {
                lastNameSet = true;
            } else {
                System.out.println("The last name you entered is empty.");
            }
        }
        Employee employee = new Employee(firstName, lastName);

        //Get Employee Department
        boolean departmentSet = false;
        while (!departmentSet) {
            System.out.println("Please enter the number corresponding to your department from the following:\n"
                    + "1. Technical\n"
                    + "2. Admin\n"
                    + "3. Human Resource\n"
                    + "4. Legal");
            int departmentChoice = scanInput.nextInt();
            departmentSet = true;
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
                default:
                    System.out.println("Please enter a valid number between 1 and 4");
                    departmentSet = false;
                    break;
            }
        }

        //Generate Employee Credentials
        credentialService.generateEmailAddress(employee);
        employee.setPassword(credentialService.generatePassword());
        employee.showCredentials();

        //Print success message
        System.out.println("Success! New Hire registration completed for " +  employee.getFirstName() + " " + employee.getLastName());
    }

}
