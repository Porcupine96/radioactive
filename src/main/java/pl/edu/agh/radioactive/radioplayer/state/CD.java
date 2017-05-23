package pl.edu.agh.radioactive.radioplayer.state;

import pl.edu.agh.radioactive.radioplayer.state.entity.Song;

import java.util.List;

public class CD {

    private String title;
    private List<Song> songList;
    private int currentSong;

    public CD(String title, List<Song> songsList) {
        this.title = title;
        this.songList = songsList;
        currentSong = 0;
    }

    public void nextSong() {
        currentSong = (currentSong + 1) % songList.size();
    }

    public String getTitle() {
        return title;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public String getCurrentSong() {
        return songList.get(currentSong).getName() + " by " + songList.get(currentSong).getAuthor();
    }

}
