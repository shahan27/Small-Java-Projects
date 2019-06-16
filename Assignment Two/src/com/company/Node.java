package com.company;
import java.util.*;

public class Node
{
    private String direction;
    private int period;
    private Node up;
    private Node down;

    public Node(String direction, int period){
        this.direction = direction;
        this.period = period;
    }

    public String getDirection(){
        return this.direction;
    }

    public int getPeriod(){
        return this.period;
    }

    public void setUp(Node node){
        this.up = node;
    }

    public void setDown(Node node){
        this.down = node;
    }

    public Node getUp(){
        return this.up;
    }

    public Node getDown(){
        return this.down;
    }

}
