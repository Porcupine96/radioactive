package pl.edu.agh.radioactive.radioplayer;

import pl.edu.agh.radioactive.radioplayer.PlayerState;

public abstract class PlayerMode {

    public abstract void play(PlayerState state);

    void pause(PlayerState state) {
        if (state.isInWaitingMode()) {
            System.out.println("[ERROR] already in waiting mode");
        } else {
            state.setWaitingMode(true);
        }
    }

}
