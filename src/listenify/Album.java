package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Album {
    public String albumName;
    public String artistName;
    public List<Song> songList;

    // Initialize the songList
    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSong(String title) {
        // Iterate over the arrayList and match
        // each song tile with title
        for (Song song : songList) {
            if (song.title.compareTo(title) == 0) { // checks lexographically
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title, double duration) {

        // check if the song is already in the list, we will not add
        // otherwise we will create a new Song and add it to the songList
        if (findSong(title)) {
            return "Song is already present";
        }
        else {
            // I need to create a Song and add it to songList
            Song song = new Song(title, duration);
            songList.add(song);
            return "New Song has been added";
        }
    }

    public String addSongToPlayList(int trackNo, LinkedList<Song> playList) {

        // TrackNo is song number in the songList

        // TrackNo : 1,2,3,4,5....
        // Indices : 0,1,2,3,4....
        int index = trackNo - 1;

        // checking for validity
        if (index >= 0 && index < this.songList.size()) {
            // extract song from songList
            Song song = this.songList.get(index);
            playList.add(song);
            return "Song has been added to the playList";
        }
        return "Invalid track No";
    }

    public String addSongToPlayList(String title, LinkedList<Song> playList) {

        // I need to find out that Song with that title
        // and put it in the playList

        // Iterate :
        for (Song song : songList) {
            if (song.title == title) {
                playList.add(song);
                return "Song has been added successfully";
            }
        }
        return "Song doesn't exist";
    }
}
