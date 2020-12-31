import java.util.*;

public class PlaylistTest
{
    public static void main(String[] args) {
        Song song1 = new Song("Where are you going", "Dave Matthews Band", "Busted Stuff", 232);
        Song song2 = new Song("Flake", "Jack Johnson", "Bushfire FiaryTales", 283);
        Playlist summerJamz2019 = new Playlist("AKC's List");
        summerJamz2019.addSong(song1);
        summerJamz2019.addSong(song2);
    }
}