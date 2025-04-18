package src.User.Behavior;

import src.Music.Music;
import src.Music.Playlist;
import src.User.User;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public PremiumBehavior(int month) {
        this.month = month;
    }

    @Override
    public void createPlaylist(String title, User owner) {
        Playlist playlist = new Playlist(title, owner);
        owner.getPlaylists().add(playlist);
        System.out.println("PlayList created Successfully");

    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month;
        System.out.println("You Premium Account time updated to " + getMonth() + " months");
    }

    public int getMonth() {
        return month;
    }
}
