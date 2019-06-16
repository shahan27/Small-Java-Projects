package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
	    //Problem 1
        int age;
        Scanner input = new Scanner(System.in);
        System.out.println("How old are you?");
        age = input.nextInt();
        if (age < 13)
        {
            System.out.println("You are young");
        }
        else if(age<20)
        {
            System.out.println("You are a teenager");
        }
        else
        {
            System.out.println("You are an adult");
        }

        //Problem 2
        String favColor;
        System.out.println("What is your favorite color?");
        favColor = input.next();
        favColor = favColor.toLowerCase();
        boolean colorSelected = true;
        while(colorSelected)
        {
            colorSelected = false;
            switch (favColor)
            {
                case "green":
                    System.out.println("Color of the Nature!");
                    break;
                case "blue":
                    System.out.println("Color of the Sky!");
                    break;
                case "yellow":
                    System.out.println("Color of the Sun!");
                    break;
                case "red":
                    System.out.println("Color of the Rose!");
                    break;
                case "orange":
                    System.out.println("Color of the Tiger!");
                    break;
                case "pink":
                    System.out.println("Color of the Spring!");
                    break;
                case "grey":
                    System.out.println("Color of the Brain!");
                    break;
                default:
                    System.out.println("Please enter another favorite color?");
                    favColor = input.next();
                    colorSelected = true;
            }

        }


        //Problem 3
        int m;
        double n;
        int pow;
        int smallestPower = -1;
        System.out.println("Enter a number?");
        m = input.nextInt();
        for(int i = 0; Math.pow(2,i) <= m; i++)
        {
            smallestPower = smallestPower + 1;
        }
        pow = smallestPower;
        System.out.printf("Smallest power of 2 to %d is %d .\n" ,m, pow);
        n = Math.pow(2,pow);
        if(n < 100)
        {
            for (int i = 0; i<=n; i++)
            {
                System.out.print("\n");
                for (int j = 0; j<=n; j++)
                {
                    double fij = Math.pow((n/2-i),2) + Math.pow((n/2-j),2);
                    if(Math.sqrt(fij)<(n/2))
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
            }
        }

    }
}