package pl.edu.agh.radioactive;

public class Tape {

    private String title;
    private TapeSide side;
    private Song songsLeft;
    private Song songsRight;

    public Tape(String title, Song songsLeft, Song songListRight, TapeSide side) {
        this.title = title;
        this.songsLeft = songsLeft;
        this.songsRight = songListRight;
        this.side = side;
    }

    public TapeSide getSide() {
        return side;
    }

    public Song getSongsLeft() {
        return songsLeft;
    }

    public Song getSongsRight() {
        return songsRight;
    }

    public String getTitle() {
        return title;
    }

    public void changeSide() {
        if (this.side == TapeSide.RIGHT) {
            this.side = TapeSide.LEFT;
        } else {
            this.side = TapeSide.RIGHT;
        }
    }

}
