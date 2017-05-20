package pl.edu.agh.radioactive;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args){
        //System.out.println("No to zaczynamy!");

        Boombox box = new Boombox();
        box.on();
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Wonderful World", "Louis Armstrong"));
        songs.add(new Song("Galway Girl", "Ed Sheran"));

        CD disc = new CD("Hits",songs);

        box.startPlayingCD(disc);
        box.nextSong();
        box.changeRadioProgram(2);
        box.nextSong();
        MemoryCard memoryCard = new MemoryCard(songs);
        box.playMemoryCard(memoryCard);
        Tape tape = new Tape("Classical Music", new Song("ALbum", "Chris"), new Song("ALbum2", "Karoline"),TapeSide.LEFT);
        box.playTape(tape);
        box.changeSide();
        box.playTape(null);
    }

}
