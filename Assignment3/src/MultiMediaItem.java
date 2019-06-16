//Shahan Rahman CSC 221 Assignment 3
//Spring 2019



import java.util.Date;
public abstract class MultiMediaItem extends Item {
    protected int playingTime;

    public MultiMediaItem(String id, String title, Date addedOn, int playingTime){
        super(id,title,addedOn);
        this.id = id;
        this.title = title;
        this.addedOn = addedOn;
        this.playingTime = playingTime;
    }
    public abstract void setPlayingTime(int playingTime);
    public abstract int getPlayingTime();


}