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

    public void turnOn() {
        if (isPowerOn)
            System.out.println("[ERROR] radio is already turned on.");
        else {
            isPowerOn = true;
            System.out.println("[INFO] radio player turned on.");
        }
    }

    public void turnOff() {
        if (!isPowerOn)
            System.out.println("[ERROR] radio already turned off.");
        else {
            isPowerOn = true;
            System.out.println("[INFO] radio player turned off.");
        }
    }

    public boolean isPowerOn() {
        return isPowerOn;
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

    public void setInWaitingMode(boolean waitingMode) {
        this.isInWaitingMode = waitingMode;
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

    public void setRadioFrequency(double radioFrequency) {
        this.radioFrequency = radioFrequency;
    }

}
