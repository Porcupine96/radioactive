package pl.edu.agh.radioactive.radioplayer;

import pl.edu.agh.radioactive.radioplayer.mode.CDMode;
import pl.edu.agh.radioactive.radioplayer.mode.MemoryCardMode;
import pl.edu.agh.radioactive.radioplayer.mode.RadioMode;
import pl.edu.agh.radioactive.radioplayer.mode.TapeMode;
import pl.edu.agh.radioactive.radioplayer.mode.modetype.ModeType;
import pl.edu.agh.radioactive.radioplayer.state.CD;
import pl.edu.agh.radioactive.radioplayer.state.MemoryCard;
import pl.edu.agh.radioactive.radioplayer.state.Tape;

public class RadioPlayer {

    private PlayerMode mode;
    private final PlayerState state;

    public RadioPlayer() {
        this.state = new PlayerState();
        mode = new CDMode();
    }

    public void turnOn() {
        if (state.isPowerOn())
            System.out.println("[ERROR] radio is already turned on.");
        else {
            state.setPowerOn(true);
            System.out.println("[INFO] radio player turned on.");
        }
    }

    public void turnOff() {
        if (!state.isPowerOn())
            System.out.println("[ERROR] radio already turned off.");
        else {
            state.setPowerOn(false);
            System.out.println("[INFO] radio player turned off.");
        }
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

    public void playCD() {
        changeMode(new CDMode());
        mode.play(state);
    }

    public void playFromMemoryCard() {
        changeMode(new MemoryCardMode());
        mode.play(state);
    }

    public void playFromTape() {
        changeMode(new TapeMode());
        mode.play(state);
    }

    public void playRadio() {
        changeMode(new RadioMode());
        mode.play(state);
    }

    public void stopCD() {
        stop(ModeType.CD);
    }

    public void stopRadio() {
        stop(ModeType.RADIO);
    }

    public void stopMemoryCard() {
        stop(ModeType.MEMORY_CARD);
    }

    public void stopTape() {
        stop(ModeType.TAPE);
    }

    public void goToTheNextSong() {
        if (this.mode.modeType == ModeType.CD) {
            ((CDMode) mode).nextSong(state);
        } else {
            System.out.println("[INFO] cannot go to the next song in mode " + this.mode.modeType + ".");
        }
    }

    public void changeRadioStation(double frequency) {
        if (this.mode.modeType == ModeType.RADIO) {
            System.out.println("[INFO] changing the radio station from " + state.getRadioFrequency() + " to " + frequency + ".");
            this.state.setRadioFrequency(frequency);
        } else {
            System.out.println("[ERROR] cannot change radio station in " + this.mode.modeType + " mode.");
        }
    }

    private void stop(ModeType modeType) {
        if (this.mode.modeType == modeType) {
            mode.pause(state);
        } else {
            System.out.println("[ERROR] cannot stop " + modeType + " while being in " + this.mode.modeType + " mode.");
        }
    }

    private void changeMode(PlayerMode newMode) {
        if (mode.modeType == ModeType.TAPE && state.isInWaitingMode()) {
            System.out.println("[ERROR] cannot change mode without stopping the tape.");
        } else {
            this.mode = newMode;
        }
    }

}
