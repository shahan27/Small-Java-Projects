package com.company;
import java.util.Random;

public class Navigator
{
    public Random ranNumGen = new Random();
    private Node currentNode;
    private int P;

    public void navigate(int N){
        int currentCol = 0;
        while(currentCol < N){
            int ranNum = ranNumGen.nextInt(100);
            if(ranNum >= 0 && ranNum <= P){
                currentNode = currentNode.getUp();
                currentCol = currentNode.getPeriod();
                System.out.println("T = " + currentCol);
                System.out.println("Movement = " + currentNode.getDirection());
                System.out.println("Random Number = " + ranNum);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else if(ranNum > P && ranNum <= 100){
                currentNode = currentNode.getDown();
                currentCol = currentNode.getPeriod();
                System.out.println("T = " + currentCol);
                System.out.println("Movement = " + currentNode.getDirection());
                System.out.println("Random Number = " + ranNum);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public void setP(int P) {
        this.P = P;
    }


}
