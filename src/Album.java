import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;
    private String name;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    boolean findSong(String name) {
        for (Song song : songs) {
            if (song.getTitle().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbums(String title, double duration) {
        if (!findSong(title)) {
            Song song = new Song(title, duration);
            this.songs.add(song);
            return "song has been added to the albums";
        }
        return "song already exists";
    }

    public String addToListFromAlbum(String title, LinkedList<Song> playList) {
//         if(findSong(title)){
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                playList.add(song);
                return "Song has been added to your playlist";
            }
        }
//         }
        return "Song doesnt exist in album";
    }

    /**
     * polymorphism:method overloading
     * @param songNo
     * @param playList
     * @return
     */
    public String addToListFromAlbum(int songNo,LinkedList<Song> playList){
        int index=songNo-1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
            return"Song has been added successfully";
        }
        return "incorrect song name";
    }

}
