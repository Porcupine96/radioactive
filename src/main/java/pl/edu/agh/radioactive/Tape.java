package pl.edu.agh.radioactive;

import java.util.List;

public class Tape {
    private String title;

    public TapeSide getSide() {
        return side;
    }

    private TapeSide side;

    public Song getSongsLeft() {
        return songsLeft;
    }

    public Song getSongsRight() {
        return songsRight;
    }

    private Song songsLeft;
    private Song songsRight;


    public Tape(String title,Song songsLeft, Song songListRight, TapeSide side) {
        this.title = title;
        this.songsLeft = songsLeft;
        this.songsRight = songListRight;
        this.side = side;
    }


    public String getTitle() {
        return title;
    }

    public void changeSide(){
        if(this.side == TapeSide.RIGHT) {
            this.side = TapeSide.LEFT;
        }
        else this.side = TapeSide.RIGHT;
    }

}
