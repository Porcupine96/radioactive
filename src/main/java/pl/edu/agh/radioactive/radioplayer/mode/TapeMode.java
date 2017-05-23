package pl.edu.agh.radioactive.radioplayer.mode;

import pl.edu.agh.radioactive.radioplayer.PlayerMode;
import pl.edu.agh.radioactive.radioplayer.PlayerState;
import pl.edu.agh.radioactive.radioplayer.mode.modetype.ModeType;
import pl.edu.agh.radioactive.radioplayer.state.Tape;

public class TapeMode extends PlayerMode {

    public TapeMode() {
        super(ModeType.TAPE);
    }

    private void withStateValidation(PlayerState state, Runnable action) {
        if (!state.isPowerOn()) {
            System.out.println("[ERROR] cannot play - radio player turned off.");
        } else if (!state.getTape().isPresent()) {
            System.out.println("[ERROR] cannot play - please insert a tape.");
        } else {
            action.run();
        }
    }

    @Override
    public void play(PlayerState state) {
        withStateValidation(state, () -> playCurrentSong(state.getTape().get()));
    }

    private void playCurrentSong(Tape tape) {
        System.out.println("[INFO] playing tape " + tape.getTitle());
    }

}

