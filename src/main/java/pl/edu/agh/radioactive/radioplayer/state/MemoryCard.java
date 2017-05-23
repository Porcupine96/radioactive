package pl.edu.agh.radioactive.radioplayer.state;

import pl.edu.agh.radioactive.radioplayer.state.entity.Song;

import java.util.List;

public class MemoryCard {

    private final String cardName;
    private List<Song> songList;
    private int currentSong;

    public MemoryCard(String cardName, List<Song> songList) {
        this.cardName = cardName;
        this.songList = songList;
        this.currentSong = 0;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public Song getCurrentSong() {
        return songList.get(currentSong);
    }

    public String getCardName() {
        return cardName;
    }

}
