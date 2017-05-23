package pl.edu.agh.radioactive;

import pl.edu.agh.radioactive.radioplayer.RadioPlayer;
import pl.edu.agh.radioactive.radioplayer.state.CD;
import pl.edu.agh.radioactive.radioplayer.state.entity.Song;

import java.util.Collections;

public class Application {

    public static void main(String[] args) {

        RadioPlayer radioPlayer = new RadioPlayer();
        radioPlayer.turnOn();
        radioPlayer.insertCD(new CD("divide", Collections.singletonList(new Song("Galway girl", "Ed Sheeran"))));
        radioPlayer.playCD();
        radioPlayer.playRadio();

        radioPlayer.changeRadioStation(123.1);
    }

}
