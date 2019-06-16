//Shahan Rahman CSC 221 Assignment 3
//Spring 2019


import java.util.Date;

public class CD extends MultiMediaItem {
    private String artist;

    public CD(String id, String title, Date addedOn, int playingTime, String artist) {
        super(id, title, addedOn, playingTime);
        this.id = id;
        this.title = title;
        this.addedOn = addedOn;
        this.playingTime = playingTime;
        this.artist = artist;
    }

    public void setArtist(String artist){ this.artist = artist; }

    @Override
    public String getArtist(){ return artist; }

    @Override
    public void setPlayingTime(int playingTime) { this.playingTime = playingTime; }

    @Override
    public int getPlayingTime() { return this.playingTime; }

    @Override
    public void setID(String id) { this.id = id; }

    @Override
    public String getID() { return this.id; }

    @Override
    public void setTitle(String title) { this.title = title; }

    @Override
    public String getTitle() { return this.title; }

    @Override
    public void setDate(Date addedOn) { this.addedOn = addedOn; }

    @Override
    public Date getDate() { return this.addedOn; }

    @Override
    public int compareTo(Item o) { return 0; }

    @Override
    public String getDirector() { return "N/a"; }

    @Override
    public String getAuthor() { return "N/a"; }
}