package pl.edu.agh.radioactive.radioplayer;

public abstract class PlayerMode {

    public abstract void play(PlayerState state);

    public void stop(PlayerState state) {
        if (state.isInWaitingMode()) {
            System.out.println("[ERROR] already in waiting mode");
        } else {
            state.setInWaitingMode(true);
        }
    }

    public boolean canChangeMode(PlayerState state, PlayerMode newMode) {
        return true;
    }

    public void nextSong(PlayerState state) {
        System.out.println("[INFO] cannot go to the next song in mode " + this + ".");
    }

    public void changeRadioStation(PlayerState state, double frequency) {
        System.out.println("[ERROR] cannot change radio station in " + this + " mode.");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName().replaceFirst("Mode", "");
    }
}
