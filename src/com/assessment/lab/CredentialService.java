package com.assessment.lab;

public class CredentialService {

    public final int PASSWORD_LENGTH = 8;

    public String generateEmailAddress(Employee employee) {
        String emailId = "";
        emailId = employee.getFirstName() + employee.getLastName() + "." + employee.getDepartment() + "@"
                + ITAdministration.COMPANY_NAME + ".com";
        return emailId.toLowerCase();
    }

//  public String generatePassword() {

//    }
}
