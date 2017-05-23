package pl.edu.agh.radioactive.radioplayer;

import pl.edu.agh.radioactive.radioplayer.mode.modetype.ModeType;

public abstract class PlayerMode {

    protected final ModeType modeType;

    protected PlayerMode(ModeType modeType) {
        this.modeType = modeType;
    }

    public abstract void play(PlayerState state);

    public void pause(PlayerState state) {
        if (state.isInWaitingMode()) {
            System.out.println("[ERROR] already in waiting mode");
        } else {
            state.setWaitingMode(true);
        }
    }

}
