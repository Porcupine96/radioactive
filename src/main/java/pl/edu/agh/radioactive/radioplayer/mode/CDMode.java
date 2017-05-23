package pl.edu.agh.radioactive.radioplayer.mode;

import pl.edu.agh.radioactive.radioplayer.PlayerMode;
import pl.edu.agh.radioactive.radioplayer.PlayerState;
import pl.edu.agh.radioactive.radioplayer.state.CD;

public class CDMode extends PlayerMode {

    @Override
    public void play(PlayerState state) {
        withStateValidation(state, () -> playCurrentSong(state.getCd().get()));
    }

    public void nextSong(PlayerState state) {
        withStateValidation(state, () -> changeCurrentSong(state.getCd().get()));
    }

    private void withStateValidation(PlayerState state, Runnable action) {
        if (!state.isPowerOn()) {
            System.out.println("[ERROR] cannot play - radio player turned off.");
        } else if (!state.getCd().isPresent()) {
            System.out.println("[ERROR] cannot play - please insert a CD.");
        } else {
            action.run();
        }
    }

    private void playCurrentSong(CD cd) {
        System.out.println("[INFO] playing " + cd.getCurrentSong() + " from " + cd.getTitle() + " album");
    }

    private void changeCurrentSong(CD cd) {
        cd.nextSong();
        System.out.println("[INFO] changed current song to " + cd.getCurrentSong());
    }

}
