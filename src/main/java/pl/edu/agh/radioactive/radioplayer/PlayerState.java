package pl.edu.agh.radioactive.radioplayer;

import pl.edu.agh.radioactive.radioplayer.state.CD;
import pl.edu.agh.radioactive.radioplayer.state.MemoryCard;
import pl.edu.agh.radioactive.radioplayer.state.Tape;

import java.util.Optional;

public class PlayerState {

    private boolean isPowerOn;
    private boolean isInWaitingMode;

    private CD cd;
    private MemoryCard memoryCard;
    private Tape tape;
    private double radioFrequency;

    public PlayerState() {
        this.isPowerOn = false;
        this.isInWaitingMode = true;
        this.radioFrequency = 96.7;
    }

    public boolean isPowerOn() {
        return isPowerOn;
    }

    public void setPowerOn(boolean powerOn) {
        isPowerOn = powerOn;
    }

    void insertCD(CD cd) {
        this.cd = cd;
    }

    void insertMemoryCard(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    public void insertTape(Tape tape) {
        this.tape = tape;
    }

    public boolean isInWaitingMode() {
        return isInWaitingMode;
    }

    public void setWaitingMode(boolean waitingMode) {
        this.isInWaitingMode = waitingMode;
    }

    public void setRadioFrequency(double radioFrequency) {
        this.radioFrequency = radioFrequency;
    }

    public Optional<CD> getCd() {
        return Optional.ofNullable(cd);
    }

    public Optional<MemoryCard> getMemoryCard() {
        return Optional.ofNullable(memoryCard);
    }

    public Optional<Tape> getTape() {
        return Optional.ofNullable(tape);
    }

    public double getRadioFrequency() {
        return radioFrequency;
    }

}
