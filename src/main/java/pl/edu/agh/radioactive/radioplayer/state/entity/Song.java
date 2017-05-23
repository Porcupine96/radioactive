package pl.edu.agh.radioactive.radioplayer.state.entity;


public class Song {

    private String name;
    private String author;

    public Song(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return name + " by " + author;
    }

}
