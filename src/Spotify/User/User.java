package src.User;

import src.Music.Music;
import src.Music.Playlist;
import src.User.Behavior.RegularBehavior;
import src.User.Behavior.UserBehavior;
import src.exception.InvalidOperationException;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList;
    private ArrayList<User> followingList;
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists;
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        if (checkExistName(username)) {
            throw new InvalidOperationException("Username Already exist");
        }

        if (password.length() < 8 ) {
            throw new InvalidOperationException("password length must be more than 8");
        }

        if (password == null || password.isEmpty()) {
            throw new InvalidOperationException("password can't be empty or NULL");
        }

        this.username = username;
        this.password = password;
        this.followerList = new ArrayList<>();
        this.followingList = new ArrayList<>();
        this.playlists = new ArrayList<>();
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public boolean checkExistName(String username) {
        for ( User user : allUsers) {
            if(user.getUsername().equals(username)) return true;
        }
        return false;
    }

    public void follow(User user) {
        if (user == null) {
            throw new InvalidOperationException("invalid Username for follow");
        }

        if (user == this) {
            throw new InvalidOperationException("You can't follow yourself");
        }

        if (!followerList.contains(user)) {
            followingList.add(user);
            user.followerList.add(this);
        }

        else {
            throw new InvalidOperationException("You Already follow this username");
        }
    }

    public void createPlayList(String title) {
        this.behavior.createPlaylist(title, this);
    }

    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium(int month) {
        behavior.buyPremium(this, month);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<User> getFollowerList() {
        return followerList;
    }

    public ArrayList<User> getFollowingList() {
        return followingList;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    @Override
    public String toString() {
        return this.username;
    }

}
