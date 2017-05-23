package pl.edu.agh.radioactive.radioplayer;

public abstract class PlayerMode {

    public abstract void play(PlayerState state);

    public void pause(PlayerState state) {
        if (state.isInWaitingMode()) {
            System.out.println("[ERROR] already in waiting mode");
        } else {
            state.setWaitingMode(true);
        }
    }

}
