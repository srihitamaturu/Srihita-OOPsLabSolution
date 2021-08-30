package com.assessment.lab;

import java.util.HashMap;
import java.util.Random;

public class CredentialService {

    public final int PASSWORD_LENGTH = 8;

    private HashMap<String, String> departmentChoices;

    public CredentialService() {
        departmentChoices = new HashMap<>();
        departmentChoices.put("Technical", "tech");
        departmentChoices.put("Admin", "admin");
        departmentChoices.put("Human Resource", "hr");
        departmentChoices.put("Legal", "legal");
    }

    public void generateEmailAddress(Employee employee) {
        String emailId;
        emailId = employee.getFirstName() + employee.getLastName() + "." + departmentChoices.get(employee.getDepartment()) + "@"
                + ITAdministration.COMPANY_NAME.replace(" ", "") + ".com";
        employee.setEmailId(emailId.toLowerCase());
    }


    public String generatePassword() {
        //Initializing standard input set to generate password
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()_+-={}[]:;'<>?,./'";
        String values = capitalLetters + smallLetters + numbers + specialCharacters;

        //Initializing flags to verify if password meets required criteria
        boolean capitalLettersPresent = false;
        boolean smallLettersPresent = false;
        boolean numbersPresent = false;
        boolean specialCharsPresent = false;
        boolean allVariationsPresent = false;

        char pwdChar;
        Random random = new Random();
        char[] password = new char[PASSWORD_LENGTH];
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            // Set the password character to a random value from the complete set of alphanumerics allowed
            pwdChar = values.charAt(random.nextInt(values.length()));

            //When we reached the last 3 chars, Verify that atleast one char of Small Letters, Capital Letters,
            // Numbers and Special Characters exist in the password.
            if (i >= (PASSWORD_LENGTH - 3) && !allVariationsPresent) {
                //Check the full length of current password for required variations
                for (int j = 0; j < i; j++) {
                    // Check if Capital letters are present
                    if (capitalLetters.contains(String.valueOf(password[j]))) {
                        capitalLettersPresent = true;
                    } // Check if small letters are present
                    else if (smallLetters.contains(String.valueOf(password[j]))) {
                        smallLettersPresent = true;
                    }// Check if numbers are present
                    else if (numbers.contains(String.valueOf(password[j]))) {
                        numbersPresent = true;
                    } // Check if special characters are present
                    else if (specialCharacters.contains(String.valueOf(password[j]))) {
                        specialCharsPresent = true;
                    }
                    //Exit the loop if all variations are present after current iteration
                    if (capitalLettersPresent && smallLettersPresent && numbersPresent && specialCharsPresent) {
                        allVariationsPresent = true;
                        break;
                    }
                }
                //If any variation is not present in current password, replace current char with a random value of the missing type
                if (!allVariationsPresent) {
                    // Set the current char to Capital Letter if that is missing
                    if (!capitalLettersPresent) {
                        pwdChar = capitalLetters.charAt(random.nextInt(capitalLetters.length()));
                        capitalLettersPresent = true;
                    } // Set the current char to Small Letter if that is missing
                    else if (!smallLettersPresent) {
                        pwdChar = smallLetters.charAt(random.nextInt(smallLetters.length()));
                        smallLettersPresent = true;
                    } // Set the current char to Number if that is missing
                    else if (!numbersPresent) {
                        pwdChar = numbers.charAt(random.nextInt(numbers.length()));
                        numbersPresent = true;
                    } // Set the current char to Special Character if that is missing
                    else {
                        pwdChar = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
                        specialCharsPresent = true;
                    }
                }
            }
            password[i] = pwdChar;
        }
        return String.valueOf(password);
    }
}