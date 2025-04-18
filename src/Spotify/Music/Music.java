package src.Music;

import src.User.User;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream = 0;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer) {
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public void play() {
        numberOfStream++;
        System.out.println("Music: " + getTitle() + "\nSinger: " + getSinger().toString() + "\nNumber of Stream: " + getNumberOfStream() + "\nis playing");
        System.out.println();
    }

    public static ArrayList<Music> search(String title) {
        ArrayList<Music> searchOfMusicTitle = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.getTitle().equalsIgnoreCase(title)) {
                searchOfMusicTitle.add(music);
            }
        }
        return searchOfMusicTitle;
    }

    public static Music search(String title, User singer) {
        for (Music music : allMusics) {
            if ( music.getTitle().equalsIgnoreCase(title) && music.getSinger().equals(singer)) {
                return music;
            }
        }
        return null;
    }

    public String getTitle() {
        return title;
    }

    public User getSinger() {
        return singer;
    }

    public int getNumberOfStream() {
        return numberOfStream;
    }



}
