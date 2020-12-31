import java.util.*;

public class Song
{
    private String name;
    private String artist;
    private String album;
    private int time;

    public Song(String name, String artist, String album, int time) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getTime() {
        return time;
    }
}