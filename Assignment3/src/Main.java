//Shahan Rahman CSC 221 Assignment 3
//Spring 2019



import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Main {

    public static void main (String[] args) {

        Calendar calendar = Calendar.getInstance();
        Database library = new Database();
        Compare chain = new Compare();


        //sort items by ID (default)
        class Comparison implements Comparator<Item> {
            public int compare(Item i1, Item i2) {
                return i1.getID().compareTo(i2.getID());
            }
        }

        //sort items by their title
        class sortByTitle implements Comparator<Item> {
            public int compare(Item i1, Item i2) {
                return i1.getTitle().compareTo(i2.getTitle());
            }
        }
        //sort items by the date added
        class sortByAddedOn implements Comparator<Item> {
            public int compare(Item i1, Item i2) {
                return i1.getDate().compareTo(i2.getDate());
            }
        }

        //sort by director, artist, author
        class sortByDirector implements Comparator<Item> {
            @Override
            public int compare(Item i1, Item i2) {
                if (i1.getClass().equals(Textbook.class))
                    return i1.getAuthor().compareTo(i2.getAuthor());
                else if (i1.getClass().equals(CD.class))
                    return i1.getArtist().compareTo(i2.getArtist());
                else
                    return i1.getDirector().compareTo(i2.getDirector());
            }
        }


        // adding database entries
        calendar.set(1890, Calendar.AUGUST, 10);
        Date date = (Date) calendar.getTime();
        library.addItem(new Textbook("TB15", "TextX", date, "John Doe"));

        calendar.set(1954, Calendar.JANUARY, 18);
        date = (Date) calendar.getTime();
        library.addItem(new Video("V09", "VideoB", date, 70000, "J. Smith"));

        calendar.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) calendar.getTime();
        library.addItem(new Textbook("TB01", "TextY", date, "John Doe"));

        calendar.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) calendar.getTime();
        library.addItem(new CD("CD07", "CD1", date, 1000, "B.D."));

        calendar.set(1990, Calendar.APRIL, 30);
        date = (Date) calendar.getTime();
        library.addItem(new CD("CD10", "CD1", date, 800, "X.Y."));

        calendar.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) calendar.getTime();
        library.addItem(new CD("CD05", "CD1", date, 1000, "B.C."));

        calendar.set(1890, Calendar.JULY, 2);
        date = (Date) calendar.getTime();
        library.addItem(new Video("V12", "VideoA", date, 7000, "Joe Smith"));


        System.out.println("********* Library Database! *********");



        // print unsorted database
        System.out.println("\n DATABASE BEFORE SORTING: \n");
        library.list();



        //sort and print sorted database (by id)
        Comparison Default = new Comparison();
        Collections.sort(library.items, Default);
        System.out.println("\n DATABASE AFTER SORTING BY ID (default): \n");
        library.list();




        // EXTRA CREDIT
        System.out.println("----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
        System.out.println("------------ (title, addedOn, director) -----------\n");

        chain.addComparator(new sortByTitle());
        chain.addComparator(new sortByAddedOn());
        chain.addComparator(new sortByDirector());
        Collections.sort(library.items, chain);
        library.list();
    }
}