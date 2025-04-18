package src.User.Behavior;

import src.Music.Music;
import src.User.User;
import src.exception.InvalidOperationException;

public class RegularBehavior implements UserBehavior{

    private int playingLimit = 5;
    @Override
    public void createPlaylist(String Title, User Owner) {
        throw new InvalidOperationException("Regular Account can't create Playlist");
    }

    @Override
    public void playMusic(Music music) {
        if ( playingLimit <= 0) {
            throw new InvalidOperationException("You reached limit play");
        }

        music.play();
        playingLimit --;
    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior(month));
        System.out.println("Congratulation\nYou switched to Premium Account");
    }

    public int getPlayingLimit() {
        return playingLimit;
    }

    public void setPlayingLimit(int playingLimit) {
        this.playingLimit = playingLimit;
    }
}
