package pl.edu.agh.radioactive;

public class Boombox {

    private boolean isPowerOn;
    private Mode mode;
    private Radio radio;
    private CD disc;
    private Tape tape;
    private MemoryCard memoryCard;

    public Boombox() {
        // TODO: mode should not be null
        isPowerOn = false;
        radio = new Radio();
        disc = null;
        tape = null;
        memoryCard = null;
    }

    public void on() {
        if (isPowerOn)
            System.out.println("Error - Radio is already turned on.");
        else {
            System.out.println("Boombox is on.");
            mode = Mode.Wait;
            isPowerOn = true;
        }
    }

    public void off() {
        if (!isPowerOn)
            System.out.println("Error - Radio is already turned off.");
        else {
            isPowerOn = false;
            System.out.println("Power is off.");
        }
    }

    public void startPlayingCD(CD disc) {
        if (isPowerOn) {
            this.mode = Mode.CD;
            this.disc = disc;
            playCurrentSong();
        } else {
            System.out.println("Power is off. I can't play CD.");
        }
    }

    public void stopPlayingCD() {
        if (!isPowerOn) {
            System.out.println("Power is off.");
        } else if (mode != Mode.CD) {
            System.out.println("Error - wrong mode");
            printCurrentPlayed();
        } else {
            System.out.println("Playing CD was stopped.");
            mode = Mode.Wait;
        }
    }

    public void nextSong() {
        if (mode != Mode.CD || !isPowerOn) {
            System.out.println("Error - You need to change to CD mode.");
            printCurrentPlayed();
        } else if (disc == null) {
            System.out.println("Error - Please insert a CD to play.");
        } else {
            disc.nextSong();
            playCurrentSong();
        }
    }

    private void playCurrentSong() {
        System.out.println("CD title: " + disc.getTitle());
        System.out.println("Song title: " + disc.getCurrentSong());
    }

    public void playMemoryCard(MemoryCard givenCard) {
        if (!isPowerOn) {
            System.out.println("Power is off. I can't play music from memory card.");
        } else {
            if (memoryCard == null && givenCard == null) {
                System.out.println("I have no tape to play from.");
                return;
            } else if (givenCard != null) {
                memoryCard = givenCard;
            }
            mode = Mode.MemoryCard;
            System.out.println("Reading memory card");
            System.out.println("Played song: " + memoryCard.getCurrentSong());
        }
    }

    public void playTape(Tape givenTape) {
        if (!isPowerOn) {
            System.out.println("Power is off. I can't play tape");
        } else {
            if (tape == null && givenTape == null) {
                System.out.println("There is no tape to play.");
                return;
            } else if (givenTape != null) {
                tape = givenTape;
            }
            mode = Mode.Tape;
            playTapeSide(tape.getSide());
        }
    }

    private void playTapeSide(TapeSide side) {
        System.out.println("I am playing music from tape named: " + tape.getTitle());
        if (side == TapeSide.LEFT) {
            System.out.println("I am playing songs " + tape.getSongsLeft().getName());
        } else
            System.out.println("I am playing songs " + tape.getSongsRight().getName());
    }

    public void playRadio() {
        if (!isPowerOn) {
            System.out.println("Power is off. I can't play Radio.");
        } else {
            mode = Mode.Radio;
            System.out.println("Playing the radio");
            System.out.println("Station: " + radio.getRadioProgram());
        }
    }

    private void printCurrentPlayed() {
        System.out.println("I am playing mode" + mode);
    }


    public void changeRadioProgram(int nr) {
        if (mode != Mode.Radio) {
            System.out.println("Error - Radio is not in radio mode.");
            printCurrentPlayed();
        } else {
            radio.changeProgram(nr);
            System.out.println("Radio station was changed." + radio.getRadioProgram());
        }
    }

    public void pause() {
        mode = Mode.Wait;
        System.out.println("Pause...");
    }

    public void changeSide() {
        if (mode != Mode.Tape) {
            System.out.println("Error - Radio is not in tape mode.");
            printCurrentPlayed();
        } else {
            tape.changeSide();
            System.out.println("Tape side was changed.");
        }
    }

}
