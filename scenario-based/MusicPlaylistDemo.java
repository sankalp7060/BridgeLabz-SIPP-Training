import java.util.LinkedList;

public class MusicPlaylistDemo {
    public static void main(String[] args) {
        System.out.println("===== Music Playlist Demo =====");

        MusicPlayer player = new MusicPlayer();
        player.addSong("Believer");
        player.addSong("Faded");
        player.addSong("Closer");

        player.showPlaylist();
        player.playNext();       // plays Believer
        player.playNext();       // plays Faded
        player.removeSong("Closer");
        player.playNext();       // no more songs
    }
}

// Base class to enable polymorphism
class MediaPlayer {
    public void play(String media) {
        System.out.println("Playing: " + media);
    }
}

// Child class for music playback using queue logic
class MusicPlayer extends MediaPlayer {
    private LinkedList<String> playlist = new LinkedList<>();

    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added song: " + song);
    }

    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Removed song: " + song);
        } else {
            System.out.println("Song not found: " + song);
        }
    }

    public void playNext() {
        if (!playlist.isEmpty()) {
            String nextSong = playlist.poll();
            play(nextSong);  // calling base class method
        } else {
            System.out.println("No more songs in the playlist.");
        }
    }

    public void showPlaylist() {
        System.out.println("Current Playlist: " + playlist);
    }
}
