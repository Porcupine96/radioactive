package pl.edu.agh.radioactive.radioplayer.mode;

import pl.edu.agh.radioactive.radioplayer.PlayerMode;
import pl.edu.agh.radioactive.radioplayer.PlayerState;
import pl.edu.agh.radioactive.radioplayer.mode.modetype.ModeType;

public class RadioMode extends PlayerMode {

    public RadioMode() {
        super(ModeType.RADIO);
    }

    @Override
    public void play(PlayerState state) {
        withStateValidation(state, () -> playCurrentStation(state.getRadioFrequency()));
    }

    private void withStateValidation(PlayerState state, Runnable action) {
        if (!state.isPowerOn()) {
            System.out.println("[ERROR] cannot play - radio player turned off.");
        } else {
            action.run();
        }
    }

    private void playCurrentStation(double frequency) {
        System.out.println("[INFO] playing radio station " + frequency + ".");
    }

}
