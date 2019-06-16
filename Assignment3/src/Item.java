//Shahan Rahman CSC 221 Assignment 3
//Spring 2019



import java.util.Date;
public abstract class Item implements Comparable<Item> {
    protected String id;
    protected String title;
    protected Date addedOn;

    public Item(String id, String title, Date addedOn){
        super();
        this.id = id;
        this.title = title;
        this.addedOn = addedOn;
    }

    public abstract void setID(String id);
    public abstract String getID();
    public abstract void setTitle(String title);
    public abstract String getTitle();
    public abstract void setDate (Date date);
    public abstract Date getDate();
    public abstract String getDirector();
    public abstract String getArtist();
    public abstract String getAuthor();
    public abstract int getPlayingTime();
}
