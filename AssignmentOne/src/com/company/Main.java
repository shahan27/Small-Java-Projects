package com.company;

import java.util.*;
import javax.swing.JOptionPane;

public class Main
{
        public static boolean isNumber(String word) {
            try {
                double d = Double.parseDouble(word);
            } catch (NumberFormatException | NullPointerException nfe) {
                return false;
            }
            return true;
        }

        public static boolean isValid(String word)
        {
            if(word.length() != 8)
                return false;
            try
            {
                Integer i = Integer.parseInt(word);
            }
            catch(NumberFormatException e)
            {
                return false;
            }
            return true;
        }
        public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);  // Reading from System.in
        System.out.println("Please enter your first name.");
        String fName = input.next();
        System.out.println("Please enter your last name.");
        String lName = input.next();
        System.out.println("Please enter your date of birth without spaces. EX:MMDDYYYY");
        String userDate = input.next();
        while(!isNumber(userDate) && !isValid(userDate))
        {
            JOptionPane.showMessageDialog(null, "ERROR MESSAGE: That's not correct please follow the DOB format!\n Please enter your date of birth without spaces. EX:MMDDYYYY", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("ERROR MESSAGE: That's not correct please follow the DOB format!");
            System.out.println("Please enter your date of birth without spaces. EX:MMDDYYYY");
            userDate=input.next();
        }
        if(userDate.length()==8) {
            int dobYear = Integer.parseInt(userDate.substring(4));
            int dobMonth = Integer.parseInt(userDate.substring(0, 2));
            int dobDay = Integer.parseInt(userDate.substring(2, 4));

            HeartRates heartRates = new HeartRates(fName, lName, dobMonth, dobDay, dobYear);

            int age = heartRates.ageCalculator(heartRates.getDobYear(), heartRates.getDobMonth(), heartRates.getDobDay());

            System.out.println("You are " + age + " years old");
            System.out.println("Your maximum heart rate is: " + heartRates.maxHeartRate(age));
            heartRates.targetHeartRange(age);
        }
    }
}


/*
2
 pt: properly exhibits right logic, i.e., readable and compilable coding
2
 pt: properly reads personal information from terminal
2
 pt: properly writes maximum and target heart rates to terminal
2
 pt: properly writes error message to terminal in response to incorrect input
extra
 credit: properly interfaces with dialog boxes (see 3.19)
 */
