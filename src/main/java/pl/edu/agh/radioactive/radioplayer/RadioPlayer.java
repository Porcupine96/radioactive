package pl.edu.agh.radioactive.radioplayer;

import pl.edu.agh.radioactive.radioplayer.mode.CDMode;
import pl.edu.agh.radioactive.radioplayer.state.CD;
import pl.edu.agh.radioactive.radioplayer.state.MemoryCard;
import pl.edu.agh.radioactive.radioplayer.state.Tape;

public class RadioPlayer {

    private final PlayerState state;
    private PlayerMode mode;

    public RadioPlayer() {
        this.state = new PlayerState();
        mode = new CDMode();
    }

    public void turnOn() {
        state.turnOn();
    }

    public void turnOff() {
        state.turnOff();
    }

    public void insertCD(CD cd) {
        System.out.println("[INFO] inserting a CD " + cd.getTitle() + ".");
        state.insertCD(cd);
    }

    public void insertMemoryCard(MemoryCard memoryCard) {
        System.out.println("[INFO] inserting a memory card " + memoryCard.getCardName() + ".");
        state.insertMemoryCard(memoryCard);
    }

    public void insertTape(Tape tape) {
        System.out.println("[INFO] inserting a tape " + tape.getTitle() + ".");
        state.insertTape(tape);
    }


    public void play() {
        mode.play(state);
    }

    public void stop() {
        mode.stop(state);
    }

    public void nextSong() {
        mode.nextSong(state);
    }

    public void changeRadioStation(double frequency) {
        mode.changeRadioStation(state, frequency);
    }

    public boolean changeMode(PlayerMode newMode) {
        if (!mode.canChangeMode(state, newMode)) return false;

        mode = newMode;
        return true;
    }

}
