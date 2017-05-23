package pl.edu.agh.radioactive.radioplayer.state;

import pl.edu.agh.radioactive.radioplayer.state.entity.Song;

import java.util.List;

public class MemoryCard {

    private List<Song> songList;
    private int currentSong;

    public MemoryCard(List<Song> songList) {
        this.songList = songList;
        this.currentSong = 0;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public String getCurrentSong() {
        return songList.get(currentSong).getName() + "  " + songList.get(currentSong).getAuthor();
    }

    public void nextSong() {
        if (currentSong + 1 < songList.size())
            currentSong++;
        else {
            currentSong = 0;
            System.out.print("Playing CD was reversed");
        }
    }

}
