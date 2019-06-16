package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int T;
        int P;
        int tempT;
        int tempP;
        Scanner input = new Scanner(System.in);
        System.out.println("What is your T value?");
        tempT = input.nextInt();
        while(tempT<=0)
        {
            System.out.println("Please enter a positive T value");
            tempT = input.nextInt();
        }
        T = tempT;
        System.out.println("What is your P value?");
        tempP = input.nextInt();
        while((tempP > 100) || (tempP < 0))
        {
            System.out.println("Please enter a a value between 0-100");
            tempP = input.nextInt();
        }
        P = tempP;
        BinomialTreeFactory tree = BinomialTreeFactory.create(T, P);
        Navigator nav = new Navigator();
        nav.setCurrentNode(tree.getRoot());
        nav.setP(P);
        nav.navigate(T-1);
    }
}

