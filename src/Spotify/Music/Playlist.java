package src.Music;

import src.User.User;
import src.exception.InvalidOperationException;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private String title;
    private ArrayList<Music> playLists;
    private User owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
        this.playLists = new ArrayList<>();
    }

    public void editTitle(String title, String password) {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("password is not correct");
        }

        if (getTitle().equals(title)) {
            throw new InvalidOperationException("PlayList name already is " + title);
        }

        setTitle(title);
    }

    public void addMusic(Music music, String password) {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("password is not correct");
        }

        if (music == null) {
            throw new InvalidOperationException("Music is NULL");
        }

        for ( Music song : playLists) {
            if (song.equals(music) && music != null) {
                throw new InvalidOperationException("this music already exist in PlayList");
            }
        }

        playLists.add(music);
    }

    public void removeMusic(Music music, String password) {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("password is not correct");
        }
        boolean flag = false;

        for ( Music song : playLists) {
            if (song.equals(music)) {
                flag = true;
            }
        }

        if (flag) {
            playLists.remove(music);
        }

        else {
            throw new InvalidOperationException("This PlayList does'nt contain this Music");
        }

    }

    public ArrayList<Music> searchInPlaylist(String title) {
        ArrayList<Music> searchOfMusicTitle = new ArrayList<>();
        for ( Music music : playLists) {
            if (music.getTitle().equalsIgnoreCase(title)) {
                searchOfMusicTitle.add(music);
            }
        }
        return searchOfMusicTitle;
    }

    public Music searchInPlaylist(String title, User singer) {
        for (Music music : playLists) {
            if (music.getTitle().equalsIgnoreCase(title) && music.getSinger().equals(singer)) {
                return music;
            }
        }
        return null;
    }

    public void playPlaylist() {
        Scanner sc = new Scanner(System.in);
        for (Music music : playLists) {
            music.play();
        }
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getOwner() {
        return owner;
    }

}
