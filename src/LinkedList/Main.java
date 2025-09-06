package LinkedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Song{
    String title;
    String artist;
    int duration;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", duration=" + duration +
                '}';
    }
}

public class Main {
    public static void shufflesongs(LinkedList<Song> list){
        Collections.shuffle(list);
    }
    public static int totalDuration(LinkedList<Song> list){
        int total=0;
        for(Song s: list){
            total=total+s.duration;
        }
        return total;
    }

    public static void main(String[] args) {
        LinkedList<Song> list=new LinkedList<>();
        list.add(new Song("Shape of you","Ed sheeran",240));
        list.add(new Song("Blinding lights","The weeknd",200));
        list.add(new Song("DhonBur","Shakil",190));

        for(Song s: list){
            System.out.println(s.toString());
        }
        //shuffle
        shufflesongs(list);
        System.out.println("\nShuffled songs: ");
        for(Song s: list){
            System.out.println(s.toString());
        }

    }
}
