package com.company;
import java.time.*;



public class HeartRates
{
    private String fName, lName;
    private int dobMonth, dobDay, dobYear;

    HeartRates(String fName, String lName, int dobMonth, int dobDay, int dobYear)
    {
        this.fName = fName;
        this.lName = lName;
        this.dobMonth = dobMonth;
        this.dobDay = dobDay;
        this.dobYear = dobYear;
    }

    // Returns age in years
    public int ageCalculator(int dobYear, int dobMonth, int dobDay)
    {

        LocalDate pdate = LocalDate.of(dobYear, dobMonth, dobDay);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(pdate, now);
        return diff.getYears();
    }

    public int maxHeartRate(int age)
    {
        //beats per minute is 220 minus your age in years
        return 220 - age;
    }

    public void targetHeartRange(int age)
    {
        double bottomRange = maxHeartRate(age) * .50;
        double topRange = maxHeartRate(age) * .85;

        System.out.println("Your target heart range is: " + bottomRange + "-" + topRange);

    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }

    public int getDobDay() {
        return dobDay;
    }

    public void setDobDay(int dobDay) {
        this.dobDay = dobDay;
    }

    public int getDobYear() {
        return dobYear;
    }

    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }

}
