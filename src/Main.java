package src;

import src.User.User;
import src.Music.Music;
import src.Music.Playlist;

import src.exception.InvalidOperationException;

public class Main {
    public static void main(String[] args) {
        new UserTest().run();
        new MusicTest().run();
        new PremiumTest().run();
    }

    static class UserTest {
        public void run() {
            System.out.println("--- User Test ---");

            try {
                User ali = new User("ali", "12345678");
                User sara = new User("sara", "12345678");

                ali.follow(sara);
                System.out.println("ali is now following sara");

                User duplicateUser = new User("ali", "newpassword123");
            } catch (InvalidOperationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static class MusicTest {
        public void run() {
            System.out.println("--- Music Test ---");

            try {
                User singer = new User("singer", "12345678");
                Music song1 = new Music("Track 1", singer);
                Music song2 = new Music("Track 2", singer);

                singer.playMusic(song1);
                singer.playMusic(song2);

                User regularUser = new User("regularUser", "12345678");
                regularUser.playMusic(song1);
                regularUser.playMusic(song2);
                regularUser.playMusic(song1);
                regularUser.playMusic(song2);
                regularUser.playMusic(song1);
                regularUser.playMusic(song2);
            } catch (InvalidOperationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static class PremiumTest {
        public void run() {
            System.out.println("--- Premium Test ---");

            try {
                User user = new User("premiumUser", "mypassword");
                user.buyPremium(user, 3);
                System.out.println("Congratulation\nYou switched to Premium Account");

                Music music = new Music("Chill Vibes", user);
                user.createPlayList("MyPlaylist", user);
                Playlist playlist = user.getPlaylists().get(0);
                System.out.println("PlayList created Successfully");

                playlist.addMusic(music, "mypassword");
                playlist.playPlaylist();

                playlist.addMusic(music, "wrongpassword");
            } catch (InvalidOperationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
