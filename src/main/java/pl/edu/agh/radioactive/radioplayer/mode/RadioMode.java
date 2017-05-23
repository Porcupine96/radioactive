package pl.edu.agh.radioactive.radioplayer.mode;

import pl.edu.agh.radioactive.radioplayer.PlayerMode;
import pl.edu.agh.radioactive.radioplayer.PlayerState;

public class RadioMode extends PlayerMode {

    private double frequency;

    public RadioMode() {
        frequency = 96.7;
    }

    @Override
    public void play(PlayerState state) {
        // TODO: implement
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

}
