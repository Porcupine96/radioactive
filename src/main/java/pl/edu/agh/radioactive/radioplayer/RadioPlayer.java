package pl.edu.agh.radioactive.radioplayer;

import pl.edu.agh.radioactive.radioplayer.mode.CDMode;
import pl.edu.agh.radioactive.radioplayer.state.CD;
import pl.edu.agh.radioactive.radioplayer.state.MemoryCard;
import pl.edu.agh.radioactive.radioplayer.state.Tape;

public class RadioPlayer {

    private final PlayerMode mode;
    private final PlayerState state;

    public RadioPlayer() {
        this.state = new PlayerState();
        mode = new CDMode();
    }

    public void turnOn() {
        if (state.isPowerOn())
            System.out.println("[ERROR] radio is already turned on.");
        else {
            System.out.println("[INFO] radio player turned on.");
            state.setPowerOn(true);
        }
    }

    public void turnOff() {
        if (!state.isPowerOn())
            System.out.println("[ERROR] radio already turned turned off.");
        else {
            state.setPowerOn(false);
            System.out.println("[INFO] radio player turned off.");
        }
    }

    public void insertCD(CD cd) {
        System.out.println("[INFO] inserting a CD " + cd.getTitle());
        state.insertCD(cd);
    }

    public void insertMemoryCard(MemoryCard memoryCard) {
        System.out.println("[INFO] inserting a memory card " + memoryCard.getCardName());
        state.insertMemoryCard(memoryCard);
    }

    public void insertTape(Tape tape) {
        System.out.println("[INFO] inserting a tape " + tape.getTitle());
        state.insertTape(tape);
    }

    public void playCD() {
        mode.play(state);
    }

}
