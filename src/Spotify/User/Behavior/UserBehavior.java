package src.User.Behavior;

import src.Music.Music;
import src.User.User;

public interface UserBehavior {
    void createPlaylist (String Title, User Owner);
    void playMusic (Music music);
    void buyPremium (User owner, int month);
}
