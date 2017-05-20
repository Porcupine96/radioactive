package pl.edu.agh.radioactive;
import java.util.List;

public class CD {
    private String title;
    private List<Song> songList;
    private int currentSong;

    public CD(String title, List <Song> songsList)
    {
        this.title = title;
        this.songList = songsList;
        currentSong = 0;
    }

    public String getTitle() {
        return title;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public String getCurrentSong(){
        return songList.get(currentSong).getName() + "  " + songList.get(currentSong).getAuthor() ;
    }

    public void nextSong(){
        if(currentSong + 1 < songList.size())
            currentSong ++;
        else {
            currentSong = 0;
            System.out.print("Playing CD was reversed");
        }
    }

}
