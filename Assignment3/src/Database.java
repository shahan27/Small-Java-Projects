//Shahan Rahman CSC 221 Assignment 3
//Spring 2019


import java.util.ArrayList;
import java.util.List;


public class Database {
    protected List<Item> items;

    public Database() { items = new ArrayList<Item>(); }

    public void addItem(Item item) {items.add(item);}

    public void removeItem(int index){ items.remove(index); }

    public void clearDatabase(){ items.clear(); }

    public void list(){
        System.out.println("Index\t ID \t Title \t\t\t\t\t Date\t\t\t\t\t\t Director/Artist/Author\t\t\t\tPlaying Time\n"
                + "-----\t ----\t --------------------\t ----------------------------\t ----------------------\t\t---------------");
        int index = 1;
        for(Item i : items){
            if(i.getClass().equals(Textbook.class)){
                System.out.printf("%-8d %-7s %-23s %-31s %-30s %-2s%n",index++, i.getID(),i.getTitle(),i.getDate(),i.getAuthor(),"Not Applicable");
            }
            else if(i.getClass().equals(Video.class)){
                System.out.printf("%-8d %-7s %-23s %-31s %-30s %-2d%n",index++, i.getID(),i.getTitle(),i.getDate(),i.getDirector(),i.getPlayingTime());
            }
            else if(i.getClass().equals(CD.class)){
                System.out.printf("%-8d %-7s %-23s %-31s %-30s %-2d%n",index++, i.getID(),i.getTitle(),i.getDate(),i.getArtist(), i.getPlayingTime());
            }
        }
    }
}